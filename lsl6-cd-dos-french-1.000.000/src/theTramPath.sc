;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 825)
(include sci.sh)
(use Main)
(use n079)
(use RegionPath)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	theTramPath 0
	tram 1
	tramSoundFx 2
	tramBase 3
)

(local
	[local0 61] = [32767 680 90 128 335 128 32767 640 -25 128 335 128 32767 305 -25 128 335 128 32767 300 -25 128 335 128 32767 200 -25 128 335 128 32767 500 -25 128 335 128 32767 505 -25 128 335 128 32767 660 -25 128 330 128 32767 690 -25 128 335 128 32767 820 -25 85 75 85 -32768]
)

(instance theTramPath of RegionPath
	(properties
		endType -1
	)

	(method (init)
		(if (IsFlag 36)
			(self endType: 0)
		)
		(cond
			((and (== gCurRoomNum 680) (IsFlag 36) (== (tram heading:) 90))
				(= completed 1)
			)
			(
				(and
					(== gCurRoomNum 820)
					(not (IsFlag 36))
					(== (tram heading:) 345)
				)
				(= completed 1)
			)
		)
		(self theRegion: gGame)
		(super init: &rest)
	)

	(method (curRoomCheck &tmp temp0)
		(= temp0 (client z:))
		(if (== currentRoom gCurRoomNum)
			(cond
				((and (== gCurRoomNum 680) (not (IsFlag 36)))
					((ScriptID 825 1) setScript: (ScriptID 826 2)) ; tram, turnTramLeft
				)
				((and (not (IsFlag 70)) (== gCurRoomNum 820) (IsFlag 36))
					(SetFlag 70)
					((ScriptID 825 1) setScript: (ScriptID 826 3)) ; tram, turnTramRight
				)
			)
			(client
				view: 82
				z:
					(if (>= temp0 1000)
						(- temp0 1000)
					else
						temp0
					)
				illegalBits: theOldBits
				setCycle: Walk
				signal: theOldSignal
			)
			(tramSoundFx number: 39 play: setLoop: -1)
			(if
				(gEgo
					inRect:
						(- ((ScriptID 825 1) brLeft:) 46) ; tram
						(- ((ScriptID 825 1) brTop:) 3) ; tram
						(+ ((ScriptID 825 1) brRight:) 46) ; tram
						(+ ((ScriptID 825 1) brBottom:) 10) ; tram
				)
				(gEgo posn: (gEgo x:) (- ((ScriptID 825 1) brTop:) 3)) ; tram
			)
		else
			(ClearFlag 70)
			(client
				view: 98
				z:
					(if (< temp0 1000)
						(+ temp0 1000)
					else
						temp0
					)
				illegalBits: 0
				setCycle: 0
				ignoreActors: 1
			)
			(tramSoundFx number: 0 stop:)
		)
	)

	(method (nextRoom)
		(super nextRoom:)
	)

	(method (at param1)
		(return [local0 param1])
	)
)

(instance tram of Actor
	(properties
		x 68
		y 132
		noun 1
		modNum 825
		view 82
		cycleSpeed 8
		moveSpeed 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 4 2) ; Do, Talk
				(cond
					(
						(and
							script
							(script script:)
							(OneOf
								(script script:)
								(ScriptID 826 2) ; turnTramLeft
								(ScriptID 826 3) ; turnTramRight
							)
						)
						(gMessager say: 1 4 4 0 0 825) ; "Sorry, this is the end of the line for me. But, if you'd like to go to the other end of the hotel, wait for me to turn this baby around."
					)
					((IsFlag 35)
						(gCurRoom setScript: (ScriptID 826 1)) ; getOffTram
					)
					(
						(or
							(and (== gCurRoomNum 820) (IsFlag 36))
							(and (== gCurRoomNum 680) (not (IsFlag 36)))
						)
						(gMessager say: 1 4 4 0 0 825) ; "Sorry, this is the end of the line for me. But, if you'd like to go to the other end of the hotel, wait for me to turn this baby around."
					)
					(else
						(gCurRoom setScript: (ScriptID 826 0) 0 theVerb) ; callTram
					)
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tramBase of Code
	(properties)

	(method (doit)
		(tram
			brBottom: (+ (tram nsBottom:) 1)
			brLeft: (- (tram nsLeft:) 5)
			brRight: (+ (tram nsRight:) 5)
			brTop: (- (tram nsBottom:) 10)
		)
	)
)

(instance tramSoundFx of Sound
	(properties
		flags 1
		number 39
	)
)

