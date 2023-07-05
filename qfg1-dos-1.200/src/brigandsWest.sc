;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 156)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	brigandsWest 0
	chandFall 1
)

(instance brigandsWest of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 156)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				((ScriptID 95 2) setCel: 1) ; lDoor
				((ScriptID 95 15) ; moe
					setPri: 3
					posn: 31 90
					ignoreActors: 1
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 211 90
				)
				(= cycles 4)
			)
			(2
				((ScriptID 95 17) ; curly
					setPri: 3
					ignoreActors:
					illegalBits: 0
					posn: 31 90
					setCycle: Walk
					setMotion: MoveTo 175 90
				)
				((ScriptID 95 18) ignoreActors: 1 setLoop: 6) ; curlyHead
				(= cycles 3)
			)
			(3
				((ScriptID 95 19) ; larry
					setPri: 3
					ignoreActors:
					illegalBits: 0
					posn: 31 90
					setCycle: Walk
					setMotion: MoveTo 160 90
				)
				((ScriptID 95 20) ignoreActors: 1 setLoop: 5) ; larryHead
				(= cycles 5)
			)
			(4
				((ScriptID 95 2) setCel: 0) ; lDoor
				(= cycles 45)
			)
			(5
				(if ((ScriptID 95 0) notify: 1) ; rm95
					(client setScript: (ScriptID 95 23)) ; sBrigBlocked
				else
					(EgoDead 156 0 82 516 0 9 80 {Those guys look familiar.}) ; "You're hopelessly surrounded. You should have stopped those brigands somehow. Maybe you'll see the light."
				)
			)
		)
	)
)

(instance chandFall of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 156)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(= cycles 18)
			)
			(1
				((ScriptID 95 8) dispose:) ; flames
				((ScriptID 95 6) show: posn: 154 32) ; rope
				((ScriptID 95 4) ; chandelier
					view: 295
					setLoop: 3
					setCel: 0
					setPri: 7
					posn: 153 62
				)
				(= cycles 1)
			)
			(2
				((ScriptID 95 6) posn: 152 47) ; rope
				((ScriptID 95 4) setCel: 1 posn: 151 77) ; chandelier
				(= cycles 1)
			)
			(3
				((ScriptID 95 6) posn: 150 62) ; rope
				((ScriptID 95 4) setCel: 2 posn: 149 92) ; chandelier
				(= cycles 1)
			)
			(4
				((ScriptID 95 4) dispose:) ; chandelier
				((ScriptID 95 6) dispose:) ; rope
				((ScriptID 95 19) ignoreActors: 0 setCel: 1) ; larry
				((ScriptID 95 22) ; stars
					init:
					setPri: 10
					ignoreActors: 1
					posn: 147 100
					setCycle: Fwd
				)
				((ScriptID 95 9) setScript: (ScriptID 95 21)) ; brig1, finalEntry
				(self dispose:)
			)
		)
	)
)

