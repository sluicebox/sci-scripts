;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 171)
(include sci.sh)
(use Main)
(use n814)
(use Talker)
(use Polygon)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rmBear 0
	bernieTalker 1
)

(local
	local0
	[local1 9] = [28 63 83 102 235 295 195 39 251]
	[local10 9] = [93 85 79 79 86 99 98 103 90]
)

(instance rmBear of Rm
	(properties
		noun 1
		picture 425
	)

	(method (dispose)
		(= global280 (= global279 0))
		(super dispose:)
	)

	(method (init)
		(gGame setCursor: 996)
		(gTheIconBar disable:)
		(Load rsPIC 400)
		(LoadMany rsVIEW 422 421)
		(SL enable:)
		(super init:)
		(HandsOff)
		(= global279 0)
		(baronet init: setPri: 4 setLoop: 0 cel: 0 stopUpd:)
		(stunnedWarrior init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 88 293 94 244 94 94 121 41 107 43 119 81 124 55 133 19 130 0 135
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 110 189 184 157 177 178 221 181 250 166 231 162 209 174 198 161 319 109 319 189
					yourself:
				)
		)
		(self setScript: turnBearBack)
	)

	(method (doit)
		(cond
			((== (gEgo edgeHit:) 2)
				(gCurRoom newRoom: 15)
			)
			((== (gEgo edgeHit:) 3)
				(gCurRoom newRoom: 13)
			)
		)
		(super doit:)
	)
)

(instance baronet of Actor
	(properties
		x 203
		y 126
		view 423
		priority 4
	)

	(method (init)
		(super init:)
	)
)

(instance drip of Prop
	(properties
		view 14
	)
)

(instance stunnedWarrior of Prop
	(properties
		x 97
		y 136
		view 117
		cycleSpeed 12
	)
)

(instance bearChange of Sound
	(properties
		number 70
		priority 3
	)
)

(instance turnBearBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bearChange init: play:)
				(= ticks 30)
			)
			(1
				(stunnedWarrior setCycle: End)
				(baronet cel: 0 cycleSpeed: 12 setCycle: End self)
			)
			(2
				(= ticks 120)
			)
			(3
				(if (IsFlag 169)
					(gCurRoom setScript: bearDying)
				else
					(gCurRoom setScript: bearFreed)
				)
			)
		)
	)
)

(instance bearDying of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(stunnedWarrior dispose:)
				(baronet hide:)
				(= cycles 1)
			)
			(1
				(PalVary pvUNINIT)
				(gCurRoom drawPic: 14 7)
				(= cycles 1)
			)
			(2
				(NormalEgo)
				(gEgo init: posn: 107 150)
				(baronet
					view: 421
					x: 173
					y: 135
					setPri: 5
					setLoop: 0
					cel: 0
					cycleSpeed: 12
					show:
					setCycle: End self
				)
			)
			(3
				(drip init: setScript: dripScript)
				(SetFlag 161)
				(= cycles 11)
			)
			(4
				(if (IsFlag 355)
					(gMessager say: 1 0 4 1 self) ; "The body lying there looks a lot like the picture of the Baronet von Spielburg on the poster at the guild hall. You have a funny feeling that you may have made a slight tactical error."
				else
					(gMessager say: 1 0 3 1 self) ; "You have a funny feeling that you may have made a slight tactical error."
				)
			)
			(5
				(baronet cel: 0 loop: 4 cycleSpeed: 12 setCycle: CT 6 1 self)
			)
			(6
				(baronet dispose:)
				(ClearFlag 169)
				(gTheIconBar enable:)
				(gGame setCursor: gNormalCursor 220 180)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance bearFreed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(stunnedWarrior dispose:)
				(baronet hide:)
				(SetFlag 161)
				(self cue:)
			)
			(1
				(PalVary pvUNINIT)
				(gCurRoom drawPic: 14 7)
				(= cycles 1)
			)
			(2
				(NormalEgo)
				(gEgo init: posn: 107 150)
				(baronet
					view: 421
					setPri: 5
					setLoop: 1
					cel: 0
					x: 182
					y: 135
					show:
					stopUpd:
				)
				(drip init: setScript: dripScript)
				(= ticks 60)
			)
			(3
				(gMessager say: 1 0 2 1 self) ; "You have the honor of meeting the Baronet Barnard von Spielburg. We are pleased that you broke our enchantment. Perhaps our father the Baron will reward you should you ever visit our castle."
			)
			(4
				(baronet loop: 3 cel: 0 cycleSpeed: 12 setCycle: End self)
			)
			(5
				(gMessager say: 1 0 1 1 self) ; "The arrogance of the Baronet astonishes you. Perchance the kobold Magic User had a reason for changing him into a bear."
			)
			(6
				(baronet dispose:)
				(gGame setCursor: gNormalCursor 220 150)
				(gTheIconBar enable:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance dripScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= ticks (Random 1 200))
			)
			(1
				(= temp0 (Random 0 8))
				(client
					cel: 0
					posn: [local1 temp0] [local10 temp0]
					setCycle: End self
				)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance bernieTalker of Talker
	(properties
		x 10
		y 10
		view 1317
		talkWidth 260
		textX 15
		textY 110
	)

	(method (init)
		(= font gUserFont)
		(super init: bernieBust bernieEye bernieMouth &rest)
	)
)

(instance bernieBust of Prop
	(properties
		view 1317
	)
)

(instance bernieEye of Prop
	(properties
		nsTop 33
		nsLeft 47
		view 1317
		loop 2
	)
)

(instance bernieMouth of Prop
	(properties
		nsTop 53
		nsLeft 46
		view 1317
		loop 1
	)
)

