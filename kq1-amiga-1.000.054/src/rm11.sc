;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Main)
(use Interface)
(use mwAvoider)
(use TurnLooper)
(use Blk)
(use LoadMany)
(use DPath)
(use Wander)
(use Follow)
(use Avoid)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm11 0
)

(local
	local0
)

(instance rm11 of Rm
	(properties
		picture 11
		horizon 57
		north 22
		east 12
		south 6
		west 10
	)

	(method (init)
		(LoadMany rsSOUND 22 23)
		(LoadMany rsVIEW 211 21 166)
		(self
			style:
				(switch gPrevRoomNum
					(north 5)
					(west 41)
					(east 2)
					(south 4)
				)
		)
		(super init:)
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_17 192 (gEgo x:) 0) (+ horizon 2))
			)
			(south
				(gEgo posn: (proc0_17 236 (gEgo x:) 0) 188)
			)
			(west
				(gEgo
					y:
						(proc0_17
							189
							(proc0_18 160 (gEgo y:) 158)
							(+ horizon 2)
						)
				)
			)
			(else
				(gEgo
					posn: 317 (proc0_17 182 (proc0_18 138 (gEgo y:) 120) 99)
				)
			)
		)
		(gEgo init:)
		(proc0_1)
		(gate init:)
		(if (IsFlag 23)
			(gate ignoreActors: cel: 3)
			(gEgo illegalBits: -16384)
			(cond
				((and (!= gPrevRoomNum 10) (not global119) (not (IsFlag 80)))
					(SetFlag 80)
					(Print 11 0) ; "Oh, no! The goat has escaped through the gate that you left open behind you. He could have wandered anywhere by now."
				)
				((and (not global119) (not (IsFlag 80)) (== global129 11))
					(SetFlag 80)
					(Print 11 0) ; "Oh, no! The goat has escaped through the gate that you left open behind you. He could have wandered anywhere by now."
				)
			)
		)
		(gate stopUpd:)
		(if (and (not (IsFlag 2)) (not global119) (not (IsFlag 80)))
			(Load rsVIEW 21)
			(Load rsVIEW 167)
			(goatLpr viewChange: 167)
			(if (and (== global129 10) (not (IsFlag 36)))
				(gGoat
					view: 165
					posn: -20 (Random 120 140)
					init:
					looper: goatLpr
					setCycle: Walk
					setScript: changeGoatRoom
				)
				(= local0 (Random (Random 100 140) (Random 160 200)))
			else
				(gGoat
					view: 165
					posn: (Random 20 40) (Random 120 140)
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

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(EDGE_TOP north)
						(EDGE_RIGHT east)
						(EDGE_BOTTOM south)
						(EDGE_LEFT west)
					)
				)
				(self newRoom: temp0)
			)
			(
				(and
					(IsFlag 2)
					(IsFlag 36)
					(not (& (gGoat onControl: 1) $7000))
					(& (gEgo onControl: 1) $7000)
					(or
						(>= (gEgo distanceTo: gate) 107)
						(< (gEgo y:) 116)
					)
				)
				(ClearFlag 2)
				(self setScript: goatLeaves)
			)
			(
				(and
					(IsFlag 2)
					(not (IsFlag 36))
					(not (gGoat script:))
					(not (& (gEgo onControl: 1) $7000))
					(IsFlag 23)
					(not (< (gEgo y:) (gGoat y:)))
				)
				(if (not (gEgo inRect: 81 157 160 177))
					(gGoat setScript: goatOutaGate)
				else
					(gGoat setMotion: 0)
				)
			)
			((and (IsFlag 36) (& (gGoat onControl: 1) $1000))
				(ClearFlag 36)
			)
			((and (not (gGoat script:)) (!= (gGoat illegalBits:) -8132))
				(gGoat illegalBits: -8132)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((Said 'rub/ring')
				(cond
					((IsFlag 1)
						(Print 11 1) ; "You are already invisible"
					)
					((not global134)
						(Print 11 2) ; "Nothing happens."
					)
					((IsFlag 17)
						(Print 11 3) ; "As you rub the shimmering ring, you turn invisible!"
						(SetFlag 1)
						(proc0_1)
						(if (IsFlag 23)
							(gEgo observeControl: 16384)
						)
						(if (and (IsFlag 2) (not (IsFlag 36)))
							(Print 11 4) ; "The goat doesn't see you anymore."
							(ClearFlag 2)
							(ClearFlag 80)
							(goatLpr viewChange: 167)
							(if (== global129 10)
								(gGoat
									posn: -20 (Random 120 140)
									init:
									looper: goatLpr
									setCycle: Walk
									setScript: changeGoatRoom
								)
								(= local0
									(Random (Random 100 140) (Random 160 200))
								)
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
						(Print 11 5) ; "The magic ring is still in your pocket. You can't rub it there."
					)
				)
			)
			((or (Said 'remove/ring') (Said 'get<off/ring'))
				(cond
					((== (gEgo view:) (if (IsFlag 0) 23 else 16))
						(PrintTooBusy)
					)
					((not (IsFlag 17))
						(Print 11 6) ; "You aren't wearing the ring, Sir Graham."
					)
					(else
						(Print 11 7) ; "You remove the shimmering ring from your finger."
						(ClearFlag 17)
						(ClearFlag 1)
						(proc0_1)
					)
				)
			)
			((or (Said 'look,look/bush') (proc0_14 event 263 151 320 189))
				(Print 11 8) ; "There is a small bush near the pen."
			)
			(
				(or
					(Said 'look,look/ceder')
					(proc0_14 event 177 -1 319 51)
					(proc0_14 event 224 52 319 99)
				)
				(Print 11 9) ; "There are several willowy shade trees around the goat pen."
			)
			(
				(or
					(Said 'look,look/fence')
					(proc0_14 event 0 133 86 159)
					(proc0_14 event 141 129 162 150)
					(proc0_14 event 0 64 99 83)
					(proc0_14 event 99 65 129 82)
				)
				(Print 11 10) ; "This is the crude wooden fence that encloses the goat and his trough."
			)
			((gCast contains: gGoat)
				(cond
					(global119
						(event claimed: 0)
					)
					((or (Said 'talk,talk,say,call') (Said '/hello'))
						(Print 11 11) ; "Silly! Goats can't talk."
					)
					((Said 'capture,pull,pull,get,get/goat')
						(cond
							((IsFlag 2)
								(Print 11 12) ; "Why? The goat seems to be following you quite nicely."
							)
							((& (gEgo onControl: 1) $7000)
								(Print 11 13) ; "You wouldn't get very far carrying the goat. Perhaps you can get him to follow you if you'd like to take him somewhere."
							)
							(else
								(Print 11 14) ; "You cannot do that from outside the fence."
							)
						)
					)
					((Said 'feed/goat[/!*]')
						(Print 11 15) ; "What do you want to feed the old goat?"
					)
					((Said 'pet,free/goat')
						(Print 11 16) ; "You can try, but be careful."
					)
					((Said 'ride/goat')
						(Print 11 17) ; "Are you kidding? The goat would never let you!"
					)
					((or (Said 'feed/carrot') (Said 'give/carrot'))
						(cond
							((not (gEgo has: 2)) ; Carrot
								(Print 11 18) ; "You do not have a carrot."
							)
							((> (gEgo distanceTo: gGoat) 32)
								(Print 11 19) ; "You are too far away."
							)
							((IsFlag 1)
								(Print 11 20) ; "The goat, unable to see either you or the carrot, doesn't react to your offering."
							)
							(else
								(if (IsFlag 2)
									(Print 11 21) ; "Goats love carrots! The old goat quickly devours yours and stops following you."
								else
									(Print 11 22) ; "Goats love carrots! The old goat quickly devours yours."
								)
								(proc0_8 2 15)
								(ClearFlag 2)
								(if
									(and
										(not (IsFlag 23))
										(& (gGoat onControl: 1) $7000)
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
								(Print 11 23) ; "The goat is already following you."
							)
							(
								(and
									(& (gGoat onControl: 1) $7000)
									(not (& (gEgo onControl: 1) $7000))
								)
								(Print 11 24) ; "You need to get into the goat pen."
							)
							((IsFlag 1)
								(Print 11 25) ; "The goat, unable to see either you or the carrot, is not impressed in the slightest by the carrot."
							)
							((> (gEgo distanceTo: gGoat) 36)
								(Print 11 26) ; "You need to get a little closer."
							)
							((gCurRoom script:)
								(PrintTooBusy)
							)
							(
								(and
									(not (IsFlag 36))
									(& (gEgo onControl: 1) $7000)
									(not (& (gGoat onControl:) $7000))
								)
								(Print 11 27) ; "The goat must be on the other side of the goat pen."
							)
							(else
								(gCurRoom setScript: getGoat)
							)
						)
					)
					((or (Said 'shoot/goat') (Said 'kill/goat/shot'))
						(cond
							(global119
								(Print 11 28) ; "He's already dead, it just wouldn't be the same."
							)
							((gCurRoom script:)
								(PrintTooBusy)
							)
							((IsFlag 1)
								(Print 11 29) ; "You can't do that while your invisible."
							)
							(
								(and
									(not (IsFlag 36))
									(not (& (gGoat onControl:) $7000))
								)
								(Print 11 27) ; "The goat must be on the other side of the goat pen."
							)
							((or (not (gEgo has: 9)) (not (gEgo has: 10))) ; Pebbles, Leather_Slingshot
								(Print 11 30) ; "You don't have everything you need to do that."
							)
							(else
								(Print 11 31) ; "Pelting the goat with pebbles would be a slow and painful way to kill him. If you feel you absolutely must do away with him, use a quicker method."
							)
						)
					)
					((or (Said 'stab,kill/goat') (Said 'use,throw/dagger'))
						(cond
							(global119
								(Print 11 28) ; "He's already dead, it just wouldn't be the same."
							)
							((gCurRoom script:)
								(PrintTooBusy)
							)
							((and (< (gGoat x:) 0) (not (IsFlag 36)))
								(Print 11 27) ; "The goat must be on the other side of the goat pen."
							)
							(
								(and
									(not (& (gEgo onControl: 1) $7000))
									(not (IsFlag 36))
								)
								(Print 11 32) ; "You need to go into the pen to kill the goat."
							)
							((> (gEgo distanceTo: gGoat) 35)
								(Print 11 33) ; "You should get closer to the goat first."
							)
							((not (gEgo has: 0)) ; Dagger
								(Print 11 34) ; "You don't have a good weapon with which to kill the goat."
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
						(Print 11 35) ; "You and all your belongings are invisible. The goat can't see your carrot."
					)
					((IsFlag 2)
						(Print 11 23) ; "The goat is already following you."
					)
					((IsFlag 80)
						(Print 11 36) ; "The goat seems to have left through the gate."
					)
					(else
						(Print 11 37) ; "There is no goat in the immediate area."
					)
				)
			)
		)
		(cond
			((Said 'jump/fence')
				(Print 11 38) ; "The fence is too high for you to jump over."
			)
			((Said 'climb,climb/fence,gate')
				(if (IsFlag 23)
					(Print 11 39) ; "The gate to the pen is open."
				else
					(Print 11 40) ; "It would be easier to just open the gate."
				)
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room,fence]')
						(if (& (gEgo onControl: 1) $7000)
							(Print 11 41) ; "You are in the small goat pen."
						else
							(Print 11 42) ; "Someone has built a small goat pen here."
						)
					)
					((Said '/fence')
						(if (& (gEgo onControl: 1) $7000)
							(Print 11 43) ; "It is high enough to keep the old goat from jumping over it."
						else
							(Print 11 44) ; "The goat pen is crudely made of small tree limbs. At this end you see a gate."
						)
					)
					((Said '/gate')
						(if (IsFlag 23)
							(Print 11 39) ; "The gate to the pen is open."
						else
							(Print 11 45) ; "The gate to the pen is closed."
						)
					)
					((Said '/trough')
						(Print 11 46) ; "You see the goats trough near the other end of the pen."
					)
				)
			)
			((Said 'open,open/gate,door')
				(cond
					((not (gEgo inRect: 77 126 132 166))
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
					((IsFlag 23)
						(Print 11 47) ; "The gate is already open."
					)
					(else
						(gate setScript: openIt)
					)
				)
			)
			((Said 'close,close/gate,door')
				(cond
					((IsFlag 2)
						(Print 11 48) ; "There is no need to close the gate, since the goat seems content to follow you."
					)
					((not (gEgo inRect: 77 126 132 166))
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
					((not (IsFlag 23))
						(Print 11 49) ; "The gate is already closed."
					)
					(else
						(gate setScript: closeIt)
					)
				)
			)
			((Said 'hit,kick/goat')
				(if global119
					(Print 11 50) ; "That would be very much like beating a dead horse, wouldn't it?"
				else
					(Print 11 51) ; "A gallant knight such as yourself would never attack an innocent goat."
				)
			)
		)
	)
)

(instance gate of Prop
	(properties
		x 141
		y 158
		view 211
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((MousedOn self event 3)
				(if (IsFlag 23)
					(Print 11 39) ; "The gate to the pen is open."
				else
					(Print 11 45) ; "The gate to the pen is closed."
				)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance goatLpr of TurnLooper
	(properties)
)

(instance pen of Cage
	(properties
		top 85
		left 1
		bottom 156
		right 130
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
					setMotion: MoveTo -20 (gGoat y:) self
				)
				(if (gGoat blocks:)
					(gGoat ignoreBlocks: pen)
				)
			)
			(1
				(= global129 10)
				(gGoat hide: setScript: goatCounter)
				(self dispose:)
			)
		)
	)
)

(instance openIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if
					(and
						(gCurRoom script:)
						(== (gEgo view:) (if (IsFlag 0) 23 else 16))
					)
					((gCurRoom script:) cue:)
					(= cycles 7)
				else
					(self cue:)
				)
			)
			(1
				(if
					(or
						(& (gEgo onControl: 1) $2000)
						(& (gEgo onControl: 1) $4000)
					)
					(gEgo setMotion: MoveTo 99 139 self)
				else
					(self cue:)
				)
			)
			(2
				((ScriptID 0 21) number: 22 init: play:) ; gameSound
				(= cycles 3)
			)
			(3
				(proc0_15 gEgo 100 160)
				(proc0_7)
				(gate cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(4
				(gate ignoreActors: 1 stopUpd:)
				(SetFlag 23)
				(gEgo illegalBits: -16384)
				(gGoat illegalBits: -16384)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance closeIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setAvoider: Avoid)
				(cond
					((& (gEgo onControl: 1) $2000)
						(if (< (gEgo x:) 114)
							(gEgo setMotion: DPath 104 151 114 163 self)
						else
							(gEgo
								setMotion:
									DPath
									114
									(gEgo y:)
									104
									151
									114
									163
									self
							)
						)
					)
					(
						(and
							(& (gEgo onControl:) $7000)
							(& (gEgo onControl:) $2000)
						)
						(gEgo
							setMotion:
								MoveTo
								(- (gEgo x:) 8)
								(- (gEgo y:) 3)
								self
						)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(gEgo setAvoider: 0)
				((ScriptID 0 21) number: 23 init: play:) ; gameSound
				(= cycles 3)
			)
			(2
				(proc0_15 gEgo 100 160)
				(proc0_7)
				(gate cel: 3 cycleSpeed: 2 setCycle: Beg self)
			)
			(3
				(gate ignoreActors: 0 stopUpd:)
				(ClearFlag 23)
				(gEgo illegalBits: -32768)
				(gGoat illegalBits: -32768)
				(HandsOn)
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
				((ScriptID 0 21) number: 60 loop: 1 init: play:) ; gameSound
				(if (IsFlag 4)
					(Print 11 52) ; "The old goat shows some interest in the carrot."
				else
					(Print 11 53) ; "When you tempt the old goat with the carrot, he starts to follow you."
					(SetScore 80 5)
				)
				(gEgo setCycle: Beg self)
			)
			(2
				(proc0_1)
				(HandsOn)
				(if (IsFlag 23)
					(gEgo illegalBits: -16384)
				)
				(if (not (IsFlag 4))
					(gGoat setAvoider: Avoid setMotion: Follow gEgo 50)
					(SetFlag 2)
				)
				(self dispose:)
			)
		)
	)
)

(instance goatOutaGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 11 54) ; "You had better wait for the goat, or he may not follow you."
				(proc0_15 gEgo gGoat)
				(gGoat
					illegalBits: 0
					ignoreActors: 1
					setPri: 2
					setMotion: MoveTo 80 134 self
				)
			)
			(1
				(gGoat
					illegalBits: 0
					ignoreActors: 1
					setPri: 11
					setMotion: MoveTo 122 165 self
				)
				(if (gGoat blocks:)
					(gGoat ignoreBlocks: pen)
				)
			)
			(2
				(gGoat setMotion: MoveTo 124 170 self)
			)
			(3
				(proc0_15 gGoat gEgo)
				(gGoat
					setPri: -1
					illegalBits: -16384
					ignoreActors: 0
					setMotion: Follow gEgo 50
				)
				(SetFlag 36)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance changeGoatRoom of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 0) (& (gGoat onControl:) $7000))
			(= global129 11)
		else
			(= global129 10)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== global129 11)
					(gGoat
						setLoop: -1
						setAvoider: mwAvoider
						setMotion: MoveTo -20 (gGoat y:) self
					)
					(if (gGoat blocks:)
						(gGoat ignoreBlocks: pen)
					)
				else
					(gGoat
						show:
						setLoop: -1
						setAvoider: 0
						setMotion: MoveTo 30 (gGoat y:) self
					)
				)
			)
			(1
				(if (!= global129 11)
					(self changeState: 2)
				else
					(gGoat observeBlocks: pen setScript: goatWander)
					(= local0 (Random (Random 100 140) (Random 160 200)))
					(self dispose:)
				)
			)
			(2
				(= cycles 70)
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
					illegalBits: -16322
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

(instance goatLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(proc0_15 gEgo gGoat)
				(gGoat setMotion: MoveTo (gGoat x:) 220 self)
			)
			(1
				(Print 11 55) ; "While you are wandering about in the goat's pen, the goat grows tired of standing around waiting for you and decides to go on his separate way."
				(self cue:)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

