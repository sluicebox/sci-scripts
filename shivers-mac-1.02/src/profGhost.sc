;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 931)
(include sci.sh)
(use Main)
(use n951)
(use Movie)
(use Str)

(public
	profGhost 0
)

(instance profGhost of ShiversRoom
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
			(= temp2 ((VmdMovie new:) open: 3361 client: self yourself:))
			(temp2 caller: self)
			(if (IsFlag 38)
				(temp2 put: temp0 temp1 5)
			else
				(temp2 put: temp0 temp1 4)
			)
			(if
				(and
					(== (temp2 setWaitEvent: 23 10) 1)
					(== (temp2 setWaitEvent: 23 25) 1)
				)
				(= temp3
					(Str
						format: { Ahhhh! Fifteen long years in this ... prison.}
					)
				)
				(self drawText: temp3 0 18)
				(temp3 data: 0 dispose:)
				(if (== (temp2 setWaitEvent: 23 100) 1)
					(= temp3
						(Str
							format:
								{ You get out. Do not meddle in things beyond your understanding. You will pay for your curiosity. You are in grave danger. They are so evil.}
						)
					)
					(self drawText: temp3 0 18)
					(temp3 data: 0 dispose:)
					(if (== (temp2 setWaitEvent: 23 225) 1)
						(= temp3
							(Str
								format:
									{ Already some of your life essence has been stolen.}
							)
						)
						(self drawText: temp3 0 18)
						(temp3 data: 0 dispose:)
						(if (== (temp2 setWaitEvent: 23 260) 1)
							(= temp3
								(Str
									format:
										{ I was too old. Not fast enough. The Ixupi are so evil.}
								)
							)
							(self drawText: temp3 0 18)
							(temp3 data: 0 dispose:)
							(if (== (temp2 setWaitEvent: 23 325) 1)
								(= temp3
									(Str
										format:
											{ It is imperative to find all the vessels because it seems only when they are united with their talismans do they have any power.}
									)
								)
								(self drawText: temp3 0 18)
								(temp3 data: 0 dispose:)
								(if (== (temp2 setWaitEvent: 23 400) 1)
									(= temp3
										(Str
											format:
												{ My plan was to use them on the Ixupi before any more of them escaped into the world.}
										)
									)
									(self drawText: temp3 0 18)
									(temp3 data: 0 dispose:)
									(if (== (temp2 setWaitEvent: 23 465) 1)
										(= temp3
											(Str
												format:
													{ I believe they cannot resist the vessels as long as they're with the talismans and you approach directly.}
											)
										)
										(self drawText: temp3 0 18)
										(temp3 data: 0 dispose:)
										(if (== (temp2 setWaitEvent: 23 520) 1)
											(= temp3
												(Str
													format:
														{ This vessel here is of no use to you. Its Ixupi is the one who robbed me of my essence. It has escaped into the world...and they have ruined my museum...}
												)
											)
											(self drawText: temp3 0 18)
											(temp3 data: 0 dispose:)
											(if
												(==
													(temp2 setWaitEvent: 23 702)
													1
												)
												(self eraseText:)
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
			(self playVMD: 3361 self)
		)
		(if (IsFlag 45)
			(gCurRoom newRoom: 991) ; shiversFlashback
		else
			(gCurRoom newRoom: 3360) ; rm3v360
		)
	)

	(method (dispose)
		(self eraseText:)
		(super dispose: &rest)
	)
)

