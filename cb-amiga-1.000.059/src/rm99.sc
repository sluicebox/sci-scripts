;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 99)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)

(public
	rm99 0
)

(local
	local0
)

(instance Speedy of Act
	(properties)
)

(instance rm99 of Rm
	(properties
		picture 992
		style 6
	)

	(method (init)
		(HandsOff)
		(super init:)
		(= gDetailLevel -1)
		(if (!= gPossibleScore 1)
			(Load rsVIEW 899)
			(LoadMany rsMESSAGE 409)
		)
		(Speedy
			view: 991
			posn: 20 99
			setStep: 1 1
			setMotion: MoveTo 300 100
			setCycle: Fwd
			init:
		)
		(gGame setSpeed: 0)
	)

	(method (doit)
		(super doit:)
		(if (== gDetailLevel -1)
			(if (== (++ global222) 1)
				(= local0 (+ 60 (GetTime)))
			)
			(if (< local0 (GetTime))
				(cond
					((<= global222 40)
						(= gDetailLevel 0)
					)
					((<= global222 70)
						(= gDetailLevel 1)
					)
					(else
						(= gDetailLevel 2)
					)
				)
				(gGame setSpeed: 6)
				(HandsOn)
				(if (and (not gPossibleScore) (not (StrCmp {zz} (+ gVersion 7))))
					(self setScript: (ScriptID 409 0)) ; FirstTimeCk
				else
					(gCurRoom
						newRoom:
							(switch gPossibleScore
								(1 44)
								(else 414)
							)
					)
				)
			)
		)
	)
)

