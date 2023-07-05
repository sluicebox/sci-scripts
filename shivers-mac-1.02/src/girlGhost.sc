;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 932)
(include sci.sh)
(use Main)
(use n951)
(use Movie)
(use Str)

(public
	girlGhost 0
)

(instance girlGhost of ShiversRoom
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(super init: &rest)
		(if (IsFlag 39)
			(if (IsFlag 38)
				(= temp0 54)
				(= temp1 16)
			else
				(= temp0 182)
				(= temp1 102)
			)
			(= temp2 ((VmdMovie new:) open: 35180 client: self yourself:))
			(temp2 caller: self)
			(if (IsFlag 38)
				(temp2 put: temp0 temp1 5)
			else
				(temp2 put: temp0 temp1 4)
			)
			(if
				(and
					(== (temp2 setWaitEvent: 23 10) 1)
					(== (temp2 setWaitEvent: 23 60) 1)
				)
				(= temp3 (Str format: { Who are you?}))
				(self drawText: temp3 0 18 233)
				(temp3 data: 0 dispose:)
				(if (== (temp2 setWaitEvent: 23 95) 1)
					(= temp3 (Str format: { I feel so weird!\n}))
					(self drawText: temp3 0 18 233)
					(temp3 data: 0 dispose:)
					(if (== (temp2 setWaitEvent: 23 135) 1)
						(= temp3 (Str format: { I feel so weird!\nAm I dead?}))
						(self drawText: temp3 0 18 233)
						(temp3 data: 0 dispose:)
						(if (== (temp2 setWaitEvent: 23 155) 1)
							(= temp3
								(Str
									format:
										{ I feel so weird!\nAm I dead?\nI'm a ghost!}
								)
							)
							(self drawText: temp3 0 18 233)
							(temp3 data: 0 dispose:)
							(if (== (temp2 setWaitEvent: 23 195) 1)
								(= temp3
									(Str
										format:
											{ They're still here aren't they?!}
									)
								)
								(self drawText: temp3 0 18 233)
								(temp3 data: 0 dispose:)
								(if (== (temp2 setWaitEvent: 23 227) 1)
									(= temp3
										(Str
											format:
												{ I almost solved the final riddle.}
										)
									)
									(self drawText: temp3 0 18 233)
									(temp3 data: 0 dispose:)
									(if (== (temp2 setWaitEvent: 23 300) 1)
										(= temp3
											(Str
												format:
													{ That professor is so crazy.}
											)
										)
										(self drawText: temp3 0 18 233)
										(temp3 data: 0 dispose:)
										(if (== (temp2 setWaitEvent: 23 327) 1)
											(= temp3
												(Str
													format:
														{ That professor is so crazy.\nShould never have brought the pots here.}
												)
											)
											(self drawText: temp3 0 18 233)
											(temp3 data: 0 dispose:)
											(if
												(==
													(temp2 setWaitEvent: 23 350)
													1
												)
												(= temp3
													(Str
														format:
															{ That professor is so crazy.\nShould never have brought the pots here.\nNever!}
													)
												)
												(self drawText: temp3 0 18 233)
												(temp3 data: 0 dispose:)
												(if
													(==
														(temp2
															setWaitEvent: 23 375
														)
														1
													)
													(= temp3
														(Str
															format: { Merrick!}
														)
													)
													(self
														drawText: temp3 0 18 233
													)
													(temp3 data: 0 dispose:)
													(if
														(==
															(temp2
																setWaitEvent:
																	23
																	390
															)
															1
														)
														(= temp3
															(Str
																format:
																	{ Merrick!\nWhat happened to Merrick?}
															)
														)
														(self
															drawText:
																temp3
																0
																18
																233
														)
														(temp3 data: 0 dispose:)
														(if
															(==
																(temp2
																	setWaitEvent:
																		23
																		417
																)
																1
															)
															(= temp3
																(Str
																	format:
																		{ Oh..}
																)
															)
															(self
																drawText:
																	temp3
																	0
																	18
																	233
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
																			452
																	)
																	1
																)
																(= temp3
																	(Str
																		format:
																			{ Markings}
																	)
																)
																(self
																	drawText:
																		temp3
																		0
																		18
																		233
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
																				460
																		)
																		1
																	)
																	(= temp3
																		(Str
																			format:
																				{ Markings on the pots.}
																		)
																	)
																	(self
																		drawText:
																			temp3
																			0
																			18
																			233
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
																					482
																			)
																			1
																		)
																		(= temp3
																			(Str
																				format:
																					{ Markings on the pots.\nThey're important!}
																			)
																		)
																		(self
																			drawText:
																				temp3
																				0
																				18
																				233
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
																						510
																				)
																				1
																			)
																			(=
																				temp3
																				(Str
																					format:
																						{ I can't hold on...}
																				)
																			)
																			(self
																				drawText:
																					temp3
																					0
																					18
																					233
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
																							570
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
			(temp2 close:)
		else
			(self playVMD: 35180 self)
		)
		(if (IsFlag 45)
			(gCurRoom newRoom: 991) ; shiversFlashback
		else
			(gCurRoom newRoom: 35180) ; rm35v180
		)
	)

	(method (dispose)
		(self eraseText:)
		(super dispose: &rest)
	)
)

