main :: IO ()
main = do
	putStrLn "Enter two lines"
	line1 <- getLine                                    -- line1 :: String
	line2 <- getLine                                    -- line2 :: String
	putStrLn ("you said: " ++ line1 ++ " and " ++ line2)
