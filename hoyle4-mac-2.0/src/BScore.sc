;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 704)
(include sci.sh)
(use Main)
(use System)

(class BScore of Obj
	(properties
		weGame1 0
		weGame2 0
		weGame3 0
		weRubberBonus 0
		weSlamBonus 0
		weMadeDoubled 0
		weHonors 0
		weOvertricks 0
		weUndertricks 0
		weTotal 0
		weOverLine 0
		wePrevOverLine 0
		weGamesWon 0
		weHandTotal 0
		weTricksWon 0
		weVulnerable 0
		theyGame1 0
		theyGame2 0
		theyGame3 0
		theyRubberBonus 0
		theySlamBonus 0
		theyMadeDoubled 0
		theyHonors 0
		theyOvertricks 0
		theyUndertricks 0
		theyTotal 0
		theyPrevOverLine 0
		theyOverLine 0
		theyGamesWon 0
		theyHandTotal 0
		theyTricksWon 0
		theyVulnerable 0
		prevWeGame1 0
		prevWeGame2 0
		prevWeGame3 0
		prevWeRubberBonus 0
		prevWeSlamBonus 0
		prevWeMadeDoubled 0
		prevWeHonors 0
		prevWeOvertricks 0
		prevWeUndertricks 0
		prevWeTotal 0
		prevWeOverLine 0
		prevWePrevOverLine 0
		prevWeGamesWon 0
		prevWeHandTotal 0
		prevWeTricksWon 0
		prevWeVulnerable 0
		prevTheyGame1 0
		prevTheyGame2 0
		prevTheyGame3 0
		prevTheyRubberBonus 0
		prevTheySlamBonus 0
		prevTheyMadeDoubled 0
		prevTheyHonors 0
		prevTheyOvertricks 0
		prevTheyUndertricks 0
		prevTheyTotal 0
		prevTheyPrevOverLine 0
		prevTheyOverLine 0
		prevTheyGamesWon 0
		prevTheyHandTotal 0
		prevTheyTricksWon 0
		prevTheyVulnerable 0
		gameNumber 0
		gameOver 0
		rubberOver 0
		prevGameNumber 0
		prevGameOver 0
		prevRubberOver 0
	)

	(method (rubberInit)
		(= rubberOver
			(= gameNumber
				(= theyGamesWon
					(= theyVulnerable
						(= theyPrevOverLine
							(= theyOverLine
								(= theyTotal
									(= theyUndertricks
										(= theyOvertricks
											(= theyHonors
												(= theyMadeDoubled
													(= theySlamBonus
														(= theyRubberBonus
															(= theyGame3
																(= theyGame2
																	(= theyGame1
																		(=
																			weGamesWon
																			(=
																				weVulnerable
																				(=
																					wePrevOverLine
																					(=
																						weOverLine
																						(=
																							weTotal
																							(=
																								weUndertricks
																								(=
																									weOvertricks
																									(=
																										weHonors
																										(=
																											weMadeDoubled
																											(=
																												weSlamBonus
																												(=
																													weRubberBonus
																													(=
																														weGame3
																														(=
																															weGame2
																															(=
																																weGame1
																																0
																															)
																														)
																													)
																												)
																											)
																										)
																									)
																								)
																							)
																						)
																					)
																				)
																			)
																		)
																	)
																)
															)
														)
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
			)
		)
		(self gameInit:)
	)

	(method (savePrev)
		(= prevWeGame1 weGame1)
		(= prevWeGame2 weGame2)
		(= prevWeGame3 weGame3)
		(= prevWeRubberBonus weRubberBonus)
		(= prevWeSlamBonus weSlamBonus)
		(= prevWeMadeDoubled weMadeDoubled)
		(= prevWeHonors weHonors)
		(= prevWeOvertricks weOvertricks)
		(= prevWeUndertricks weUndertricks)
		(= prevWeTotal weTotal)
		(= prevWeOverLine weOverLine)
		(= prevWePrevOverLine wePrevOverLine)
		(= prevWeVulnerable weVulnerable)
		(= prevWeGamesWon weGamesWon)
		(= prevTheyGame1 theyGame1)
		(= prevTheyGame2 theyGame2)
		(= prevTheyGame3 theyGame3)
		(= prevTheyRubberBonus theyRubberBonus)
		(= prevTheySlamBonus theySlamBonus)
		(= prevTheyMadeDoubled theyMadeDoubled)
		(= prevTheyHonors theyHonors)
		(= prevTheyOvertricks theyOvertricks)
		(= prevTheyUndertricks theyUndertricks)
		(= prevTheyTotal theyTotal)
		(= prevTheyOverLine theyOverLine)
		(= prevTheyPrevOverLine theyPrevOverLine)
		(= prevTheyVulnerable theyVulnerable)
		(= prevTheyGamesWon theyGamesWon)
		(= prevGameNumber gameNumber)
		(= prevGameOver gameOver)
		(= prevRubberOver rubberOver)
	)

	(method (restorePrev)
		(= weGame1 prevWeGame1)
		(= weGame2 prevWeGame2)
		(= weGame3 prevWeGame3)
		(= weRubberBonus prevWeRubberBonus)
		(= weSlamBonus prevWeSlamBonus)
		(= weMadeDoubled prevWeMadeDoubled)
		(= weHonors prevWeHonors)
		(= weOvertricks prevWeOvertricks)
		(= weUndertricks prevWeUndertricks)
		(= weTotal prevWeTotal)
		(= weOverLine prevWeOverLine)
		(= wePrevOverLine prevWePrevOverLine)
		(= weVulnerable prevWeVulnerable)
		(= weGamesWon prevWeGamesWon)
		(= theyGame1 prevTheyGame1)
		(= theyGame2 prevTheyGame2)
		(= theyGame3 prevTheyGame3)
		(= theyRubberBonus prevTheyRubberBonus)
		(= theySlamBonus prevTheySlamBonus)
		(= theyMadeDoubled prevTheyMadeDoubled)
		(= theyHonors prevTheyHonors)
		(= theyOvertricks prevTheyOvertricks)
		(= theyUndertricks prevTheyUndertricks)
		(= theyTotal prevTheyTotal)
		(= theyOverLine prevTheyOverLine)
		(= theyPrevOverLine prevTheyPrevOverLine)
		(= theyVulnerable prevTheyVulnerable)
		(= theyGamesWon prevTheyGamesWon)
		(= gameNumber prevGameNumber)
		(= gameOver prevGameOver)
		(= rubberOver prevRubberOver)
	)

	(method (gameInit)
		(++ gameNumber)
		(= gameOver 0)
		(self handInit:)
	)

	(method (handInit)
		(= global433
			(= theyTricksWon
				(= theyHandTotal
					(= theyUndertricks
						(= theyOvertricks
							(= theyHonors
								(= theyMadeDoubled
									(= theySlamBonus
										(= weTricksWon
											(= weHandTotal
												(= weUndertricks
													(= weOvertricks
														(= weHonors
															(= weMadeDoubled
																(= weSlamBonus
																	0
																)
															)
														)
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
			)
		)
	)

	(method (addOverLine param1 param2)
		(if (== param2 0)
			(+= weOverLine param1)
		else
			(+= theyOverLine param1)
		)
	)

	(method (addScore)
		(if weHandTotal
			(switch gameNumber
				(1
					(if (>= (+= weGame1 weHandTotal) 100)
						(++ weGamesWon)
						(= gameOver 1)
					)
				)
				(2
					(if (>= (+= weGame2 weHandTotal) 100)
						(++ weGamesWon)
						(= gameOver 1)
					)
				)
				(3
					(if (>= (+= weGame3 weHandTotal) 100)
						(++ weGamesWon)
						(= gameOver 1)
					)
				)
			)
		else
			(switch gameNumber
				(1
					(if (>= (+= theyGame1 theyHandTotal) 100)
						(++ theyGamesWon)
						(= gameOver 1)
					)
				)
				(2
					(if (>= (+= theyGame2 theyHandTotal) 100)
						(++ theyGamesWon)
						(= gameOver 1)
					)
				)
				(3
					(if (>= (+= theyGame3 theyHandTotal) 100)
						(++ theyGamesWon)
						(= gameOver 1)
					)
				)
			)
		)
		(if (or (== weGamesWon 2) (== theyGamesWon 2))
			(= rubberOver 1)
			(if (== weGamesWon 2)
				(gSound2 play: 707)
				(= weRubberBonus (if (not theyGamesWon) 700 else 500))
				(self addOverLine: weRubberBonus 0)
			else
				(= theyRubberBonus (if (not weGamesWon) 700 else 500))
				(self addOverLine: theyRubberBonus 1)
			)
		)
		(= weTotal (+ weOverLine weGame1 weGame2 weGame3))
		(= theyTotal (+ theyOverLine theyGame1 theyGame2 theyGame3))
	)
)

