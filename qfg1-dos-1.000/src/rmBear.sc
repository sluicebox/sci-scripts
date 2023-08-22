;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 171)
(include sci.sh)
(use Main)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	rmBear 0
)

(local
	local0
	[local1 20]
	[local21 20]
	[local41 20] = [2 4 3 3 2 4 2 2 3 4 1 1 3 4 4 4 4 1 3 1]
	[local61 40] = [156 6 119 25 99 50 79 74 100 102 119 94 107 145 140 173 140 153 170 162 193 175 189 133 211 105 213 59 198 37 181 19 144 35 170 35 140 85 176 125]
	[local101 40]
	[local141 5]
	[local146 5]
	local151
)

(procedure (localproc_0)
	(for ((= local0 0)) (< local0 20) ((++ local0))
		(= [local1 local0] (Clone star))
		(= [local21 local0] (Clone starScriptOn))
		([local21 local0] register: [local41 local0])
		([local1 local0]
			cel: 0
			init:
			setPri: 15
			posn: [local61 (* local0 2)] [local61 (+ (* local0 2) 1)]
			setScript: [local21 local0]
		)
	)
)

(procedure (localproc_1)
	(for ((= local0 0)) (< local0 20) ((++ local0))
		(= [local1 local0] (Clone star))
		(= [local21 local0] (Clone starScriptOff))
		([local21 local0] register: [local41 local0])
		([local1 local0]
			cel: (- [local41 local0] 1)
			init:
			setPri: 15
			posn: [local61 (* local0 2)] [local61 (+ (* local0 2) 1)]
			setScript: [local21 local0]
		)
	)
)

(procedure (localproc_2)
	(for ((= local0 19)) (>= local0 0) ((-- local0))
		([local21 local0] dispose:)
		([local1 local0] dispose:)
	)
)

(procedure (localproc_3)
	(gCurRoom drawPic: 420)
	(bearRightPaw init: setPri: 6 stopUpd:)
	(bearLeftPaw init: setPri: 5 stopUpd:)
	(bearHead init: setPri: 4 setLoop: 0 cel: 0 stopUpd:)
)

(procedure (localproc_4)
	(gCurRoom drawPic: 420)
	(bearRightPaw init: setPri: 6 stopUpd:)
	(bearLeftPaw init: setPri: 5 stopUpd:)
	(bearHead init: setPri: 4 setLoop: 3 cel: 0 stopUpd:)
)

(procedure (localproc_5)
	(localproc_2)
	(bearHead dispose:)
	(bearRightPaw dispose:)
	(bearLeftPaw dispose:)
	(gCurRoom drawPic: 400 8)
)

(procedure (localproc_6)
	(baronet init: setPri: 4 stopUpd:)
	(baronHead init: setPri: 5 setLoop: 0 cel: 0 stopUpd:)
	(baronRightArm init: setPri: 7 setLoop: 6 cel: 0 stopUpd:)
	(baronLeftArm init: setPri: 6 setLoop: 5 cel: 0 stopUpd:)
)

(procedure (localproc_7)
	(baronet init: setPri: 4 stopUpd:)
	(baronHead init: setPri: 5 setLoop: 1 cel: 0 stopUpd:)
	(baronRightArm init: setPri: 7 setLoop: 6 cel: 0 stopUpd:)
	(baronLeftArm init: setPri: 6 setLoop: 5 cel: 0 stopUpd:)
)

(procedure (localproc_8)
	(baronet dispose:)
	(baronHead dispose:)
	(baronRightArm dispose:)
	(baronLeftArm dispose:)
	(gCurRoom drawPic: 14 3)
	(NormalEgo)
	(gEgo init: posn: 141 140)
	(drip init: setScript: dripScript)
	(= local151 (Random 0 4))
	(= [local141 0] 144)
	(= [local146 0] 184)
	(= [local141 1] 249)
	(= [local146 1] 221)
	(= [local141 2] 283)
	(= [local146 2] 219)
	(= [local141 3] 88)
	(= [local146 3] 201)
	(= [local141 4] 165)
	(= [local146 4] 168)
	(SetFlag 161)
	(if (IsFlag 169)
		(baronetSmall init: x: 239 y: 135 loop: 0)
	else
		(baronetSmall init: x: 239 y: 135 loop: 1)
	)
)

(instance bearChange of Sound
	(properties
		number 70
		priority 3
	)
)

(instance rmBear of Rm
	(properties
		picture 420
	)

	(method (dispose)
		(= global333 (= global332 0))
		(super dispose:)
	)

	(method (init)
		(Load rsPIC 400)
		(LoadMany rsVIEW 423 422 421 424)
		(SL enable:)
		(super init:)
		(HandsOff)
		(if (IsFlag 169)
			(localproc_3)
			(self setScript: bearDying)
			(= global332 0)
		else
			(localproc_4)
			(self setScript: bearFreed)
		)
	)

	(method (doit)
		(cond
			((== (gEgo edgeHit:) EDGE_RIGHT)
				(gCurRoom newRoom: 15)
			)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(gCurRoom newRoom: 13)
			)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp temp0)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look>')
						(cond
							((Said '/stalactite')
								(HighPrint 171 0) ; "They're like stalagmites, but they go the other way."
							)
							((Said '/stalagmite')
								(HighPrint 171 1) ; "They're like stalactites, but they go the other way."
							)
							((Said '[<at,around][/!*,cave,room]')
								(HighPrint 171 2) ; "The cavern contains some impressive formations and is rather beautiful, as caves go."
							)
							((Said '/wall,fungus,north,west,formation')
								(HighPrint 171 3) ; "The stalactites, stalagmites, and cave walls glow from a phosphorescent fungus growing there."
							)
							((or (Said '<up') (Said '/ceiling'))
								(HighPrint 171 4) ; "The stalactites grow slowly."
								(HighPrint 171 5) ; "...or are they stalagmites?"
							)
							((or (Said '<down') (Said '/floor'))
								(HighPrint 171 6) ; "The stalagmites grow slowly."
								(HighPrint 171 7) ; "...or are they stalactites?"
							)
							((Said '/south,entrance,open')
								(HighPrint 171 8) ; "The light from outside illuminates the cave opening."
							)
							((Said '/east')
								(HighPrint 171 9) ; "Beyond the bear, the cave seems to continue."
							)
							((Said '/bear,animal,creature,monster')
								(if (IsFlag 169)
									(HighPrint 171 10) ; "The bear is gone. All that is left is the body of a dead man."
								else
									(HighPrint 171 11) ; "The bear is gone."
								)
							)
							((Said '/man,barnard')
								(if (IsFlag 169)
									(HighPrint
										(Format @local101 171 12 global401) ; "He's dead, %s."
									)
								else
									(HighPrint 171 13) ; "The man is gone."
								)
							)
						)
					)
					((Said 'get>')
						(cond
							((Said '/fungus')
								(HighPrint 171 14) ; "The fungus is slimy and stuck tight to the cave walls."
							)
							((Said '/bear,stalactite,stalagmite')
								(HighPrint 171 15) ; "You're kidding, right?"
							)
						)
					)
					((Said 'cast>')
						(switch (= temp0 (SaidSpell event))
							(18
								(if (CastSpell temp0)
									(HighPrint 171 16) ; "There is no magic in the cavern."
								)
							)
							(else
								(event claimed: 0)
							)
						)
					)
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance bearDying of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bearHead cel: 1)
				(bearChange init: play:)
				(= cycles 3)
			)
			(1
				(SetCursor gTheCursor 0)
				(bearHead cycleSpeed: 1 setCycle: End)
				(= cycles 5)
			)
			(2
				(localproc_0)
				(= cycles 16)
			)
			(3
				(localproc_5)
				(localproc_1)
				(self cue:)
			)
			(4
				(localproc_6)
				(= cycles 4)
			)
			(5
				(baronLeftArm loop: 7 cel: 1 stopUpd:)
				(baronRightArm loop: 7 cel: 0 stopUpd:)
				(baronHead cycleSpeed: 1 setCycle: End)
				(= cycles 13)
			)
			(6
				(localproc_2)
				(localproc_8)
				(= cycles 11)
			)
			(7
				(baronetSmall cycleSpeed: 3 setCycle: End self)
			)
			(8
				(if (IsFlag 355)
					(HighPrint 171 17) ; "The body lying there looks a lot like the picture of the Baronet von Spielburg on the poster at the guild hall. You have a funny feeling that you may have made a slight tactical error."
				else
					(HighPrint 171 18) ; "You have a funny feeling that you may have made a slight tactical error."
				)
				(baronetSmall cel: 0 loop: 4 cycleSpeed: 1 setCycle: End self)
				(SetCursor gTheCursor 1)
				(HandsOn)
			)
			(9
				(ClearFlag 169)
				(baronetSmall dispose:)
			)
		)
	)
)

(instance bearFreed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bearChange init: play:)
				(= cycles 3)
			)
			(1
				(SetCursor gTheCursor 0)
				(localproc_0)
				(= cycles 20)
			)
			(2
				(localproc_5)
				(localproc_1)
				(self cue:)
			)
			(3
				(localproc_7)
				(= cycles 4)
			)
			(4
				(baronHead loop: 1 cel: 0 setCycle: End self)
			)
			(5
				(baronHead stopUpd:)
				(= cycles 4)
			)
			(6
				(baronLeftArm loop: 5 cel: 0 setCycle: Fwd)
				(= cycles 5)
			)
			(7
				(baronLeftArm stopUpd:)
				(baronHead setCycle: Beg self startUpd:)
			)
			(8
				(baronHead loop: 2 cel: 0 setCycle: End self)
			)
			(9
				(baronHead stopUpd:)
				(= cycles 4)
			)
			(10
				(baronRightArm loop: 6 cel: 0 setCycle: Fwd)
				(= cycles 5)
			)
			(11
				(baronRightArm stopUpd:)
				(= cycles 4)
			)
			(12
				(baronHead setCycle: Beg)
				(localproc_2)
				(= cycles 5)
			)
			(13
				(baronHead loop: 3 cel: 0 setCycle: End self)
				(= cycles 5)
			)
			(14
				(localproc_8)
				(= cycles 11)
			)
			(15
				(baronetSmall setCycle: End self)
			)
			(16
				(baronetSmall stopUpd:)
				(baronHeadSmall
					view: 421
					setLoop: 2
					init:
					x: 240
					y: 135
					z: 33
					cycleSpeed: 1
					setCycle: Fwd
				)
				(TimePrint 9 171 19) ; "You have the honor of meeting the Baronet Barnard von Spielburg. We are pleased that you broke our enchantment. Perhaps our father the Baron will reward you should you ever visit our castle."
				(= seconds 9)
			)
			(17
				(baronHeadSmall dispose:)
				(= cycles 3)
			)
			(18
				(baronetSmall loop: 3 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(19
				(baronetSmall dispose:)
				(SetCursor gTheCursor 1)
				(HighPrint 171 20) ; "The arrogance of the Baronet astonishes you. Perchance the kobold Magic User had a reason for changing him into a bear."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance starScriptOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (* register 3))
			)
			(1
				(client setCycle: End self)
			)
			(2
				(client loop: 1 cel: 0 setCycle: Fwd)
			)
		)
	)
)

(instance starScriptOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client loop: 1 cel: 0 setCycle: Fwd)
				(= cycles (* register 3))
			)
			(1
				(client loop: 0 cel: 5 setCycle: Beg)
			)
		)
	)
)

(instance dripScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(drip
					posn: [local141 local151] [local146 local151]
					setCycle: End
				)
				(= cycles (Random 20 40))
			)
			(1
				(= local151 (Random 0 4))
				(self changeState: 0)
			)
		)
	)
)

(instance bearHead of Prop
	(properties
		y 68
		x 156
		view 422
		priority 4
	)
)

(instance bearRightPaw of View
	(properties
		y 42
		x 115
		view 422
		loop 1
		priority 6
	)
)

(instance bearLeftPaw of View
	(properties
		y 39
		x 199
		view 422
		loop 2
		priority 5
	)
)

(instance baronet of View
	(properties
		y 199
		x 158
		view 423
		loop 4
		priority 4
	)
)

(instance baronHead of Prop
	(properties
		y 72
		x 156
		view 423
		priority 5
	)
)

(instance baronHeadSmall of Prop
	(properties
		y 140
		x 130
		z 25
		view 421
		loop 2
		priority 5
	)
)

(instance baronetSmall of Act
	(properties
		y 140
		x 130
		view 421
		priority 12
	)
)

(instance baronRightArm of Prop
	(properties
		y 60
		x 135
		view 423
		loop 6
		priority 7
	)
)

(instance baronLeftArm of Prop
	(properties
		y 61
		x 177
		view 423
		loop 5
		priority 6
	)
)

(instance star of Prop
	(properties
		y 95
		x 107
		view 424
		cel 1
		priority 12
	)
)

(instance drip of Prop
	(properties
		y 204
		x 79
		view 15
	)
)

