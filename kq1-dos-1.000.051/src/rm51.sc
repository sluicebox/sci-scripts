;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 51)
(include sci.sh)
(use Main)
(use Interface)
(use Blk)
(use ForwardCounter)
(use LoadMany)
(use Follow)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm51 0
)

(local
	local0
	local1
	local2
	[local3 10]
	[local13 10] = [102 126 100 184 43 195 34 173 33 31]
	[local23 10] = [113 87 53 67 78 102 95 129 122 67]
	[local33 20] = [10 8 12 10 8 3 12 11 10 14 14 14 14 14 14 14 14 14 3 3]
)

(procedure (localproc_0)
	(Print 51 66) ; "You can't do that while you are invisible."
)

(instance rockBlock of Blk
	(properties
		top 108
		left 34
		bottom 131
		right 105
	)
)

(instance rm51 of Rm
	(properties
		picture 51
		east 52
		west 50
		picAngle 60
	)

	(method (init)
		(self
			style:
				(switch gPrevRoomNum
					(west 3)
					(east 2)
				)
		)
		(LoadMany rsSOUND 37 66)
		(if (not (IsFlag 82))
			(LoadMany rsVIEW 22 146 145)
			(LoadMany rsSOUND 64 63)
			(if (gEgo has: 10) ; Leather_Slingshot
				(Load rsSCRIPT 784)
				(Load rsVIEW 41)
			)
			(if (and (IsFlag 9) (gEgo has: 8)) ; Empty_Water_Bucket
				(LoadMany rsVIEW 50 148)
				(Load rsSOUND 63)
			)
			(if (gEgo has: 0) ; Dagger
				(LoadMany rsVIEW 51 147)
				(LoadMany rsSOUND 65 18)
			)
		)
		(super init:)
		(SetScore 98 1)
		(switch gPrevRoomNum
			(east
				(gEgo posn: 315 140)
			)
			(west
				(gEgo posn: 13 130)
			)
			(else
				(gEgo posn: 13 130)
			)
		)
		(gEgo init:)
		(proc0_1)
		(if (not (IsFlag 84))
			(mirror setPri: 2 init: stopUpd:)
			(if (>= global101 1)
				(mirror setScript: flashMirror)
			)
		)
		(if (IsFlag 82)
			(gAddToPics add: rock eachElementDo: #init doit:)
			(gEgo observeBlocks: rockBlock)
			(if (not (IsFlag 84))
				(mirror posn: 134 90)
			)
		else
			(dragBod priority: 1 signal: (| (dragBod signal:) $4010) init:)
			(if (IsFlag 83)
				(dragHead view: 147 loop: 2 cel: 1 posn: 102 145 init:)
				(gAddToPics add: dragHead dragKneck eachElementDo: #init doit:)
			else
				(dragHead init: stopUpd:)
				(smoke init: setCycle: Fwd)
			)
			(rock x: 1 y: 134 init:)
			(gAddToPics doit:)
			(gEgo illegalBits: -16384)
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
				(if (== temp0 west)
					((ScriptID 0 23) loop: 1 fade:) ; backSound
				)
				(self newRoom: temp0)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'throw,use/water,bucket')
				(cond
					((IsFlag 1)
						(localproc_0)
					)
					((not (gEgo has: 8)) ; Empty_Water_Bucket
						(proc0_6) ; "You don't have anything that fits that description in your inventory."
					)
					((not (IsFlag 9))
						(Print 51 0) ; "The bucket doesn't have water in it."
					)
					((IsFlag 83)
						(Print 51 1) ; "The dragon is dead. His fire can no longer harm you."
					)
					((IsFlag 82)
						(Print 51 2) ; "You have already doused the dragon's fire. It has crept off in embarrassment!"
					)
					((gCurRoom script:)
						(PrintTooBusy)
					)
					((< (gEgo x:) 130)
						(Print 51 3) ; "Maybe you should try that from a different spot."
					)
					(else
						(gCurRoom setScript: throwWater)
					)
				)
			)
			((or (Said 'look,look/boulder,boulder') (MousedOn rock event 3))
				(Print 51 4) ; "This boulder is a huge chunk of granite."
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room,cave]')
						(cond
							((and (IsFlag 83) (IsFlag 84))
								(Print 51 5) ; "In this large underground cavern, there is one slimy green dead dragon, an opening on one side, and a very large boulder."
							)
							((IsFlag 83)
								(Print 51 6) ; "There is a dead dragon, a large boulder, and a seemingly ordinary mirror in the cave."
							)
							((and (IsFlag 82) (IsFlag 84))
								(Print 51 7) ; "The cavern is empty, save for a couple of openings on either side."
							)
							((IsFlag 82)
								(Print 51 8) ; "There is a large granite boulder in the cave, as well as a mirror...a MAGIC mirror!!"
							)
							((IsFlag 84)
								(Print 51 9) ; "In this large underground cavern, there is a ferocious fire-breathing dragon, an opening on one side, and a very large boulder."
							)
							(else
								(Print 51 10) ; "The ferocious fire-breathing dragon is protecting the magic mirror."
							)
						)
					)
					((Said '/stalactite,stalactite')
						(Print 51 11) ; "Parts of the cave are made impassable by huge, jagged stalagmites. The craggy limestone stalactites hang menacingly from the roof of the cavern. It took millenniums for these stalagmites and stalactites to form."
					)
					((Said '/doorway')
						(cond
							((and (< (gEgo x:) 160) (== (gEgo loop:) 1))
								(Print 51 12) ; "The hole seems to lead further into the cave."
							)
							((and (>= (gEgo x:) 160) (== (gEgo loop:) 0))
								(Print 51 13) ; "The faint images of reflected light issue from the entrance."
							)
							(else
								(Print 51 14) ; "There are two entrances to the cave."
							)
						)
					)
					((Said '/dragon')
						(if (IsFlag 83)
							(Print 51 15) ; "In this large cavern, there is a slimy dead dragon."
						else
							(Print 51 16) ; "The dragon has fled, never to return."
						)
					)
					((Said '/tongue')
						(cond
							((IsFlag 83)
								(Print 51 17) ; "The dragon's rough, red pointed tongue protrudes awkwardly from the dead dragon's maw."
							)
							((IsFlag 82)
								(Print 51 18) ; "The dragon's still got it."
							)
							(else
								(Print 51 19) ; "It would be easier if the dragon wasn't using it."
							)
						)
					)
				)
			)
			((Said 'get,get/mirror')
				(cond
					((IsFlag 84)
						(Print 51 20) ; "You've already accomplished that task."
					)
					((gCurRoom script:)
						(PrintTooBusy)
					)
					(
						(not
							(gEgo
								inRect:
									(- (mirror x:) 12)
									(- (mirror y:) 1)
									(+ (mirror x:) 12)
									(+ (mirror y:) 15)
							)
						)
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
					(else
						((ScriptID 0 21) number: 66 init: play:) ; gameSound
						(Print 51 21) ; "You take the Magic Mirror! Congratulations!"
						(gEgo get: 14) ; Magic_Mirror
						(SetScore 84 8)
						(mirror dispose:)
					)
				)
			)
			((Said 'get,get/tongue')
				(cond
					((IsFlag 83)
						(Print 51 22) ; "Dragon's Tongue is considered a delicacy in some parts of the world, but not in Daventry!"
					)
					((IsFlag 82)
						(Print 51 23) ; "The dragon took it with him."
					)
					(else
						(Print 51 19) ; "It would be easier if the dragon wasn't using it."
					)
				)
			)
			((Said 'move,pull/boulder,boulder')
				(Print 51 24) ; "This boulder is far too heavy to move."
			)
			((Said '/ring>')
				(cond
					((or (Said 'remove') (Said 'get<off'))
						(cond
							((== (gEgo view:) (if (IsFlag 0) 23 else 16))
								(PrintTooBusy)
							)
							((not (IsFlag 17))
								(Print 51 25) ; "You aren't wearing the ring, Sir Graham."
							)
							(else
								(Print 51 26) ; "You remove the shimmering ring from your finger."
								(if (and (== gCurRoomNum 51) (< (gEgo x:) 130))
									(Print 51 27) ; "As you slowly and silently return to visibility, the dragon fails to notice you."
								)
								(if
									(and
										(gCast contains: gGoat)
										(gEgo has: 2) ; Carrot
									)
									(gGoat setMotion: Follow gEgo 60)
									(SetFlag 2)
								)
								(ClearFlag 17)
								(ClearFlag 1)
								(if (== (gEgo illegalBits:) -16384)
									(proc0_1)
									(gEgo illegalBits: -16384)
								else
									(proc0_1)
								)
								(event claimed: 1)
							)
						)
					)
					((Said 'rub')
						(cond
							((IsFlag 1)
								(Print 51 28) ; "You are already invisible"
							)
							((not global134)
								(Print 51 29) ; "Nothing happens."
							)
							((IsFlag 17)
								(Print 51 30) ; "As you rub the shimmering ring, you turn invisible!"
								(SetFlag 1)
								(if (== (gEgo illegalBits:) -16384)
									(proc0_1)
									(gEgo illegalBits: -16384)
								else
									(proc0_1)
								)
							)
							(else
								(Print 51 31) ; "The magic ring is still in your pocket. You can't rub it there."
								(event claimed: 1)
							)
						)
					)
				)
			)
			((Said 'give/[/dragon]')
				(cond
					((IsFlag 82)
						(Print 51 32) ; "There is no one here to receive your offering."
					)
					((IsFlag 83)
						(Print 51 33) ; "The dead dragon does not need anything you have to offer."
					)
					((gEgo has: 14) ; Magic_Mirror
						(Print 51 34) ; "The dragon, unaware that you've stolen his great treasure, is not interested in anything you have to offer."
					)
					(else
						(Print 51 35) ; "The dragon isn't interested in any of your possessions. It's already got one of the most valuable treasures in Daventry."
					)
				)
			)
			(
				(and
					(== (event type:) evMOUSEBUTTON)
					(& (event modifiers:) emSHIFT)
					(== (OnControl PRIORITY (event x:) (event y:)) -32768)
				)
				(if (> (event y:) 115)
					(Print 51 36) ; "Parts of the cave are made impassable by huge, jagged stalagmites."
				else
					(Print 51 37) ; "The craggy limestone stalactites hang menacingly from the roof of the cavern."
				)
			)
		)
	)
)

(instance smoke of Prop
	(properties
		x 126
		y 135
		view 146
		loop 1
		cycleSpeed 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 51 38) ; "Smoking is bad for your health. That's why there are not many dragons around."
			)
		)
	)
)

(instance fireHead of Prop
	(properties
		view 145
		loop 1
		cycleSpeed 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 51 39) ; "The dragon's head is angular, like a pterodactyl's. Large webbed gill flaps protrude from either side of his face, just underneath his horns. Smoke curls lazily from his nostrils."
			)
		)
	)
)

(instance dragBod of PicView
	(properties
		x 117
		y 126
		description {dragon}
		view 251
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 51 40) ; "Green and scaly, the dragon's body is massive and muscular. A row of serrated armor stretches from the tip of his tail to the base of his neck; his leathery wings are folded tight against his sides, and his webbed claws look sharp and deadly."
			)
		)
	)

	(method (dispose)
		(gFeatures delete: self)
		(super dispose: &rest)
	)
)

(instance dragTail of Actor
	(properties
		x 51
		y 131
		description {dragon}
		yStep 1
		view 146
		signal 22529
		illegalBits 0
		xStep 6
		moveSpeed 1
	)
)

(instance fireBall of Actor
	(properties
		description {fire ball}
		yStep 6
		view 146
		xStep 8
	)
)

(instance projectile of Actor
	(properties
		description {dagger}
		yStep 8
		view 51
		loop 2
		xStep 10
	)
)

(instance puff of Prop
	(properties
		description {steam}
		view 251
		loop 1
	)
)

(instance rock of PicView
	(properties
		x 69
		y 127
		view 251
	)

	(method (handleEvent))

	(method (dispose)
		(gFeatures delete: self)
		(super dispose: &rest)
	)
)

(instance mirror of Prop
	(properties
		x 149
		y 104
		view 251
		loop 2
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((Said 'look,look<in/mirror')
				(if (< (gEgo distanceTo: self) 10)
					(proc0_15 gEgo mirror)
					(event claimed: 0)
				else
					(Print 51 41) ; "You should get closer to the mirror."
				)
			)
			((or (Said 'look,look/mirror') (MousedOn self event 3))
				(Print 51 42) ; "The mirror shimmers with its own magical light."
				(event claimed: 1)
			)
			((super handleEvent: event)
				(return)
			)
		)
	)
)

(instance dragKneck of View
	(properties
		x 41
		y 90
		view 147
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 51 43) ; "The dragon's long, powerful neck is a slinky mass of sinew and scales. The underside of his throat is pale, fleshy and unprotected by scales."
			)
		)
	)
)

(instance dragHead of Prop
	(properties
		x 41
		y 90
		description {dragon's head}
		view 145
		signal 1
		cycleSpeed 1
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(
				(or
					script
					(IsFlag 83)
					(IsFlag 82)
					(== (gCurRoom script:) daggerDrag)
				)
				0
			)
			(
				(and
					(> (gEgo x:) 266)
					(== (dragHead cel:) (- (NumCels dragHead) 1))
					(not (IsFlag 1))
				)
				(self setScript: lowerHead)
			)
			(
				(and
					(< (gEgo x:) 266)
					(<= (dragHead cel:) 1)
					(not (IsFlag 1))
				)
				(if (not local1)
					(= local1 1)
					(smoke hide:)
				)
				(self setScript: raiseHead)
			)
			((and (< 130 (gEgo x:) 208) (not (IsFlag 1)) (not local0))
				(if (!= (gCurRoom script:) daggerDrag)
					(self setScript: flameEgo)
				)
			)
			((and local0 (> (gEgo x:) 208))
				(= local0 0)
			)
			((not global124)
				(= local0 0)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(
				(or
					(Said 'look,look/dragon')
					(Said 'look,look/head[<dragon]')
					(Said 'look,look/body[<dragon]')
					(MousedOn self event 3)
					(MousedOn dragBod event 3)
				)
				(cond
					((IsFlag 83)
						(Print 51 44) ; "The dragon lies motionless on the rocky floor of the cavern."
					)
					((and (IsFlag 82) (IsFlag 84))
						(Print 51 7) ; "The cavern is empty, save for a couple of openings on either side."
					)
					((IsFlag 82)
						(Print 51 8) ; "There is a large granite boulder in the cave, as well as a mirror...a MAGIC mirror!!"
					)
					((IsFlag 84)
						(if (<= (dragHead cel:) 1)
							(Print 51 45) ; "The ferocious fire-breathing dragon may look asleep, but don't be fooled....he's smarter than he looks."
						else
							(Print 51 46) ; "There is a vicious fire-breathing dragon here!"
						)
					)
					(else
						(Print 51 40) ; "Green and scaly, the dragon's body is massive and muscular. A row of serrated armor stretches from the tip of his tail to the base of his neck; his leathery wings are folded tight against his sides, and his webbed claws look sharp and deadly."
						(Print 51 10) ; "The ferocious fire-breathing dragon is protecting the magic mirror."
					)
				)
				(event claimed: 1)
			)
			((Said 'play/fiddle')
				(if (gEgo has: 17) ; Fiddle
					(Print 51 47) ; "Ordinarily, music hath charms to soothe a savage beast but this beast is a little too ferocious to appreciate fiddle music."
				else
					(event claimed: 0)
				)
			)
			((or (Said 'throw,use/dagger') (Said 'kill,stab/dragon'))
				(cond
					((IsFlag 1)
						(localproc_0)
					)
					((IsFlag 83)
						(Print 51 48) ; "This dragon had only one life, and you have already taken it."
					)
					((not (gEgo has: 0)) ; Dagger
						(Print 51 49) ; "You don't have anything sharp enough to pierce the dragon's scaly hide!"
					)
					((gCurRoom script:)
						(PrintTooBusy)
					)
					((not (dragHead script:))
						(if (< (gEgo x:) 130)
							(Print 51 3) ; "Maybe you should try that from a different spot."
						else
							(gCurRoom setScript: daggerDrag)
						)
					)
					(else
						(Print 51 50) ; "Wait and see what the dragon is doing first."
						(gEgo setMotion: 0)
						(gCurRoom setScript: 0)
					)
				)
			)
			((Said 'shoot/dragon')
				(cond
					((or (not (gEgo has: 10)) (not (gEgo has: 9))) ; Leather_Slingshot, Pebbles
						(Print 51 51) ; "You don't have everything you need to attempt such a feat."
					)
					((gCurRoom script:)
						(PrintTooBusy)
					)
					((IsFlag 1)
						(localproc_0)
					)
					((IsFlag 83)
						(Print 51 52) ; "The dragon's already dead. Shooting him would be a waste of pebbles."
					)
					(else
						(Print 51 53) ; "The pebbles are too blunt to deliver a fatal blow to the dragon, maybe a different approach would be better."
					)
				)
			)
			((or (Said 'talk,talk[/dragon]') (Said '/hello') (Said 'hello,say'))
				(if (IsFlag 83)
					(Print 51 54) ; "The dragon is dead. He can no longer hear you."
				else
					(Print 51 55) ; "Think again. When this dragon talks, things have a tendency to catch fire."
				)
			)
			((Said 'get,get/dagger')
				(if (IsFlag 83)
					(Print 51 56) ; "The mere thought of retrieving the dagger repulses you."
				else
					(Print 51 57) ; "How?"
				)
			)
			((Said '/dragon')
				(if (IsFlag 83)
					(Print 51 58) ; "The dragon is dead. He has ceased to be. Bereft of life, he rests in peace. Best to get on with the game and forget this sad creature."
				else
					(Print 51 59) ; "Be careful. Dragons are very dangerous."
				)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance flameEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(smoke hide: stopUpd:)
				(gEgo stopUpd:)
				(dragHead stopUpd:)
				(if (== (dragHead cel:) (- (NumCels dragHead) 1))
					(fireHead posn: 97 111)
				else
					(fireHead posn: 104 149)
				)
				(fireHead
					init:
					ignoreActors:
					cycleSpeed: 2
					cel: 0
					setPri: 12
					setCycle: End self
				)
				(mirror cel: 0 setScript: 0 stopUpd:)
			)
			(1
				(fireHead dispose:)
				(fireBall
					init:
					setLoop: (if (< (gEgo y:) 142) 3 else 2)
					ignoreActors:
					ignoreHorizon:
					setPri: 4
					illegalBits: 0
					setCycle: Fwd
				)
				(if (== (dragHead cel:) (- (NumCels dragHead) 1))
					(fireBall posn: 126 102)
				else
					(fireBall posn: 136 144)
				)
				(fireBall
					setMotion:
						MoveTo
						(- (gEgo x:) 12)
						(- (gEgo y:) 20)
						self
				)
			)
			(2
				(if (not global124)
					((ScriptID 0 21) number: 37 init: play:) ; gameSound
					(gEgo
						setLoop: 2
						cel: 0
						view: 22
						cycleSpeed: 1
						setCycle: Fwd
					)
					(fireBall dispose:)
					(= cycles 22)
				else
					(fireBall dispose:)
					(self changeState: 6)
				)
			)
			(3
				(gEgo setLoop: 0 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(4
				(gEgo setLoop: 1 cel: 0 setCycle: Fwd)
				(= seconds 6)
			)
			(5
				(if (gEgo has: 16) ; Magic_Shield
					(EgoDead
						{Your shield melted from the intensity of the dragon's flames!  Looks like the dragon made an ash out of you.}
					)
				else
					(EgoDead
						{By venturing too close to the dragon's flame, you made an ash out of yourself.}
					)
				)
				(self changeState: 7)
			)
			(6
				(Print 51 60) ; "The Fairy Godmother's protective spell has saved you from a fiery fate."
				(= local0 1)
				(HandsOn)
				(self cue:)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance raiseHead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dragHead setCycle: End self)
				(smoke hide: stopUpd:)
			)
			(1
				(dragHead stopUpd:)
				(smoke posn: 119 98 show: startUpd:)
				(self dispose:)
			)
		)
	)
)

(instance lowerHead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dragHead setCycle: CT 1 -1 self)
				(smoke hide: stopUpd:)
			)
			(1
				(dragHead stopUpd:)
				(smoke posn: 126 135 show: startUpd:)
				(self dispose:)
			)
		)
	)
)

(instance daggerDrag of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo put: 0) ; Dagger
				(if (<= (dragHead cel:) 1)
					(dragHead setCycle: End self)
					(smoke hide: stopUpd:)
				else
					(= cycles 1)
				)
			)
			(1
				(dragHead stopUpd:)
				(gEgo
					view: 51
					cel: 0
					loop: (if (< (gEgo x:) 130) 0 else 1)
					setCycle: CT 6 1 self
				)
			)
			(2
				((ScriptID 0 21) number: 65 loop: 1 init: play:) ; gameSound
				(gEgo setCycle: End)
				(projectile
					init:
					setLoop: 2
					cel: 2
					setCycle: Fwd
					illegalBits: 0
					ignoreActors:
				)
				(if (gEgo loop:)
					(projectile
						posn: (- (gEgo x:) 19) (- (gEgo y:) 41)
						setMotion:
							MoveTo
							(+ (dragHead x:) 40)
							(+ (dragHead y:) 23)
							self
					)
				else
					(projectile
						posn: (+ (gEgo x:) 20) (- (gEgo y:) 36)
						setMotion: MoveTo 330 118 self
					)
				)
			)
			(3
				(gEgo stopUpd:)
				(projectile dispose:)
				(if (gEgo loop:)
					(SetScore 83 3)
					(smoke hide:)
					((ScriptID 0 21) number: 18 loop: 1 play:) ; gameSound
					(dragHead
						view: 147
						cel: 0
						loop: 0
						cycleSpeed: (if (>= global101 1) 2 else 0)
						setCycle: ForwardCounter 2 self
					)
				else
					(Print 51 61) ; "The dagger flies through the air and is lost in the cave's darkness."
					(= local1 1)
					(smoke hide:)
					(proc0_1)
					(gEgo illegalBits: -16384)
					(HandsOn)
					(self dispose:)
				)
			)
			(4
				(dragHead setCycle: Beg)
				(= cycles 4)
			)
			(5
				((ScriptID 0 21) number: 59 init: play:) ; gameSound
				(dragHead loop: 2 cel: 1 posn: 102 145)
				(dragKneck init: stopUpd:)
				(smoke view: 147 loop: 1 setCel: 0 posn: 41 90 show:)
				(= cycles 3)
			)
			(6
				(dragHead posn: 102 144)
				(smoke cel: 1)
				(= cycles 3)
			)
			(7
				(dragHead posn: 102 145)
				(smoke cycleSpeed: 3 setCycle: End)
				(= cycles 3)
			)
			(8
				(ShakeScreen 3 ssUPDOWN)
				(= cycles 1)
			)
			(9
				(dragHead stopUpd:)
				(smoke hide: stopUpd:)
				(= cycles 2)
			)
			(10
				(HandsOn)
				(Print 51 62) ; "With unerring aim, the dagger streaks through the air and pierces the soft, unprotected skin under the dragon's throat. The dragon convulses for a moment, and then crashes, lifeless, to the hard cavern floor."
				(proc0_1)
				(gEgo illegalBits: -16384)
				(self dispose:)
			)
		)
	)
)

(instance throwWater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetScore 82 5)
				(UpdateWaterBucket 0)
				(gEgo stopUpd:)
				(if (<= (dragHead cel:) 1)
					(dragHead setCycle: End)
					(smoke hide: stopUpd:)
				)
				(mirror cel: 0 setScript: 0 stopUpd:)
				(gEgo view: 50 cel: 0 loop: 0 setMotion: 0 setCycle: End)
				(= cycles 4)
			)
			(1
				(projectile
					init:
					view: 50
					setLoop: 2
					setCel: 0
					setCycle: 0
					illegalBits: 0
					setPri: (gEgo priority:)
					ignoreActors:
					xStep: (if (>= global101 1) 10 else 15)
					posn: (- (gEgo x:) 30) (- (gEgo y:) 25)
					setMotion: MoveTo 108 103 self
				)
			)
			(2
				(gEgo stopUpd:)
				(projectile dispose:)
				(smoke dispose:)
				((ScriptID 0 21) number: 63 init: play:) ; gameSound
				(dragHead view: 148 loop: 0 cel: 0 setCycle: Fwd)
				(= cycles 6)
			)
			(3
				(Print 51 63) ; "Good shot! The water hits the dragon square in the face, dousing the dragon's fire."
				(self cue:)
			)
			(4
				((= [local3 local2] (Clone puff))
					init:
					setPri: [local33 local2]
					x: [local13 local2]
					y: [local23 local2]
				)
				(if global101
					([local3 local2] setCycle: End self)
				else
					([local3 local2] setCel: (puff lastCel:))
					(= cycles 1)
				)
			)
			(5
				(= cycles (+ 1 (* global101 5)))
			)
			(6
				([local3 local2] addToPic:)
				(switch local2
					(9
						(mirror posn: 134 90)
						(= cycles 10)
					)
					(2
						(dragHead stopUpd:)
						(++ local2)
						(self changeState: 4)
					)
					(else
						(++ local2)
						(self changeState: 4)
					)
				)
			)
			(7
				(gCurRoom drawPic: 51 8)
				(rock x: 69 y: 127 init:)
				(gAddToPics doit:)
				(gEgo observeBlocks: rockBlock)
				(dragHead dispose:)
				((ScriptID 0 23) loop: 1 fade:) ; backSound
				(dragTail init: setMotion: MoveTo -45 131 self)
			)
			(8
				(if (not (gEgo has: 14)) ; Magic_Mirror
					(Print 51 64) ; "Unable to defend itself with anything more than harmless clouds of steam, the dragon rolls aside the granite boulder and slinks off in shame, leaving the mirror behind."
				else
					(Print 51 65) ; "Unable to defend itself with anything more than harmless clouds of steam, the dragon rolls aside the granite boulder and slinks off in shame."
				)
				(proc0_1)
				(gEgo observeBlocks: rockBlock loop: 1)
				(if (and (not (gEgo has: 14)) (>= global101 1)) ; Magic_Mirror
					(mirror setScript: flashMirror)
				)
				(dragTail dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance flashMirror of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mirror setCycle: End self)
			)
			(1
				(mirror stopUpd:)
				(= cycles (Random 40 60))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

