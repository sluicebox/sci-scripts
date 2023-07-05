;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 930)
(include sci.sh)
(use Main)
(use n951)
(use Movie)
(use Str)

(public
	introMovie 0
)

(local
	local0
)

(instance introMovie of ShiversRoom
	(properties)

	(method (init &tmp temp0 temp1 temp2)
		(super init: &rest)
		(if (IsFlag 39)
			(if (IsFlag 38)
				(= temp0 54)
				(= temp1 16)
			else
				(= temp0 182)
				(= temp1 102)
			)
			(= local0 ((VmdMovie new:) open: 1002 client: self yourself:))
			(local0 caller: self)
			(if (IsFlag 38)
				(local0 put: temp0 temp1 5)
			else
				(local0 put: temp0 temp1 4)
			)
			(if
				(and
					(== (local0 setWaitEvent: 23 10) 1)
					(== (local0 setWaitEvent: 23 142) 1)
				)
				(= temp2
					(Str
						format:
							{ This dare was kind of your idea you know, but I'm glad I'm me out here and not you in there.}
					)
				)
				(self drawText: temp2 0 18)
				(temp2 data: 0 dispose:)
				(if (== (local0 setWaitEvent: 23 200) 1)
					(= temp2
						(Str
							format:
								{ I think I heard those same loving words before. Like the time you guys dared me to spend the night in that cemetary.}
						)
					)
					(self drawText: temp2 0 18)
					(temp2 data: 0 dispose:)
					(if (== (local0 setWaitEvent: 23 270) 1)
						(= temp2
							(Str
								format:
									{ You know, if you die in the museum tonight I'll make sure she gives the eulogy at your funeral.}
							)
						)
						(self drawText: temp2 0 18)
						(temp2 data: 0 dispose:)
						(if (== (local0 setWaitEvent: 23 320) 1)
							(= temp2
								(Str
									format:
										{ We would have never made you spend the night here if you'd hadn't of talked about this place so much.}
								)
							)
							(self drawText: temp2 0 18)
							(temp2 data: 0 dispose:)
							(if (== (local0 setWaitEvent: 23 360) 1)
								(= temp2
									(Str
										format:
											{ Yeah, we think you've been kinda...well, obsessed thinking you were hearing voices and stuff coming from the museum and all...too weird for me!}
									)
								)
								(self drawText: temp2 0 18)
								(temp2 data: 0 dispose:)
								(if (== (local0 setWaitEvent: 23 445) 1)
									(= temp2
										(Str
											format:
												{ Hey you know, maybe they're the voices of those kids who disappeared 15 years ago.}
										)
									)
									(self drawText: temp2 0 18)
									(temp2 data: 0 dispose:)
									(if (== (local0 setWaitEvent: 23 495) 1)
										(= temp2
											(Str
												format:
													{ Right, the police never found the bodies...or the killer.}
											)
										)
										(self drawText: temp2 0 18)
										(temp2 data: 0 dispose:)
										(if (== (local0 setWaitEvent: 23 530) 1)
											(= temp2
												(Str
													format:
														{ Yeah, and my sister - you know, Julie, the one in college - says Professor Windlenut went insane. He viciously murdered them and then buried their bodies in the basement of the museum. What if he's hiding in that creepy museum right now, just waiting for another victim?}
												)
											)
											(self drawText: temp2 0 18)
											(temp2 data: 0 dispose:)
											(if
												(==
													(local0
														setWaitEvent: 23 675
													)
													1
												)
												(= temp2
													(Str
														format:
															{ Yeah and the ghost of his victims are calling out to you...warning you.\n\nRing ring, hello...I think it's for you.\n\n(Kids laugh)}
													)
												)
												(self drawText: temp2 0 18)
												(temp2 data: 0 dispose:)
												(if
													(==
														(local0
															setWaitEvent: 23 750
														)
														1
													)
													(= temp2
														(Str
															format:
																{ (Whispering)\nGet out, get out...they are evil...no noooooo! \n\n(Wolf howling)}
														)
													)
													(self drawText: temp2 0 18)
													(temp2 data: 0 dispose:)
													(if
														(==
															(local0
																setWaitEvent:
																	23
																	850
															)
															1
														)
														(= temp2
															(Str
																format:
																	{ That was just a dog howling.\n\nThere was something more than that.}
															)
														)
														(self
															drawText: temp2 0 18
														)
														(temp2 data: 0 dispose:)
														(if
															(==
																(local0
																	setWaitEvent:
																		23
																		890
																)
																1
															)
															(= temp2
																(Str
																	format:
																		{ Well I didn't hear anything. I think this place is just getting us all spooked.}
																)
															)
															(self
																drawText:
																	temp2
																	0
																	18
															)
															(temp2
																data: 0
																dispose:
															)
															(if
																(==
																	(local0
																		setWaitEvent:
																			23
																			950
																	)
																	1
																)
																(= temp2
																	(Str
																		format:
																			{ Are you sure you want to go through with this? You can back out at any time.}
																	)
																)
																(self
																	drawText:
																		temp2
																		0
																		18
																)
																(temp2
																	data: 0
																	dispose:
																)
																(if
																	(==
																		(local0
																			setWaitEvent:
																				23
																				990
																		)
																		1
																	)
																	(= temp2
																		(Str
																			format:
																				{ But of course if you did, you'd probably never live down the chicken jokes.\n\nThat's true.}
																		)
																	)
																	(self
																		drawText:
																			temp2
																			0
																			18
																	)
																	(temp2
																		data: 0
																		dispose:
																	)
																	(if
																		(==
																			(local0
																				setWaitEvent:
																					23
																					1030
																			)
																			1
																		)
																		(= temp2
																			(Str
																				format:
																					{ You'll be all right. Come on, I don't want to be late for the movie. We'll be back at dawn to let you out.\n\nBye bye!\nSee ya!}
																			)
																		)
																		(self
																			drawText:
																				temp2
																				0
																				18
																		)
																		(temp2
																			data:
																				0
																			dispose:
																		)
																		(if
																			(==
																				(local0
																					setWaitEvent:
																						23
																						1100
																				)
																				1
																			)
																			(self
																				eraseText:
																			)
																			(==
																				(local0
																					setWaitEvent:
																						23
																						1252
																				)
																				1
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
			(local0 close:)
		else
			(self playVMD: 1002 self)
		)
		(cond
			((IsFlag 45)
				(gCurRoom newRoom: 991) ; shiversFlashback
			)
			((== global186 1)
				(gCurRoom newRoom: 6220) ; rm6v220
			)
			(else
				(gCurRoom newRoom: 1012) ; rm1v12
			)
		)
	)

	(method (dispose)
		(self eraseText:)
		(super dispose: &rest)
	)
)

