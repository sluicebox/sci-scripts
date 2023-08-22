;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 93)
(include sci.sh)
(use Main)
(use n100)
(use n101)
(use n102)
(use n104)
(use n105)
(use n106)
(use TargActor)
(use LoadMany)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	rm93 0
	minotaur 1
	gate 2
	openGate 3
	bell 4
	archer1 5
	archer2 6
	archer3 7
	archer4 8
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8 = 5
	local9
	local10
	local11
)

(procedure (localproc_0 &tmp temp0)
	(= temp0 1)
	(switch local3
		(0
			(if (< (+ (minotaur x:) local8) (gEgo x:))
				(= temp0 0)
			)
		)
		(1
			(if (< (gEgo x:) (- (minotaur x:) local8))
				(= temp0 0)
			)
		)
		(2
			(if (< (+ (minotaur y:) local8) (gEgo y:))
				(= temp0 0)
			)
		)
		(else
			(if (< (gEgo y:) (- (minotaur y:) local8))
				(= temp0 0)
			)
		)
	)
	(return temp0)
)

(procedure (localproc_1)
	(return
		(not
			(or
				local6
				local7
				local9
				(gEgo inRect: 0 120 31 130)
				(gEgo inRect: 238 0 330 106)
				(gEgo inRect: 61 153 82 154)
				(and (== gEgoGait 2) (>= [gEgoStats 8] 50) (localproc_0)) ; sneaking, stealth
				(== (minotaur script:) minotaurLooks)
				(IsFlag 237)
			)
		)
	)
)

(instance rm93 of Rm
	(properties
		picture 93
		style 8
	)

	(method (dispose)
		(gMouseHandler delete: self)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 93 550 5 523 510 538 426 503 524)
		(Load rsSOUND 23)
		(gContMusic priority: 1 number: 23 loop: -1 play:)
		(super init:)
		(gMouseHandler add: self)
		(self setFeatures: onBell onSign onDoor onBush onRock onFort)
		(SL enable:)
		(NormalEgo)
		(HandsOff)
		(gateSign setPri: 6 init: addToPic:)
		(bell setPri: 6 init: stopUpd:)
		(bush init: stopUpd:)
		(if (IsFlag 238)
			(gate setCel: 3 setPri: 6 ignoreActors: init: stopUpd:)
			(gEgo illegalBits: -32768)
		else
			(gate setCel: 0 setPri: 6 init: stopUpd:)
			(gEgo illegalBits: -28672)
		)
		(if (not (IsFlag 237))
			(= global332 425)
			(= global333 186)
		)
		(switch gPrevRoomNum
			(89
				(= local0 1)
				(if (not (IsFlag 237))
					(Load rsVIEW 425)
					(= local4 1)
					(= local3 0)
					(minotaur illegalBits: 0 init: setScript: patrol)
				)
				(gEgo posn: 2 123 init: setScript: (ScriptID 271 0)) ; egoEntersWest
			)
			(94
				(if (not (IsFlag 237))
					(Load rsVIEW 425)
					(= local4 0)
					(= local3 1)
					(minotaur
						setLoop: 1
						posn: 145 162
						illegalBits: 0
						init:
						setScript: patrol
					)
				)
				(if (IsFlag 238)
					(gEgo posn: 174 98 init: setScript: (ScriptID 272 0)) ; egoEntersNorth
				else
					(gEgo posn: 143 108 init: setScript: (ScriptID 275 0)) ; egoClimbsDown
				)
			)
			(425 ; minotaurArena
				(Load rsVIEW 519)
				(Load rsVIEW 426)
				(SetFlag 237)
				(minotaur view: 426 setLoop: 0 setCel: 0 init: posn: 230 145)
				(gEgo posn: 235 158 init: setScript: (ScriptID 274 0)) ; egoEntersFromCombat
			)
			(else
				(if (not (IsFlag 237))
					(Load rsVIEW 425)
					(= local4 0)
					(= local3 1)
					(minotaur illegalBits: 0 init: setScript: patrol)
				)
				(gEgo posn: 235 188 init: setScript: (ScriptID 273 0)) ; egoEntersSouth
			)
		)
	)

	(method (notify param1)
		(switch param1
			(0
				(= local1 1)
			)
			(1
				(= local1 0)
			)
			(2
				(= local9 1)
			)
			(3
				(= local9 0)
			)
		)
	)

	(method (doit)
		(cond
			((and local1 (== (gEgo edgeHit:) EDGE_LEFT))
				(SetFlag 83)
				(= global332 (= global333 0))
				(gCurRoom newRoom: 89)
			)
			((and local1 (& (gEgo onControl: 1) $1000))
				(SetFlag 83)
				(= global332 (= global333 0))
				(gCurRoom newRoom: 94)
			)
			((or (== (gEgo edgeHit:) EDGE_BOTTOM) (== (gEgo edgeHit:) EDGE_RIGHT))
				(SetFlag 83)
				(= global332 (= global333 0))
				(gCurRoom newRoom: 91)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evMOUSEBUTTON
				(cond
					((super handleEvent: event))
					((MouseClaimed gEgo event 3)
						(HighPrint 93 0) ; "To the Minotaur, you look like a nice meal."
					)
				)
			)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'rest,nap')
						(EgoDead 93 1 80 {Z-Z-Z-Z-Z-Z-Z-Z-Z-Z} 82 800 0 0) ; "The Brigands oblige you by making your pleasant rest permanent!"
					)
					((Said 'look>')
						(cond
							((Said '[<at,around][/place,area]')
								(HighPrint 93 2) ; "Sheer cliff walls form a narrow box canyon where the brigands have built a fortress."
							)
							((Said '[<at]/boulder')
								(HighPrint 93 3) ; "The rocks look to be good hiding places."
							)
							((Said '[<at]/cliff')
								(HighPrint 93 4) ; "The rock walls look steep."
							)
							((Said '[<at]/log,gate')
								(HighPrint 93 5) ; "The gate appears to be fastened somehow on the inside."
							)
							((or (Said '<up') (Said '/sky'))
								(HighPrint 93 6) ; "The cliff seems very hard to climb."
							)
							((or (Said '<down') (Said '/ground,grass'))
								(HighPrint 93 7) ; "You can see marks in the ground, leading towards the bush."
							)
							((Said '/bush')
								(if local0
									(HighPrint 93 8) ; "You see a bush that conceals the secret entrance."
								else
									(HighPrint 93 9) ; "The bush sits next to the cliff. There are marks on the ground near the bush."
								)
							)
							((Said '/west')
								(if local0
									(HighPrint 93 10) ; "You see that where the steep cliff walls meet the fortress, there is a pile of gravel. Once away from the secret passage exit, the fortress is entirely obscured by rocks and brush."
								else
									(HighPrint 93 11) ; "The cliff to the west looks too sheer to climb. There is a bush growing close to the cliff."
								)
							)
							((Said '/north')
								(HighPrint 93 12) ; "You see what must be the log walls and gate of the brigand fortress."
							)
							((Said '/east')
								(HighPrint 93 13) ; "You see where the sheer cliff walls meet the fortress wall with a pile of rocks."
							)
							((Said '/south')
								(HighPrint 93 14) ; "The walls of the canyon turn to the west. You can see a large Minotaur patrolling the canyon."
							)
							((Said '/bell')
								(HighPrint 93 15) ; "A warning bell to alert all the brigands in the fortress."
							)
							((Said '/sign')
								(if (gEgo inRect: 150 92 250 140)
									(HighPrint 93 16) ; "The sign reads "Ring bell"."
								else
									(HighPrint 93 17) ; "Step over and get a close look."
								)
							)
						)
					)
					((Said 'cast>')
						(= local5 (SaidSpell event))
						(if (CastSpell local5)
							(switch local5
								(18
									(HighPrint 93 18) ; "There is no magical aura present."
								)
								(20
									(cond
										(
											(or
												(IsFlag 237)
												local6
												local9
												local7
											)
											(HighPrint 93 19) ; "You waste a spell."
										)
										((CastDazzle gEgo minotaurDazzled)
											(minotaur
												setScript: minotaurDazzled
											)
										)
									)
								)
								(23
									(cond
										(
											(or
												(gEgo inRect: 47 141 90 163)
												(gEgo inRect: 0 119 35 126)
												(gEgo inRect: 238 0 330 106)
											)
											(HighPrint 93 20) ; "You'll have to give yourself room."
										)
										((IsFlag 237)
											(CastDart 0)
										)
										(else
											(if (< (gEgo x:) 160)
												(minotaur targDeltaX: -25)
											else
												(minotaur targDeltaX: 25)
											)
											(CastDart minotaur)
											(if (or local6 local7)
												(minotaur setScript: patrol)
											)
										)
									)
								)
								(22
									(cond
										((or (IsFlag 237) local6)
											(HighPrint 93 19) ; "You waste a spell."
										)
										((CastCalm gEgo minotaurCalmed)
											(minotaur setScript: minotaurCalmed)
										)
									)
								)
								(17
									(if (or local2 (IsFlag 238))
										(HighPrint 93 19) ; "You waste a spell."
									else
										(CastOpen gEgo openMess)
										(gate setScript: openMess)
									)
								)
								(else
									(HighPrint 93 19) ; "You waste a spell."
								)
							)
						)
					)
					((Said 'throw/dagger,dagger')
						(cond
							(
								(or
									(gEgo inRect: 47 141 90 163)
									(gEgo inRect: 0 119 35 126)
									(gEgo inRect: 238 0 330 106)
								)
								(HighPrint 93 20) ; "You'll have to give yourself room."
							)
							((IsFlag 237)
								(ThrowKnife 0)
							)
							(else
								(if (< (gEgo x:) 160)
									(minotaur targDeltaX: -25)
								else
									(minotaur targDeltaX: 25)
								)
								(ThrowKnife minotaur)
								(if (or local6 local7)
									(minotaur setScript: patrol)
								)
							)
						)
					)
					((Said 'throw/boulder')
						(if (and (ThrowRock minotaur) (or local6 local7))
							(minotaur setScript: patrol)
						)
					)
					((Said 'get/boulder')
						(gEgo setScript: (ScriptID 103 0)) ; getRock
					)
					((Said 'climb')
						(cond
							((gEgo inRect: 92 95 214 107)
								(HighPrint 93 21) ; "The logs of the wall are too slick, and there is no place to get a good hold on them. You'll have to try somewhere else."
							)
							((gEgo inRect: 269 120 303 151)
								(HighPrint 93 22) ; "There is no good climbing place on the rock cliff to the east."
							)
							((and (< (gEgo x:) 97) (< (gEgo y:) 108))
								(gEgo setScript: (ScriptID 277 0)) ; climbWestCliff
							)
							((gEgo inRect: 238 0 330 106)
								(if (TrySkill 11 65) ; climbing
									(gEgo setScript: (ScriptID 276 0)) ; egoClimbsUp
								else
									(HighPrint 93 23) ; "You don't have enough climbing skill to scale the wall."
								)
							)
							((gEgo inRect: 47 141 90 163)
								(HighPrint 93 24) ; "You can't climb the rock."
							)
							(else
								(HighPrint 93 25) ; "You're not in a good spot for climbing."
							)
						)
					)
					((Said 'open[/gate,door]')
						(cond
							((IsFlag 238)
								(HighPrint 93 26) ; "The gate is open."
							)
							((and local2 (gEgo inRect: 128 95 186 106))
								(gEgo setScript: openGate)
							)
							(local2
								(HighPrint 93 27) ; "You must get closer."
							)
							(else
								(HighPrint 93 28) ; "The gate appears to be fastened somehow on the inside. You'll have to force the gate open."
							)
						)
					)
					((Said 'close,close[/gate,door]')
						(cond
							(
								(and
									(gEgo inRect: 128 95 186 106)
									(IsFlag 238)
								)
								(gEgo setScript: closeGate)
							)
							((IsFlag 238)
								(HighPrint 93 27) ; "You must get closer."
							)
							(else
								(HighPrint 93 29) ; "The gate is closed."
							)
						)
					)
					((Said 'break,force,hit/gate,door')
						(cond
							((IsFlag 238)
								(HighPrint 93 30) ; "What for?"
							)
							((and (< 95 (gEgo x:) 230) (< (gEgo y:) 150))
								(gEgo setScript: (ScriptID 278 0)) ; forceGate
							)
							(else
								(HighPrint 93 27) ; "You must get closer."
							)
						)
					)
					((Said 'knock/door,gate')
						(HighPrint 93 31) ; "Why knock? Use the bell."
					)
					((or (Said 'look/sign') (Said 'read/sign'))
						(if (gEgo inRect: 150 92 250 140)
							(HighPrint 93 16) ; "The sign reads "Ring bell"."
						else
							(HighPrint 93 17) ; "Step over and get a close look."
						)
					)
					((Said 'ring/bell')
						(if (gEgo inRect: 150 92 250 140)
							(bell setScript: (ScriptID 279 0)) ; ringBell
						else
							(HighPrint 93 32) ; "Unless you're Rubber Man you'll have to get closer."
						)
					)
				)
			)
		)
	)
)

(instance gate of Prop
	(properties
		y 95
		x 129
		view 93
	)
)

(instance bell of Prop
	(properties
		y 69
		x 197
		z 1
		view 93
		loop 1
	)
)

(instance gateSign of Prop
	(properties
		y 57
		x 197
		z 1
		view 93
		loop 2
	)
)

(instance bush of Prop
	(properties
		y 128
		x 23
		view 93
		loop 3
	)

	(method (doit)
		(if
			(and
				(not (and (== gEgoGait 2) (>= [gEgoStats 8] 50))) ; sneaking, stealth
				(gEgo inRect: 8 119 35 126)
				(== (bush script:) 0)
			)
			(bush setScript: jerkBush)
		)
		(super doit:)
	)
)

(instance archer1 of Act
	(properties
		y 57
		x 247
		view 93
		loop 4
		priority 5
	)
)

(instance archer2 of Act
	(properties
		y 56
		x 207
		view 93
		loop 4
		priority 5
	)
)

(instance archer3 of Act
	(properties
		y 56
		x 109
		view 93
		loop 5
		priority 5
	)
)

(instance archer4 of Act
	(properties
		y 56
		x 69
		view 93
		loop 5
		priority 5
	)
)

(instance lockSound of Sound
	(properties
		number 35
		priority 3
	)
)

(instance onBell of RFeature
	(properties
		nsTop 56
		nsLeft 193
		nsBottom 68
		nsRight 202
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onBell event 3)
				(HighPrint 93 33) ; "Bell to alert gate guard."
			)
		)
	)
)

(instance onSign of RFeature
	(properties
		nsTop 48
		nsLeft 191
		nsBottom 55
		nsRight 201
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onSign event 3)
				(HighPrint 93 34) ; "Sign reading "Ring Bell"."
			)
		)
	)
)

(instance onDoor of RFeature
	(properties
		nsTop 38
		nsLeft 128
		nsBottom 95
		nsRight 186
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onDoor event 3)
				(HighPrint 93 35) ; "Gate to fortress. A very strong gate."
			)
		)
	)
)

(instance onBush of RFeature
	(properties
		nsTop 85
		nsLeft 9
		nsBottom 128
		nsRight 34
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onBush event 3)
				(HighPrint 93 36) ; "Bush, a good place to hide."
			)
		)
	)
)

(instance onRock of RFeature
	(properties
		nsTop 125
		nsLeft 47
		nsBottom 159
		nsRight 94
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onRock event 3)
				(HighPrint 93 37) ; "A good place to hide."
			)
		)
	)
)

(instance onFort of RFeature
	(properties
		nsBottom 24
		nsRight 320
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onFort event 3)
				(HighPrint 93 38) ; "Brigands' fortress."
			)
		)
	)
)

(instance minotaur of TargActor
	(properties
		y 162
		x 60
		view 425
		targDeltaX 25
		targDeltaY -15
	)

	(method (getHurt param1)
		(cond
			((<= (-= global333 param1) 0)
				(self setScript: minotaurDies)
				(SetFlag 237)
			)
			((not local6)
				(rm93 setScript: delayLook)
			)
		)
	)

	(method (doit)
		(if (and (localproc_1) (not (> (gEgo distanceTo: minotaur) 100)))
			(self setScript: minotaurLooks)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evMOUSEBUTTON
				(cond
					((super handleEvent: event))
					((not (MouseClaimed self event 3)))
					((IsFlag 237)
						(HighPrint 93 39) ; "The Minotaur is out for the count."
					)
					(else
						(HighPrint 93 40) ; "The Minotaur seems to have very sensitive hearing. He looks around every time the bush rustles."
					)
				)
			)
			(evSAID
				(cond
					((Said 'search[/bull,body,flail]')
						(cond
							(local6
								(HighPrint 93 41) ; "As you attempt the search, the sleeping Minotaur awakes, and..."
								(gCurRoom newRoom: 425) ; minotaurArena
							)
							((IsFlag 237)
								(if local10
									(HighPrint 93 42) ; "You've got all the loot you're going to find."
								else
									(= local10 1)
									(if
										(and
											(== gCurRoomNum global273)
											(or
												global271
												global272
												[gInvDropped 7] ; dagger
											)
										)
										(gEgo
											get:
												7 ; dagger
												(+
													global271
													global272
													[gInvDropped 7] ; dagger
												)
										)
										(HighPrint 93 43) ; "You retrieve your daggers."
									)
									(= [gInvDropped 7] ; dagger
										(= global272
											(= global271 (= global273 0))
										)
									)
									(HighPrint 93 44) ; "You quickly search the fallen Minotaur and find nothing."
									(HighPrint 93 45) ; "Wait a minute."
									(HighPrint 93 46) ; "The Minotaur's flail looks peculiar. You pick it up and examine it closely."
									(HighPrint 93 47) ; "Cleverly concealed in the flail are 50 silvers."
									(HighPrint 93 48) ; ""A just reward for defeating such a valiant fighter," you tell yourself as you pocket the silvers."
									(gEgo get: 1 50) ; silver
								)
							)
							(else
								(HighPrint 93 49) ; "That's not a good idea."
							)
						)
					)
					((Said 'look/bull,monster,creature')
						(if (IsFlag 237)
							(HighPrint 93 50) ; "If you've seen one, you've seen them all."
						else
							(HighPrint 93 51) ; "Good ears but very poor peripheral vision."
						)
					)
					((Said 'kill,cut,hit/bull,monster,creature')
						(if (IsFlag 237)
							(HighPrint 93 52) ; "Why bother? He's out for the count."
						else
							(HighPrint 93 53) ; "OK. Here's your chance."
							(gCurRoom newRoom: 425) ; minotaurArena
						)
					)
				)
			)
		)
	)
)

(instance delayLook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(if (localproc_1)
					(minotaur setScript: minotaurLooks)
				)
			)
		)
	)
)

(instance minotaurLooks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(minotaur
					setLoop: 2
					setCel: 0
					setMotion: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(1
				(= local3 2)
				(if (localproc_0)
					(minotaur setLoop: 3 setCel: 1)
					(= cycles 1)
				else
					(self changeState: 3)
				)
			)
			(2
				(minotaur setCel: 2)
				(= local3 3)
				(= cycles 1)
			)
			(3
				(if
					(or
						(gEgo inRect: 0 120 31 130)
						(gEgo inRect: 238 0 330 106)
						(gEgo inRect: 61 153 82 154)
					)
					(if (< 5 local11)
						(= local11 0)
					else
						(++ local11)
					)
					(switch local11
						(0
							(HighPrint 93 54) ; "I've been out here too long. My imagination is taking over."
						)
						(1
							(HighPrint 93 55) ; "What was that noise?"
						)
						(2
							(HighPrint 93 56) ; "Must be those Brigands playing games."
						)
						(3
							(HighPrint 93 57) ; "I guess I'm just getting jumpy."
						)
						(4
							(HighPrint 93 58) ; "Is anyone there?"
						)
						(5
							(HighPrint 93 59) ; "This place is spooky."
						)
					)
					(client setScript: patrol)
				else
					(gCurRoom newRoom: 425) ; minotaurArena
				)
			)
		)
	)
)

(instance jerkBush of Script
	(properties)

	(method (doit)
		(if (and (== gEgoGait 2) (>= [gEgoStats 8] 50)) ; sneaking, stealth
			(self dispose:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bush setCycle: End self)
			)
			(1
				(if (localproc_1)
					(minotaur setScript: minotaurLooks)
				)
				(= seconds 17)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance openGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gate ignoreActors: cycleSpeed: 3 setPri: 4 setCycle: End self)
			)
			(1
				(SetFlag 238)
				(gEgo illegalBits: -32768)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance closeGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gate
					ignoreActors: 1
					setCel: 3
					cycleSpeed: 3
					setCycle: Beg self
				)
			)
			(1
				(ClearFlag 238)
				(gEgo illegalBits: -28672)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance openMess of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= local9 1)
				(HighPrint 93 60) ; "You hear a snick as the hasp on the gate is opened."
				(lockSound number: (SoundFX 35) init: play:)
				(= local2 1)
				(= cycles 1)
			)
			(2
				(lockSound dispose:)
				(= seconds 3)
			)
			(3
				(= local9 0)
				(self dispose:)
			)
		)
	)
)

(instance patrol of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(minotaur moveSpeed: 1 cycleSpeed: 1 setCycle: 0)
				(if local6
					(self changeState: 5)
				else
					(= local9 0)
					(switch local3
						(0
							(self changeState: 10)
						)
						(1
							(self changeState: 14)
						)
						(2
							(if local4
								(self changeState: 17)
							else
								(self changeState: 13)
							)
						)
						(3
							(if local4
								(self changeState: 3)
							else
								(self changeState: 1)
							)
						)
					)
				)
			)
			(1
				(= local4 0)
				(= local3 1)
				(minotaur view: 425 setLoop: 3 setCel: 0)
				(= cycles 1)
			)
			(2
				(self changeState: 14)
			)
			(3
				(= local4 1)
				(= local3 0)
				(minotaur view: 425 setLoop: 3 setCel: 1)
				(= cycles 1)
			)
			(4
				(self changeState: 10)
			)
			(5
				(minotaur cycleSpeed: 4 setCycle: Beg self)
			)
			(6
				(= local6 0)
				(= local3 2)
				(self changeState: 0)
			)
			(10
				(= local4 1)
				(= local3 0)
				(minotaur
					view: 425
					setLoop: 0
					setCel: 0
					setCycle: Fwd
					setMotion: MoveTo 279 (minotaur y:) self
				)
			)
			(11
				(= local4 0)
				(minotaur setLoop: 2 setCel: 3)
				(= cycles 1)
			)
			(12
				(minotaur setLoop: 2 setCel: 2)
				(= cycles 1)
			)
			(13
				(= local3 1)
				(minotaur view: 425 setLoop: 2 setCel: 1)
				(= cycles 1)
			)
			(14
				(= local4 0)
				(= local3 1)
				(minotaur
					view: 425
					setLoop: 1
					setCel: 0
					setCycle: Fwd
					setMotion: MoveTo 60 (minotaur y:) self
				)
			)
			(15
				(= local4 1)
				(minotaur setLoop: 2 setCel: 1)
				(= cycles 1)
			)
			(16
				(minotaur setLoop: 2 setCel: 2)
				(= cycles 1)
			)
			(17
				(= local3 0)
				(minotaur view: 425 setLoop: 2 setCel: 3)
				(= cycles 1)
			)
			(18
				(self changeState: 10)
			)
		)
	)
)

(instance minotaurCalmed of Script
	(properties)

	(method (doit)
		(if (and (not (gEgo script:)) (not global104))
			(HandsOff)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local9 1)
				(HandsOff)
				(minotaur setCycle: 0 setMotion: 0)
			)
			(1
				(switch local3
					(0
						(self changeState: 3)
					)
					(1
						(self changeState: 8)
					)
					(2
						(self changeState: 10)
					)
					(3
						(self changeState: 2)
					)
				)
			)
			(2
				(minotaur setLoop: 0 setCel: 0)
				(= cycles 1)
			)
			(3
				(minotaur setLoop: 2 setCel: 3)
				(= cycles 1)
			)
			(4
				(minotaur setLoop: 2 setCel: 2)
				(= cycles 1)
			)
			(5
				(self changeState: 10)
			)
			(8
				(= local4 1)
				(minotaur setLoop: 2 setCel: 1)
				(= cycles 1)
			)
			(9
				(minotaur setLoop: 2 setCel: 2)
				(= cycles 1)
			)
			(10
				(minotaur setLoop: 4 setCel: 0 cycleSpeed: 8 setCycle: End self)
			)
			(11
				(client setScript: minotaurSleeps)
			)
		)
	)
)

(instance minotaurDazzled of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local9 1)
				(minotaur setCycle: 0 setMotion: 0)
			)
			(1
				(minotaur setLoop: 4 setCel: 1)
				(= cycles 5)
			)
			(2
				(minotaur setCel: 0)
				(= cycles 5)
			)
			(3
				(minotaur setCel: 1)
				(= cycles 2)
			)
			(4
				(minotaur setCel: 0)
				(= cycles 2)
			)
			(5
				(minotaur setCel: 1)
				(= local7 1)
				(HandsOn)
				(= seconds 12)
			)
			(6
				(= local7 0)
				(= local9 0)
				(client setScript: patrol)
			)
		)
	)
)

(instance minotaurSleeps of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (< (minotaur x:) 79)
					(minotaur
						setLoop: 0
						cycleSpeed: 1
						moveSpeed: 1
						setCycle: Walk
						setMotion: MoveTo 79 162 self
					)
				else
					(minotaur
						setLoop: 1
						cycleSpeed: 1
						moveSpeed: 1
						setCycle: Walk
						setMotion: MoveTo 79 162 self
					)
				)
			)
			(1
				(= local6 1)
				(minotaur
					view: 426
					setLoop: 0
					cel: 0
					cycleSpeed: 4
					illegalBits: 0
					setCycle: CT 3 1 self
				)
			)
			(2
				(= local9 0)
				(minotaur stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance minotaurDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(minotaur
					view: 426
					setLoop: 0
					cel: 0
					setMotion: 0
					cycleSpeed: 4
					illegalBits: 0
					setCycle: End self
				)
			)
			(1
				(minotaur stopUpd:)
				(self dispose:)
			)
		)
	)
)

