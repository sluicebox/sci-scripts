;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 933)
(include sci.sh)
(use Main)
(use n951)
(use Movie)
(use Str)

(public
	boyGhost 0
)

(instance boyGhost of ShiversRoom
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(SetFlag 27)
		(super init: &rest)
		(if (IsFlag 39)
			(if (IsFlag 38)
				(= temp0 54)
				(= temp1 16)
			else
				(= temp0 182)
				(= temp1 102)
			)
			(= temp2 ((VmdMovie new:) open: 28040 client: self yourself:))
			(temp2 caller: self)
			(if (IsFlag 38)
				(temp2 put: temp0 temp1 5)
			else
				(temp2 put: temp0 temp1 4)
			)
			(if
				(and
					(== (temp2 setWaitEvent: 23 10) 1)
					(== (temp2 setWaitEvent: 23 35) 1)
				)
				(= temp3 (Str format: { Where am I?}))
				(self drawText: temp3 0 18 233)
				(temp3 data: 0 dispose:)
				(if (== (temp2 setWaitEvent: 23 57) 1)
					(= temp3
						(Str
							format:
								{ Where am I?\nHow long have I been in that pot?}
						)
					)
					(self drawText: temp3 0 18 233)
					(temp3 data: 0 dispose:)
					(if (== (temp2 setWaitEvent: 23 90) 1)
						(= temp3
							(Str
								format:
									{ Where am I?\nHow long have I been in that pot?\nIt's so dark and cold in there.}
							)
						)
						(self drawText: temp3 0 18 233)
						(temp3 data: 0 dispose:)
						(if (== (temp2 setWaitEvent: 23 125) 1)
							(= temp3
								(Str format: { I'm one of them now, aren't I?!})
							)
							(self drawText: temp3 0 18 233)
							(temp3 data: 0 dispose:)
							(if (== (temp2 setWaitEvent: 23 172) 1)
								(= temp3 (Str format: { Where is she?}))
								(self drawText: temp3 0 18 233)
								(temp3 data: 0 dispose:)
								(if (== (temp2 setWaitEvent: 23 190) 1)
									(= temp3
										(Str
											format:
												{ Where is she?\nIs she still alive?}
										)
									)
									(self drawText: temp3 0 18 233)
									(temp3 data: 0 dispose:)
									(if (== (temp2 setWaitEvent: 23 210) 1)
										(= temp3
											(Str
												format:
													{ Where is she?\nIs she still alive?\nBeth!}
											)
										)
										(self drawText: temp3 0 18 233)
										(temp3 data: 0 dispose:)
										(if (== (temp2 setWaitEvent: 23 236) 1)
											(= temp3
												(Str
													format:
														{ They'll be after you too!}
												)
											)
											(self drawText: temp3 0 18 233)
											(temp3 data: 0 dispose:)
											(if
												(==
													(temp2 setWaitEvent: 23 258)
													1
												)
												(= temp3
													(Str
														format:
															{ They'll be after you too!\nThey're everywhere.}
													)
												)
												(self drawText: temp3 0 18 233)
												(temp3 data: 0 dispose:)
												(if
													(==
														(temp2
															setWaitEvent: 23 263
														)
														1
													)
													(= temp3
														(Str
															format:
																{ They'll be after you too!\nThey're everywhere.\nThere's nowhere to hide!}
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
																	285
															)
															1
														)
														(= temp3
															(Str
																format:
																	{ Find the Black Book!}
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
																		305
																)
																1
															)
															(= temp3
																(Str
																	format:
																		{ Find the Black Book.\nThe Black Book!}
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
																			325
																	)
																	1
																)
																(= temp3
																	(Str
																		format:
																			{ Beth!!!....}
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
																				370
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
			(temp2 close:)
		else
			(self playVMD: 28040 self)
		)
		(if (IsFlag 45)
			(gCurRoom newRoom: 991) ; shiversFlashback
		else
			(gCurRoom newRoom: 28040) ; rm28v040
		)
	)

	(method (dispose)
		(self eraseText:)
		(super dispose: &rest)
	)
)

