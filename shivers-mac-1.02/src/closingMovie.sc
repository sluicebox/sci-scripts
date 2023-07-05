;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 935)
(include sci.sh)
(use Main)
(use n951)
(use Movie)
(use Plane)
(use Str)
(use System)

(public
	closingMovie 0
)

(local
	local0
)

(instance closingMovie of ShiversRoom
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(SetFlag 57)
		(gMouseDownHandler add: gCurRoom)
		(gKeyDownHandler add: gCurRoom)
		(super init: &rest)
		(if (IsFlag 39)
			(if (IsFlag 38)
				(= temp0 54)
				(= temp1 16)
			else
				(= temp0 182)
				(= temp1 102)
			)
			(= temp2 ((VmdMovie new:) open: 39260 client: self yourself:))
			(temp2 caller: self)
			(if (IsFlag 38)
				(temp2 put: temp0 temp1 5)
			else
				(temp2 put: temp0 temp1 4)
			)
			(if (== (temp2 setWaitEvent: 23 5) 1)
				(= temp3
					(Str format: { (Sounds of generator being overworked)})
				)
				(self drawText: temp3 0 18 220)
				(temp3 data: 0 dispose:)
				(if (== (temp2 setWaitEvent: 23 100) 1)
					(= temp3 (Str format: { POP!}))
					(self drawText: temp3 0 18 220)
					(temp3 data: 0 dispose:)
					(if (== (temp2 setWaitEvent: 23 105) 1)
						(= temp3 (Str format: { POP! BANG!}))
						(self drawText: temp3 0 18 220)
						(temp3 data: 0 dispose:)
						(if (== (temp2 setWaitEvent: 23 110) 1)
							(= temp3 (Str format: { POP! BANG! POW!}))
							(self drawText: temp3 0 18 220)
							(temp3 data: 0 dispose:)
							(if (== (temp2 setWaitEvent: 23 120) 1)
								(= temp3 (Str format: { Shatter!}))
								(self drawText: temp3 0 18 220)
								(temp3 data: 0 dispose:)
								(if (== (temp2 setWaitEvent: 23 130) 1)
									(= temp3 (Str format: { Shatter!\nClank!}))
									(self drawText: temp3 0 18 220)
									(temp3 data: 0 dispose:)
									(if (== (temp2 setWaitEvent: 23 135) 1)
										(= temp3
											(Str
												format:
													{ Shatter! Tinkle!\nClank!\nCrash!}
											)
										)
										(self drawText: temp3 0 18 220)
										(temp3 data: 0 dispose:)
										(if (== (temp2 setWaitEvent: 23 140) 1)
											(= temp3
												(Str
													format:
														{ Shatter! Tinkle!\nClank! Bonk!\nCrash!}
												)
											)
											(self drawText: temp3 0 18 220)
											(temp3 data: 0 dispose:)
											(if
												(==
													(temp2 setWaitEvent: 23 145)
													1
												)
												(= temp3
													(Str
														format:
															{ Shatter! Tinkle! Bang!\nClank! Bonk!\nCrash! Boom!}
													)
												)
												(self drawText: temp3 0 18 220)
												(temp3 data: 0 dispose:)
												(if
													(==
														(temp2
															setWaitEvent: 23 150
														)
														1
													)
													(= temp3
														(Str
															format:
																{ Shatter! Tinkle! Bang!\nClank! Bonk! Tinkle!\nCrash! Boom! Crinkle!}
														)
													)
													(self
														drawText: temp3 0 18 220
													)
													(temp3 data: 0 dispose:)
													(if
														(==
															(temp2
																setWaitEvent:
																	23
																	155
															)
															1
														)
														(= temp3
															(Str
																format:
																	{ Shatter! Tinkle! Bang! Womp!\nClank! Bonk! Tinkle!\nCrash! Boom! Crinkle! Boom!}
															)
														)
														(self
															drawText:
																temp3
																0
																18
																220
														)
														(temp3 data: 0 dispose:)
														(if
															(==
																(temp2
																	setWaitEvent:
																		23
																		190
																)
																1
															)
															(= temp3
																(Str
																	format:
																		{ Chink. Tinkle.}
																)
															)
															(self
																drawText:
																	temp3
																	0
																	18
																	220
															)
															(temp3
																data: 0
																dispose:
															)
															(if
																(==
																	(temp2
																		setWaitEvent:
																			23
																			195
																	)
																	1
																)
																(= temp3
																	(Str
																		format:
																			{ Chink. Tinkle. Clank.}
																	)
																)
																(self
																	drawText:
																		temp3
																		0
																		18
																		220
																)
																(temp3
																	data: 0
																	dispose:
																)
																(if
																	(==
																		(temp2
																			setWaitEvent:
																				23
																				220
																		)
																		1
																	)
																	(= temp3
																		(Str
																			format:
																				{ Chink. Tinkle. Clank. Whoosh.}
																		)
																	)
																	(self
																		drawText:
																			temp3
																			0
																			18
																			220
																	)
																	(temp3
																		data: 0
																		dispose:
																	)
																	(if
																		(==
																			(temp2
																				setWaitEvent:
																					23
																					285
																			)
																			1
																		)
																		(= temp3
																			(Str
																				format:
																					{ Hisssss...}
																			)
																		)
																		(self
																			drawText:
																				temp3
																				0
																				18
																				220
																		)
																		(temp3
																			data:
																				0
																			dispose:
																		)
																		(if
																			(==
																				(temp2
																					setWaitEvent:
																						23
																						310
																				)
																				1
																			)
																			(=
																				temp3
																				(Str
																					format:
																						{ Hisssss...Hissss}
																				)
																			)
																			(self
																				drawText:
																					temp3
																					0
																					18
																					220
																			)
																			(temp3
																				data:
																					0
																				dispose:
																			)
																			(if
																				(==
																					(temp2
																						setWaitEvent:
																							23
																							345
																					)
																					1
																				)
																				(=
																					temp3
																					(Str
																						format:
																							{ Come on!}
																					)
																				)
																				(self
																					drawText:
																						temp3
																						0
																						18
																						220
																				)
																				(temp3
																					data:
																						0
																					dispose:
																				)
																				(if
																					(==
																						(temp2
																							setWaitEvent:
																								23
																								360
																						)
																						1
																					)
																					(=
																						temp3
																						(Str
																							format:
																								{ Come on!\nAre you OK Kim?}
																						)
																					)
																					(self
																						drawText:
																							temp3
																							0
																							18
																							220
																					)
																					(temp3
																						data:
																							0
																						dispose:
																					)
																					(if
																						(==
																							(temp2
																								setWaitEvent:
																									23
																									370
																							)
																							1
																						)
																						(=
																							temp3
																							(Str
																								format:
																									{ Come on!\nAre you OK Kim?\nHurry it up.}
																							)
																						)
																						(self
																							drawText:
																								temp3
																								0
																								18
																								220
																						)
																						(temp3
																							data:
																								0
																							dispose:
																						)
																						(if
																							(==
																								(temp2
																									setWaitEvent:
																										23
																										382
																								)
																								1
																							)
																							(=
																								temp3
																								(Str
																									format:
																										{ Come on!\nAre you OK Kim?\nHurry it up.\nWould you wait up for me?}
																								)
																							)
																							(self
																								drawText:
																									temp3
																									0
																									18
																									220
																							)
																							(temp3
																								data:
																									0
																								dispose:
																							)
																							(if
																								(==
																									(temp2
																										setWaitEvent:
																											23
																											395
																									)
																									1
																								)
																								(=
																									temp3
																									(Str
																										format:
																											{ Would you guys look at this?}
																									)
																								)
																								(self
																									drawText:
																										temp3
																										0
																										18
																										220
																								)
																								(temp3
																									data:
																										0
																									dispose:
																								)
																								(if
																									(==
																										(temp2
																											setWaitEvent:
																												23
																												432
																										)
																										1
																									)
																									(=
																										temp3
																										(Str
																											format:
																												{ Hey you can bet the cops are on their way already.}
																										)
																									)
																									(self
																										drawText:
																											temp3
																											0
																											18
																											220
																									)
																									(temp3
																										data:
																											0
																										dispose:
																									)
																									(if
																										(==
																											(temp2
																												setWaitEvent:
																													23
																													470
																											)
																											1
																										)
																										(=
																											temp3
																											(Str
																												format:
																													{ You guys think everything is alright?}
																											)
																										)
																										(self
																											drawText:
																												temp3
																												0
																												18
																												220
																										)
																										(temp3
																											data:
																												0
																											dispose:
																										)
																										(if
																											(==
																												(temp2
																													setWaitEvent:
																														23
																														482
																												)
																												1
																											)
																											(=
																												temp3
																												(Str
																													format:
																														{ I don't know but this...}
																												)
																											)
																											(self
																												drawText:
																													temp3
																													0
																													18
																													220
																											)
																											(temp3
																												data:
																													0
																												dispose:
																											)
																											(if
																												(==
																													(temp2
																														setWaitEvent:
																															23
																															505
																													)
																													1
																												)
																												(=
																													temp3
																													(Str
																														format:
																															{ I don't know but this...oh this is amazing!}
																													)
																												)
																												(self
																													drawText:
																														temp3
																														0
																														18
																														220
																												)
																												(temp3
																													data:
																														0
																													dispose:
																												)
																												(if
																													(==
																														(temp2
																															setWaitEvent:
																																23
																																540
																														)
																														1
																													)
																													(=
																														temp3
																														(Str
																															format:
																																{ Hey!}
																														)
																													)
																													(self
																														drawText:
																															temp3
																															0
																															18
																															220
																													)
																													(temp3
																														data:
																															0
																														dispose:
																													)
																													(if
																														(==
																															(temp2
																																setWaitEvent:
																																	23
																																	550
																															)
																															1
																														)
																														(=
																															temp3
																															(Str
																																format:
																																	{ Hey! Hey is that you in there?}
																															)
																														)
																														(self
																															drawText:
																																temp3
																																0
																																18
																																220
																														)
																														(temp3
																															data:
																																0
																															dispose:
																														)
																														(if
																															(==
																																(temp2
																																	setWaitEvent:
																																		23
																																		565
																																)
																																1
																															)
																															(=
																																temp3
																																(Str
																																	format:
																																		{ Hey look!}
																																)
																															)
																															(self
																																drawText:
																																	temp3
																																	0
																																	18
																																	220
																															)
																															(temp3
																																data:
																																	0
																																dispose:
																															)
																															(if
																																(==
																																	(temp2
																																		setWaitEvent:
																																			23
																																			575
																																	)
																																	1
																																)
																																(=
																																	temp3
																																	(Str
																																		format:
																																			{ Oh man.}
																																	)
																																)
																																(self
																																	drawText:
																																		temp3
																																		0
																																		18
																																		220
																																)
																																(temp3
																																	data:
																																		0
																																	dispose:
																																)
																																(if
																																	(==
																																		(temp2
																																			setWaitEvent:
																																				23
																																				585
																																		)
																																		1
																																	)
																																	(=
																																		temp3
																																		(Str
																																			format:
																																				{ Oh man. We've been looking everywhere for you.}
																																		)
																																	)
																																	(self
																																		drawText:
																																			temp3
																																			0
																																			18
																																			220
																																	)
																																	(temp3
																																		data:
																																			0
																																		dispose:
																																	)
																																	(if
																																		(==
																																			(temp2
																																				setWaitEvent:
																																					23
																																					612
																																			)
																																			1
																																		)
																																		(=
																																			temp3
																																			(Str
																																				format:
																																					{ Did you blow this up?}
																																			)
																																		)
																																		(self
																																			drawText:
																																				temp3
																																				0
																																				18
																																				220
																																		)
																																		(temp3
																																			data:
																																				0
																																			dispose:
																																		)
																																		(if
																																			(==
																																				(temp2
																																					setWaitEvent:
																																						23
																																						632
																																				)
																																				1
																																			)
																																			(=
																																				temp3
																																				(Str
																																					format:
																																						{ How'd you get in the museum?}
																																				)
																																			)
																																			(self
																																				drawText:
																																					temp3
																																					0
																																					18
																																					220
																																			)
																																			(temp3
																																				data:
																																					0
																																				dispose:
																																			)
																																			(if
																																				(==
																																					(temp2
																																						setWaitEvent:
																																							23
																																							652
																																					)
																																					1
																																				)
																																				(=
																																					temp3
																																					(Str
																																						format:
																																							{ Are you alright?}
																																					)
																																				)
																																				(self
																																					drawText:
																																						temp3
																																						0
																																						18
																																						220
																																				)
																																				(temp3
																																					data:
																																						0
																																					dispose:
																																				)
																																				(if
																																					(==
																																						(temp2
																																							setWaitEvent:
																																								23
																																								660
																																						)
																																						1
																																					)
																																					(=
																																						temp3
																																						(Str
																																							format:
																																								{ Are you alright?\nOf course you're alright.}
																																						)
																																					)
																																					(self
																																						drawText:
																																							temp3
																																							0
																																							18
																																							220
																																					)
																																					(temp3
																																						data:
																																							0
																																						dispose:
																																					)
																																					(if
																																						(==
																																							(temp2
																																								setWaitEvent:
																																									23
																																									680
																																							)
																																							1
																																						)
																																						(=
																																							temp3
																																							(Str
																																								format:
																																									{ This doesn't look like much of a museum to me.}
																																							)
																																						)
																																						(self
																																							drawText:
																																								temp3
																																								0
																																								18
																																								220
																																						)
																																						(temp3
																																							data:
																																								0
																																							dispose:
																																						)
																																						(if
																																							(==
																																								(temp2
																																									setWaitEvent:
																																										23
																																										710
																																								)
																																								1
																																							)
																																							(=
																																								temp3
																																								(Str
																																									format:
																																										{ Did you find the ghosts?}
																																								)
																																							)
																																							(self
																																								drawText:
																																									temp3
																																									0
																																									18
																																									220
																																							)
																																							(temp3
																																								data:
																																									0
																																								dispose:
																																							)
																																							(if
																																								(==
																																									(temp2
																																										setWaitEvent:
																																											23
																																											745
																																									)
																																									1
																																								)
																																								(=
																																									temp3
																																									(Str
																																										format:
																																											{ Oh...}
																																									)
																																								)
																																								(self
																																									drawText:
																																										temp3
																																										0
																																										18
																																										220
																																								)
																																								(temp3
																																									data:
																																										0
																																									dispose:
																																								)
																																								(if
																																									(==
																																										(temp2
																																											setWaitEvent:
																																												23
																																												775
																																										)
																																										1
																																									)
																																									(=
																																										temp3
																																										(Str
																																											format:
																																												{ (Flashbulb going off)}
																																										)
																																									)
																																									(self
																																										drawText:
																																											temp3
																																											0
																																											18
																																											220
																																									)
																																									(temp3
																																										data:
																																											0
																																										dispose:
																																									)
																																									(if
																																										(==
																																											(temp2
																																												setWaitEvent:
																																													23
																																													840
																																											)
																																											1
																																										)
																																										(self
																																											eraseText:
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
			(temp2 close:)
		else
			(self playVMD: 39260 self)
		)
		(gCurRoom setScript: sFadeOutBecauseGuySaidSo)
	)

	(method (doVerb)
		(gCurRoom eraseText:)
		(gSounds stop: 25004)
		(if (IsFlag 45)
			(gCurRoom newRoom: 991) ; shiversFlashback
		else
			(gCurRoom newRoom: 923) ; endGame
		)
	)

	(method (dispose)
		(proc951_10 25004)
		(gMouseDownHandler delete: gCurRoom)
		(gKeyDownHandler delete: gCurRoom)
		(local0 dispose:)
		(self eraseText:)
		(super dispose: &rest)
	)
)

(instance sFadeOutBecauseGuySaidSo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom eraseText:)
				(= local0
					((Plane new:)
						picture: 51234
						priority: 40
						init: 10 0 320 200
						yourself:
					)
				)
				(gSounds play: 25004 0 82 self)
			)
			(1
				(if (IsFlag 45)
					(gCurRoom newRoom: 991) ; shiversFlashback
				else
					(gCurRoom newRoom: 923) ; endGame
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

