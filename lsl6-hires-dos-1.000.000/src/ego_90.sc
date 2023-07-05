;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 90)
(include sci.sh)
(use Main)
(use fileScr)
(use Print)
(use StopWalk)
(use Timer)
(use Grooper)
(use Ego_64988)
(use Sound)
(use System)

(public
	ego 0
)

(class ego of Ego
	(properties
		noun 2
		view 900
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager
					say:
						noun
						4
						0
						(if (< global168 5) (++ global168) else global168)
						0
						0
				)
			)
			(59 ; handcreme
				(if (IsFlag 254)
					(gMessager say: 2 59 1 1 0 0) ; "You rub the Al Lowe Vera lotion into a few of the many wounds Thunderbird inflicted upon you."
					(return 1)
				else
					(gMessager say: 2 59 0 1 0 0) ; "You rub the Al Lowe Vera lotion into a few of those dry places on your knuckles."
					(return 1)
				)
			)
			(9 ; beer
				(gEgo put: 3) ; beer
				(gGame changeScore: -5 159)
				(if (not (self script:))
					(self setScript: beerScript)
				)
				(gMessager say: 2 9 0 1 0 0) ; "(SOUNDFX) Glug, glug, glug, glug, glug, glug, glug."
				(return 1)
			)
			(2 ; Talk
				(gMessager say: noun theVerb 0 (Random 1 4) 0 0)
				(return 1)
			)
			(49 ; beaver [ inflated ]
				(if (== gCurRoomNum 240)
					(gMessager say: 2 49 22 0 0 0) ; "You're already on your beaver!"
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(63 ; bastardfile
				(cond
					(
						(and
							(not (OneOf gCurRoomNum 350 280))
							(not (proc79_14))
						)
						(self setScript: (ScriptID 79 13)) ; fileScr
					)
					((Message msgGET 0 noun theVerb 0 1)
						(gMessager say: noun theVerb 0 0 0 0) ; "You carefully buff that persistent hangnail completely off your finger!"
					)
					(else
						(gMessager say: noun 0 0 0 0 0) ; "Hey! Why'd you do that to me?"
					)
				)
			)
			(6 ; Zipper
				(if (and (not (proc79_14)) (not (OneOf gCurRoomNum 350 280)))
					(= global178 0)
					(gGame handsOff:)
					(self setScript: (ScriptID 97 0) 0 1) ; scratchScript
				else
					(gMessager say: 2 6 0 0 0 0) ; "You carefully adjust your clothing."
				)
			)
			(else
				(if (Message msgGET 0 noun theVerb 0 1)
					(gMessager say: noun theVerb 0 0 0 0)
				else
					(gMessager say: noun 0 0 0 0 0) ; "Hey! Why'd you do that to me?"
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (>= y 138)
			(= edgeHit 3)
		)
		(if (<= global178 0)
			(= global178 (Random 30 120))
			(scratchTimer setTicks: 60 scratchTimer)
		)
		(if (and (== global178 1) (not (OneOf gCurRoomNum 350 280)))
			(= global178 0)
			(if (not (proc79_14))
				(gGame handsOff:)
				(self setScript: (ScriptID 97 0) 0 0) ; scratchScript
			)
		)
	)

	(method (dispose)
		(scratchTimer dispose: delete:)
		(super dispose:)
	)

	(method (normalize param1 param2 param3)
		(if (> argc 1)
			(gEgo loop: param2)
		)
		(if (not (and (> argc 2) param3))
			(gEgo scaleX: 128 scaleY: 128 setScale: 0 setScaler: 0)
		)
		(if (and global100 (== param1 0))
			(Prints {Ego's view is 0, you FOK!})
		)
		(gEgo
			view:
				(if argc
					param1
				else
					(self view:)
				)
			signal: 4129
			z: 0
			setLooper: egoGrooper
			setLoop: -1
			setPri: -1
			setMotion: 0
			illegalBits: 0
			setStep: 3 2
			ignoreActors:
				(not
					(OneOf
						gCurRoomNum
						680
						640
						305
						300
						200
						500
						505
						660
						690
						820
					)
				)
			setCycle: StopWalk -1
			setSpeed: global167
			state: (|= state $0002)
		)
	)

	(method (put param1 param2 &tmp temp0 temp1)
		(if (self has: param1)
			((= temp0 (gInventory at: param1))
				moveTo: (if (== argc 1) -1 else param2)
			)
			(DeleteScreenItem (= temp1 (gInventory at: param1)))
			(temp1 signal: (| (temp1 signal:) $0004))
			(if (and (== (gTheIconBar curIcon:) temp0) (not (gGame isHandsOff:)))
				(gTheIconBar curIcon: (ScriptID 0 3)) ; icon0
				(if
					(or
						(not (gTheIconBar contains: (ScriptID 0 3))) ; icon0
						(& ((ScriptID 0 3) state:) $0004) ; icon0
					)
					(gTheIconBar advanceCurIcon:)
				else
					(gGame setCursor: ((ScriptID 0 3) getCursor:)) ; icon0
				)
			)
			(if (== (gInventory curIcon:) temp0)
				(gInventory curIcon: 0)
			)
		)
		(if (& (gInventory state:) $0020)
			(gInventory show:)
		)
	)

	(method (get param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			((gInventory at: [param1 temp0]) moveTo: -2)
		)
		(if (& (gInventory state:) $0020)
			(gInventory setCurIndexToItem: (gInventory at: param1))
		)
	)

	(method (has param1 &tmp temp0)
		(if (= temp0 (gInventory at: param1))
			(temp0 ownedBy: -2)
		)
	)
)

(instance egoGrooper of Grooper
	(properties)

	(method (doit param1 param2 param3 param4)
		(if (OneOf (gEgo view:) 900 800)
			(super
				doit:
					param1
					param2
					(if (> argc 2) param3 else 0)
					(if (> argc 3) param4 else 0)
					&rest
			)
		else
			(super doit: param1 param2 (if (> argc 2) param3 else 0) 1)
		)
	)
)

(instance scratchTimer of Timer
	(properties)

	(method (cue)
		(-- global178)
		(scratchTimer setTicks: 60 self)
	)
)

(instance beerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sFx number: 517 loop: 1 play:)
				(= ticks 90)
			)
			(1
				(sFx stop:)
				(self dispose:)
			)
		)
	)
)

(instance sFx of Sound
	(properties)
)

