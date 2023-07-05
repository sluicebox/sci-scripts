;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 934)
(include sci.sh)
(use Main)
(use n951)
(use Movie)
(use Str)

(public
	theatreMovie 0
)

(instance theatreMovie of ShiversRoom
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(SetFlag 52)
		(super init: &rest)
		(if (IsFlag 39)
			(if (IsFlag 38)
				(= temp0 54)
				(= temp1 16)
			else
				(= temp0 182)
				(= temp1 102)
			)
			(= temp2 ((VmdMovie new:) open: 16000 client: self yourself:))
			(temp2 caller: self)
			(if (IsFlag 38)
				(temp2 put: temp0 temp1 5)
			else
				(temp2 put: temp0 temp1 4)
			)
			(if
				(and
					(== (temp2 setWaitEvent: 23 10) 1)
					(== (temp2 setWaitEvent: 23 130) 1)
				)
				(= temp3 (Str format: { Mysterious Places}))
				(self drawText: temp3 0 18 32)
				(temp3 data: 0 dispose:)
				(if (== (temp2 setWaitEvent: 23 145) 1)
					(= temp3
						(Str
							format:
								{ Life and Legends of ancient sites around the world}
						)
					)
					(self drawText: temp3 0 18 32)
					(temp3 data: 0 dispose:)
					(if (== (temp2 setWaitEvent: 23 170) 1)
						(= temp3 (Str format: { With your host:}))
						(self drawText: temp3 0 18 32)
						(temp3 data: 0 dispose:)
						(if (== (temp2 setWaitEvent: 23 180) 1)
							(= temp3
								(Str
									format:
										{ With your host: Sir Hubert Windlenot}
								)
							)
							(self drawText: temp3 0 18 32)
							(temp3 data: 0 dispose:)
							(if (== (temp2 setWaitEvent: 23 198) 1)
								(= temp3
									(Str
										format:
											{ With your host: Sir Hubert Windlenot - Professor of Archeology}
									)
								)
								(self drawText: temp3 0 18 32)
								(temp3 data: 0 dispose:)
								(if (== (temp2 setWaitEvent: 23 245) 1)
									(= temp3
										(Str
											format:
												{ Innumerable mysteries are raised as we look at the remains of the past.}
										)
									)
									(self drawText: temp3 0 18 32)
									(temp3 data: 0 dispose:)
									(if (== (temp2 setWaitEvent: 23 280) 1)
										(= temp3
											(Str
												format:
													{ Who are these people who built these structures?}
											)
										)
										(self drawText: temp3 0 18 32)
										(temp3 data: 0 dispose:)
										(if (== (temp2 setWaitEvent: 23 305) 1)
											(= temp3
												(Str
													format:
														{ Who are these people who built these structures?\nWhy did they have so much in common with the ancients in Egypt and Mesopotamia?}
												)
											)
											(self drawText: temp3 0 18 32)
											(temp3 data: 0 dispose:)
											(if
												(==
													(temp2 setWaitEvent: 23 345)
													1
												)
												(= temp3
													(Str
														format:
															{ Who are these people who built these structures?\nWhy did they have so much in common with the ancients in Egypt and Mesopotamia?\nWhat fate caused them to disappear and take their knowledge with them?}
													)
												)
												(self drawText: temp3 0 18 32)
												(temp3 data: 0 dispose:)
												(if
													(==
														(temp2
															setWaitEvent: 23 385
														)
														1
													)
													(= temp3
														(Str
															format:
																{ Who are these people who built these structures?\nWhy did they have so much in common with the ancients in Egypt and Mesopotamia?\nWhat fate caused them to disappear and take their knowledge with them?\nWhy did they bury their secrets beneath the earth?}
														)
													)
													(self
														drawText: temp3 0 18 32
													)
													(temp3 data: 0 dispose:)
													(if
														(==
															(temp2
																setWaitEvent:
																	23
																	410
															)
															1
														)
														(= temp3
															(Str
																format:
																	{ Archeologists are only now piecing together the clues from\npictographs and carvings left behind.}
															)
														)
														(self
															drawText:
																temp3
																0
																18
																32
														)
														(temp3 data: 0 dispose:)
														(if
															(==
																(temp2
																	setWaitEvent:
																		23
																		465
																)
																1
															)
															(= temp3
																(Str
																	format:
																		{ Archeologists are only now piecing together the clues from\npictographs and carvings left behind.\nEven so we are far from understanding them.}
																)
															)
															(self
																drawText:
																	temp3
																	0
																	18
																	32
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
																			520
																	)
																	1
																)
																(= temp3
																	(Str
																		format:
																			{ There is a legend of an immense tunnel running under the\nAndes mountains in South America connecting the Inca\nCivilization with a subterranean world.}
																	)
																)
																(self
																	drawText:
																		temp3
																		0
																		18
																		29
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
																				675
																		)
																		1
																	)
																	(= temp3
																		(Str
																			format:
																				{ Searching for that passage, I followed this tunnel for almost\na mile when all of a sudden it just stopped. }
																		)
																	)
																	(self
																		drawText:
																			temp3
																			0
																			18
																			29
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
																					760
																			)
																			1
																		)
																		(= temp3
																			(Str
																				format:
																					{ Now I asked myself:\nWhy would the builders of this tunnel go this far\njust to have it suddenly dead-end?}
																			)
																		)
																		(self
																			drawText:
																				temp3
																				0
																				18
																				29
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
																						850
																				)
																				1
																			)
																			(=
																				temp3
																				(Str
																					format:
																						{ Come with me as we explore its secrets.}
																				)
																			)
																			(self
																				drawText:
																					temp3
																					0
																					18
																					29
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
																							900
																					)
																					1
																				)
																				(=
																					temp3
																					(Str
																						format:
																							{ }
																					)
																				)
																				(self
																					drawText:
																						temp3
																						0
																						18
																						29
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
																								925
																						)
																						1
																					)
																					(=
																						temp3
																						(Str
																							format:
																								{ You will see that the tunnel ends here.}
																						)
																					)
																					(self
																						drawText:
																							temp3
																							0
																							18
																							29
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
																									970
																							)
																							1
																						)
																						(=
																							temp3
																							(Str
																								format:
																									{ Now notice the unusual markings on this end wall.}
																							)
																						)
																						(self
																							drawText:
																								temp3
																								0
																								18
																								29
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
																										1030
																								)
																								1
																							)
																							(=
																								temp3
																								(Str
																									format:
																										{ Now this is so clever.}
																								)
																							)
																							(self
																								drawText:
																									temp3
																									0
																									18
																									29
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
																											1050
																									)
																									1
																								)
																								(=
																									temp3
																									(Str
																										format:
																											{ Now this is so clever.\nWatch as I touch these images.}
																									)
																								)
																								(self
																									drawText:
																										temp3
																										0
																										18
																										29
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
																												1180
																										)
																										1
																									)
																									(=
																										temp3
																										(Str
																											format:
																												{ Now pay close attention. This seems to be the key.}
																										)
																									)
																									(self
																										drawText:
																											temp3
																											0
																											18
																											29
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
																													1314
																											)
																											1
																										)
																										(=
																											temp3
																											(Str
																												format:
																													{ Isn't this ingenious?}
																											)
																										)
																										(self
																											drawText:
																												temp3
																												0
																												18
																												29
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
																														1340
																												)
																												1
																											)
																											(=
																												temp3
																												(Str
																													format:
																														{ Isn't this ingenious?\nThis is one of the ways the ancients guarded their most secret treasures.}
																												)
																											)
																											(self
																												drawText:
																													temp3
																													0
																													18
																													29
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
																															1400
																													)
																													1
																												)
																												(=
																													temp3
																													(Str
																														format:
																															{ Unfortunately this particular tunnel is not the famed Andean\ntunnel system, but a decoy, for we found nothing but a maze\nleading to an empty room.}
																													)
																												)
																												(self
																													drawText:
																														temp3
																														0
																														18
																														29
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
																																1530
																														)
																														1
																													)
																													(=
																														temp3
																														(Str
																															format:
																																{ Unfortunately this particular tunnel is not the famed Andean\ntunnel system, but a decoy, for we found nothing but a maze\nleading to an empty room.\nOr is it that we have not yet discovered the rest of its secrets?}
																														)
																													)
																													(self
																														drawText:
																															temp3
																															0
																															18
																															29
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
																																	1580
																															)
																															1
																														)
																														(=
																															temp3
																															(Str
																																format:
																																	{ This is Sir Hubert Windlenot, Professor of Archeology}
																															)
																														)
																														(self
																															drawText:
																																temp3
																																0
																																18
																																29
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
																																		1620
																																)
																																1
																															)
																															(=
																																temp3
																																(Str
																																	format:
																																		{ This is Sir Hubert Windlenot, Professor of Archeology - Signing Off.}
																																)
																															)
																															(self
																																drawText:
																																	temp3
																																	0
																																	18
																																	29
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
																																			2000
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
			(temp2 close:)
		else
			(self playVMD: 16000 self)
		)
		(if (IsFlag 45)
			(gCurRoom newRoom: 991) ; shiversFlashback
		else
			(gCurRoom newRoom: 17190) ; rm17v190
		)
	)

	(method (dispose)
		(self eraseText:)
		(super dispose: &rest)
	)
)

