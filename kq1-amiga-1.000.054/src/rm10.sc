;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use Interface)
(use mwAvoider)
(use TurnLooper)
(use NewFeature)
(use Blk)
(use LoadMany)
(use Wander)
(use Follow)
(use Avoid)
(use Motion)
(use Game)
(use System)

(public
	rm10 0
)

(local
	local0
)

(instance rm10 of Rm
	(properties
		picture 10
		horizon 57
		north 23
		east 11
		south 7
		west 9
	)

	(method (init)
		(self
			style:
				(switch gPrevRoomNum
					(north 5)
					(west 3)
					(east 40)
					(south 4)
				)
		)
		(super init:)
		(LoadMany rsSCRIPT 985 982 970 971)
		(switch gPrevRoomNum
			(north
				(gEgo
					posn:
						(proc0_17 319 (proc0_18 255 (gEgo x:) 236) 171)
						(+ 2 horizon)
				)
			)
			(south
				(gEgo posn: (proc0_17 319 (gEgo x:) 90) 188)
			)
			(west
				(gEgo posn: 3 (proc0_17 183 (gEgo y:) 113))
			)
			(else
				(gEgo posn: 317 (proc0_17 189 (gEgo y:) (+ horizon 2)))
			)
		)
		(gEgo init:)
		(proc0_1)
		(trough init:)
		(tree7 init:)
		(tree5 init:)
		(tree8 init:)
		(tree6 init:)
		(tree3 init:)
		(tree4 init:)
		(tree2 init:)
		(tree init:)
		(tree1 init:)
		(bush1 init:)
		(bush init:)
		(cond
			((not (IsFlag 2))
				(if (and (not global119) (not (IsFlag 80)))
					(LoadMany rsVIEW 21 167)
					(goatLpr viewChange: 167)
					(if (and (== global129 11) (not (IsFlag 36)))
						(gGoat
							view: 165
							posn: 340 (Random 120 140)
							init:
							looper: goatLpr
							setCycle: Walk
							setScript: changeGoatRoom
						)
						(= local0 (Random 100 180))
					else
						(gGoat
							view: 165
							posn: (Random 232 260) (Random 120 140)
							init:
							looper: goatLpr
							setCycle: Walk
							observeBlocks: pen
							setScript: goatWander
						)
						(= local0 (Random (Random 100 140) (Random 160 200)))
					)
				)
			)
			((and (& (gEgo onControl: 1) $3000) (IsFlag 36))
				(ClearFlag 2)
				(Print 10 0) ; "While you were wandering in the pen, the goat has wandered away."
			)
		)
	)

	(method (handleEvent event)
		(cond
			((Said 'rub/ring')
				(cond
					((IsFlag 1)
						(Print 10 1) ; "You are already invisible"
					)
					((not global134)
						(Print 10 2) ; "Nothing happens."
					)
					((IsFlag 17)
						(Print 10 3) ; "As you rub the shimmering ring, you turn invisible!"
						(SetFlag 1)
						(proc0_1)
						(if (and (IsFlag 2) (not (IsFlag 36)))
							(Print 10 4) ; "The goat doesn't see you anymore."
							(ClearFlag 2)
							(ClearFlag 80)
							(goatLpr viewChange: 167)
							(if (== global129 11)
								(gGoat
									posn: 340 (Random 120 140)
									init:
									looper: goatLpr
									setCycle: Walk
									setScript: changeGoatRoom
								)
								(= local0 (Random 100 180))
							else
								(gGoat
									init:
									looper: goatLpr
									setCycle: Walk
									observeBlocks: pen
									setScript: goatWander
								)
								(= local0
									(Random (Random 100 140) (Random 160 200))
								)
							)
						)
					)
					(else
						(Print 10 5) ; "The magic ring is still in your pocket. You can't rub it there."
					)
				)
			)
			((or (Said 'remove/ring') (Said 'get<off/ring'))
				(cond
					((== (gEgo view:) (if (IsFlag 0) 23 else 16))
						(PrintTooBusy)
					)
					((not (IsFlag 17))
						(Print 10 6) ; "You aren't wearing the ring, Sir Graham."
					)
					(else
						(Print 10 7) ; "You remove the shimmering ring from your finger."
						(ClearFlag 17)
						(ClearFlag 1)
						(proc0_1)
					)
				)
			)
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((gCast contains: gGoat)
				(cond
					(global119
						(event claimed: 0)
					)
					((or (Said 'talk,talk,say,call') (Said '/hello'))
						(Print 10 8) ; "Silly! Goats can't talk."
					)
					((Said 'capture,pull,pull,get,get/goat')
						(cond
							((IsFlag 2)
								(Print 10 9) ; "Why? The goat seems to be following you quite nicely."
							)
							((& (gEgo onControl: 1) $3000)
								(Print 10 10) ; "You wouldn't get very far carrying the goat. Perhaps you can get him to follow you if you'd like to take him somewhere."
							)
							(else
								(Print 10 11) ; "You cannot do that from outside the fence."
							)
						)
					)
					((Said 'feed/goat[/!*]')
						(Print 10 12) ; "What do you want to feed the old goat?"
					)
					((Said 'pet,free/goat')
						(Print 10 13) ; "You can try, but be careful."
					)
					((Said 'ride/goat')
						(Print 10 14) ; "Are you kidding? The goat would never let you!"
					)
					((or (Said 'feed/carrot') (Said 'give/carrot'))
						(cond
							((not (gEgo has: 2)) ; Carrot
								(Print 10 15) ; "You do not have a carrot."
							)
							((> (gEgo distanceTo: gGoat) 32)
								(Print 10 16) ; "You are too far away."
							)
							((IsFlag 1)
								(Print 10 17) ; "You and all your belongings are invisible. The goat can't see your carrot."
							)
							(else
								(if (IsFlag 2)
									(Print 10 18) ; "Goats love carrots! The old goat quickly devours yours and stops following you."
								else
									(Print 10 19) ; "Goats love carrots! The old goat quickly devours yours."
								)
								(proc0_8 2 15)
								(ClearFlag 2)
								(if
									(and
										(not (IsFlag 23))
										(& (gGoat onControl: 1) $3000)
									)
									(ClearFlag 80)
									(goatLpr viewChange: 167)
									(gGoat
										view: 165
										looper: goatLpr
										setCycle: Walk
										observeBlocks: pen
										setScript: goatWander
									)
								else
									(gGoat setScript: goatBobs)
								)
								(ClearFlag 64)
								(gGame changeScore: -2)
							)
						)
					)
					(
						(or
							(Said 'show/carrot')
							(Said 'coax,coax/goat')
							(Said 'show/goat/carrot')
							(Said 'coax,coax/goat/carrot')
						)
						(cond
							((not (gEgo has: 2)) ; Carrot
								(proc0_6) ; "You don't have anything that fits that description in your inventory."
							)
							((IsFlag 2)
								(Print 10 20) ; "The goat is already following you."
							)
							(
								(and
									(& (gGoat onControl: 1) $3000)
									(not (& (gEgo onControl:) $3000))
								)
								(Print 10 21) ; "You need to get into the goat pen."
							)
							((> (gEgo distanceTo: gGoat) 36)
								(Print 10 22) ; "You need to get a little closer."
							)
							((IsFlag 1)
								(Print 10 23) ; "The goat, unable to see either you or the carrot, is not impressed in the slightest by the carrot."
							)
							((gCurRoom script:)
								(PrintTooBusy)
							)
							(
								(and
									(not (IsFlag 36))
									(& (gEgo onControl: 1) $3000)
									(not (& (gGoat onControl: 1) $3000))
								)
								(Print 10 24) ; "The goat must be on the other side of the goat pen."
							)
							(else
								(gCurRoom setScript: getGoat)
							)
						)
					)
					((or (Said 'shoot/goat') (Said 'kill/goat/shot'))
						(cond
							(global119
								(Print 10 25) ; "He's already dead, it just wouldn't be the same."
							)
							((gCurRoom script:)
								(PrintTooBusy)
							)
							((IsFlag 1)
								(Print 10 26) ; "You can't do that while your invisible."
							)
							(
								(and
									(not (IsFlag 36))
									(not (& (gGoat onControl:) $3000))
								)
								(Print 10 24) ; "The goat must be on the other side of the goat pen."
							)
							((or (not (gEgo has: 9)) (not (gEgo has: 10))) ; Pebbles, Leather_Slingshot
								(Print 10 27) ; "You don't have everything you need to do that."
							)
							(else
								(Print 10 28) ; "Pelting the goat with pebbles would be a slow and painful way to kill him. If you feel you absolutely must do away with him, use a quicker method."
							)
						)
					)
					((or (Said 'stab,kill/goat') (Said 'use,throw/dagger'))
						(cond
							(global119
								(Print 10 25) ; "He's already dead, it just wouldn't be the same."
							)
							((gCurRoom script:)
								(PrintTooBusy)
							)
							((and (> (gGoat x:) 320) (not (IsFlag 36)))
								(Print 10 24) ; "The goat must be on the other side of the goat pen."
							)
							(
								(and
									(not (& (gEgo onControl: 1) $3000))
									(not (IsFlag 36))
								)
								(Print 10 29) ; "You need to go into the pen to kill the goat."
							)
							((> (gEgo distanceTo: gGoat) 35)
								(Print 10 30) ; "You should get closer to the goat first."
							)
							((not (gEgo has: 0)) ; Dagger
								(Print 10 31) ; "You don't have a good weapon with which to kill the goat."
							)
							(else
								(gCurRoom setScript: (ScriptID 600 2)) ; killGoat
							)
						)
					)
				)
			)
			((or (Said '/goat') (Said 'show/carrot'))
				(cond
					((IsFlag 1)
						(Print 10 32) ; "Since you are invisible, everything you own is invisible. The goat cannot see the carrot."
					)
					((IsFlag 2)
						(Print 10 20) ; "The goat is already following you."
					)
					(else
						(Print 10 33) ; "There is no goat in the immediate area."
					)
				)
			)
		)
		(cond
			((Said 'jump/fence')
				(Print 10 34) ; "The fence is too high for you to jump over."
			)
			((Said 'climb,climb/fence')
				(Print 10 35) ; "It would be easier to just open the gate."
			)
			(
				(or
					(Said 'look,look/fence')
					(proc0_14 event 215 131 319 157)
					(proc0_14 event 198 121 214 148)
					(proc0_14 event 186 103 199 124)
					(proc0_14 event 191 73 215 86)
					(proc0_14 event 178 81 192 98)
					(proc0_14 event 215 66 319 83)
				)
				(if (& (gEgo onControl: 1) $3000)
					(Print 10 36) ; "It is high enough to keep the old goat from jumping over it."
				else
					(Print 10 37) ; "The goat pen is crudely made of small tree limbs. At the other end you see a gate."
				)
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room,fence]')
						(if (& (gEgo onControl: 1) $3000)
							(Print 10 38) ; "You are in the small goat pen."
						else
							(Print 10 39) ; "Someone has built a small goat pen here."
						)
					)
					((Said '/gate')
						(Print 10 40) ; "You see a gate at the other end of the goat pen."
					)
				)
			)
			((Said 'open,open,close,close,find/gate')
				(Print 10 41) ; "There must be a gate around here somewhere."
			)
			((Said 'hit,kick/goat')
				(if global119
					(Print 10 42) ; "That would be very much like beating a dead horse, wouldn't it?"
				else
					(Print 10 43) ; "A gallant knight such as yourself would never attack an innocent goat."
				)
			)
		)
	)
)

(instance goatLpr of TurnLooper
	(properties)
)

(instance pen of Cage
	(properties
		top 92
		left 213
		bottom 142
		right 316
	)
)

(instance goatWander of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(cond
			((and (not global119) (< (gEgo distanceTo: gGoat) 30))
				(= cycles 0)
				(gGoat setScript: goatRuns)
			)
			((== (-- local0) 0)
				(gGoat setScript: changeGoatRoom)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGoat setLoop: -1 setMotion: Wander startUpd:)
				(= cycles (Random 14 30))
			)
			(1
				(gGoat setMotion: 0)
				(= cycles (Random 8 17))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance goatRuns of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGoat
					setAvoider: mwAvoider
					ignoreBlocks: pen
					setMotion: MoveTo 333 (gGoat y:) self
				)
			)
			(1
				(= global129 11)
				(gGoat hide: setScript: goatCounter)
				(self dispose:)
			)
		)
	)
)

(instance getGoat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc0_15 gEgo gGoat)
				(proc0_15 gGoat gEgo)
				(gEgo view: 21 cel: 0 setCycle: End)
				(gGoat setMotion: 0 setScript: 0)
				(= cycles 22)
			)
			(1
				(if (IsFlag 4)
					(Print 10 44) ; "The old goat shows some interest in the carrot."
				else
					(Print 10 45) ; "Very clever! You tempt the goat with the carrot and he begins to follow you around. You've made a friend!"
					(SetScore 80 5)
				)
				((ScriptID 0 21) number: 60 init: play:) ; gameSound
				(gEgo setCycle: Beg self)
			)
			(2
				(proc0_1)
				(HandsOn)
				(if (not (IsFlag 4))
					(gGoat setAvoider: Avoid setMotion: Follow gEgo 50)
					(SetFlag 2)
				)
				(self dispose:)
			)
		)
	)
)

(instance changeGoatRoom of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 0) (& (gGoat onControl:) $3000))
			(= global129 10)
		else
			(= global129 11)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== global129 10)
					(gGoat
						setLoop: -1
						setAvoider: mwAvoider
						ignoreBlocks: pen
						setMotion: MoveTo 340 (gGoat y:) self
					)
				else
					(gGoat
						show:
						setLoop: -1
						setAvoider: 0
						setMotion: MoveTo 300 (gGoat y:) self
					)
				)
			)
			(1
				(if (!= global129 10)
					(self changeState: 2)
				else
					(gGoat observeBlocks: pen setScript: goatWander)
					(= local0 (Random (Random 100 140) (Random 160 200)))
					(self dispose:)
				)
			)
			(2
				(if (and (IsFlag 23) (== global129 11))
					(self dispose:)
				else
					(= cycles 70)
				)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance goatCounter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 70)
			)
			(1
				(client setScript: changeGoatRoom)
				(self dispose:)
			)
		)
	)
)

(instance goatBobs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGoat
					setAvoider: 0
					illegalBits: $c03e
					setMotion:
						MoveTo
						(Random 10 310)
						(Random (+ (gCurRoom horizon:) 2) 180)
				)
				(= cycles (Random 20 40))
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance trough of NewFeature
	(properties
		x 286
		y 82
		noun '/trough'
		nsTop 77
		nsLeft 260
		nsBottom 87
		nsRight 313
		description {trough}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is the goat's trough, currently empty.__Goats are always hungry!}
	)
)

(instance tree8 of NewFeature
	(properties
		x 78
		y 50
		noun '/ceder'
		nsTop -1
		nsBottom 101
		nsRight 157
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There are numerous beautiful trees ringing the goat pen.}
	)
)

(instance tree7 of NewFeature
	(properties
		x 27
		y 142
		noun '/ceder'
		nsTop 101
		nsLeft 10
		nsBottom 184
		nsRight 44
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There are numerous beautiful trees ringing the goat pen.}
	)
)

(instance tree6 of NewFeature
	(properties
		x 53
		y 111
		noun '/ceder'
		nsTop 101
		nsLeft 43
		nsBottom 121
		nsRight 63
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There are numerous beautiful trees ringing the goat pen.}
	)
)

(instance tree5 of NewFeature
	(properties
		x 84
		y 111
		noun '/ceder'
		nsTop 101
		nsLeft 63
		nsBottom 122
		nsRight 105
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There are numerous beautiful trees ringing the goat pen.}
	)
)

(instance tree4 of NewFeature
	(properties
		x 165
		y 37
		noun '/ceder'
		nsTop -1
		nsLeft 157
		nsBottom 76
		nsRight 173
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There are numerous beautiful trees ringing the goat pen.}
	)
)

(instance tree3 of NewFeature
	(properties
		x 181
		y 23
		noun '/ceder'
		nsTop -1
		nsLeft 172
		nsBottom 48
		nsRight 191
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There are numerous beautiful trees ringing the goat pen.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 255
		y 17
		noun '/ceder'
		nsTop -1
		nsLeft 191
		nsBottom 36
		nsRight 320
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There are numerous beautiful trees ringing the goat pen.}
	)
)

(instance tree1 of NewFeature
	(properties
		x 244
		y 45
		noun '/ceder'
		nsTop 36
		nsLeft 229
		nsBottom 54
		nsRight 259
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There are numerous beautiful trees ringing the goat pen.}
	)
)

(instance tree of NewFeature
	(properties
		x 252
		y 63
		noun '/ceder'
		nsTop 54
		nsLeft 242
		nsBottom 72
		nsRight 262
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There are numerous beautiful trees ringing the goat pen.}
	)
)

(instance bush of NewFeature
	(properties
		x 164
		y 110
		noun '/bush'
		nsTop 104
		nsLeft 146
		nsBottom 117
		nsRight 183
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There are many small decorative bushes scattered around Daventry.}
	)
)

(instance bush1 of NewFeature
	(properties
		x 173
		y 99
		noun '/bush'
		nsTop 94
		nsLeft 166
		nsBottom 104
		nsRight 181
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There are many small decorative bushes scattered around Daventry.}
	)
)

