;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 630)
(include sci.sh)
(use Main)
(use GloryWindow)
(use Teller)
(use n026)
(use OccasionalCycle)
(use GloryControls)
(use JumpX)
(use IconBar)
(use Feature)
(use LoadMany)
(use DPath)
(use Rev)
(use GameControls)
(use Window)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm630 0
)

(local
	local0
	[local1 5]
	[local6 5]
	local11
	local12 = 1
	local13 = 1
	local14
	local15
	local16
	[local17 2]
	local19 = 7
	local20 = 160
	local21 = 3
	local22 = 1
	local23
	local24 = -4
	local25
	local26 = 10
	local27 = 12
	local28
	[local29 5] = [0 20 21 24 999]
	[local34 3]
	[local37 6] = [0 -2 15 1 16 999]
	[local43 4] = [0 17 6 999]
	[local47 6]
	[local53 3] = [0 -2 999]
)

(procedure (localproc_0)
	(bridgeControls disable: iconJump iconDrop iconL iconR)
	(iconJump show:)
	(iconDrop show:)
	(iconL show:)
	(iconR show:)
)

(procedure (localproc_1)
	(bridgeControls
		enable: iconJump iconDrop (if (== gPrevRoomNum 640) iconR else iconL)
	)
	(iconJump show:)
	(iconDrop show:)
	(iconR show:)
	(iconL show:)
)

(procedure (localproc_2 &tmp temp0)
	(= temp0 0)
	(if (> (Random 1 11) local26)
		(cond
			((== gPrevRoomNum 640)
				(if (> (gEgo x:) 215)
					(= local26 local27)
					(= temp0 1)
				)
			)
			((< (gEgo x:) 258)
				(= local26 local27)
				(= temp0 1)
			)
		)
	else
		(-- local26)
	)
	(return temp0)
)

(procedure (localproc_3 param1) ; UNUSED
	(switch (leopard loop:)
		(2
			(leopard cel: 2)
		)
		(3
			(leopard cel: 0)
		)
		(else
			(param1 cue:)
			(return)
		)
	)
	(leopard setLoop: 5 setCycle: End param1)
)

(procedure (localproc_4 &tmp temp0)
	(= temp0 gTheCursor)
	(Message msgGET 630 2 6 3 2 @local1) ; "Yes"
	(Message msgGET 630 2 6 3 3 @local6) ; "No"
	(quest init: show: dispose:)
	(gGame setCursor: temp0)
	(return local0)
)

(class JumpOver of JumpX
	(properties)

	(method (chkTarget)
		(leopard setPri: 15)
	)
)

(class Attack of JumpOver
	(properties)

	(method (chkTarget &tmp temp0)
		(= temp0 0)
		(super chkTarget:)
		(cond
			((== (gEgo view:) 29)
				(if (< (gEgo cel:) 3)
					(= temp0 1)
				else
					(return)
				)
			)
			((== (gEgo view:) 30)
				(if (or (< (gEgo cel:) 1) (> (gEgo cel:) 5))
					(= temp0 1)
				else
					(return)
				)
			)
			(else
				(= temp0 1)
			)
		)
		(if temp0
			(leopardAttack register: 1)
			(gEgo setScript: 0)
			(gCurRoom setScript: egoFell 0 0)
		)
	)
)

(class DDCPath of DPath
	(properties
		cDir 1
		nPoints 0
		comp 0
	)

	(method (init)
		(if (not nPoints)
			(self nPoints: (- argc 2))
		)
		(super init: &rest)
	)

	(method (setTarget)
		(if (self cDir:)
			(= x (points at: value))
			(= y (points at: (++ value)))
			(++ value)
		else
			(= y (points at: value))
			(= x (points at: (-- value)))
			(-- value)
		)
	)

	(method (moveDone)
		(cond
			((self comp:)
				(self comp: 0)
				(if (self cDir: (Random 0 1))
					(self value: 0)
				else
					(self value: (self nPoints:))
				)
			)
			((== (self value:) -1)
				(if (self cDir: (Random 0 1))
					(self value: 0)
				else
					(self value: (self nPoints:))
				)
				(self init:)
			)
			((== (points at: value) -32768)
				(self value: 0)
				(self comp: 1)
				(self init:)
			)
			(else
				(self init:)
			)
		)
	)
)

(class Backward of Rev
	(properties)

	(method (doit)
		(if (not (client isStopped:))
			(super doit:)
		)
	)
)

(class xDPath of DDCPath
	(properties)

	(method (setTarget &tmp temp0 temp1 [temp2 30])
		(= temp0 x)
		(= temp1 y)
		(super setTarget:)
		(client loop: 4)
		(switch (GetAngle temp0 temp1 x y)
			(46
				(client cel: 0)
			)
			(65
				(client cel: 3)
			)
			(112
				(client cel: 2)
			)
			(134
				(client cel: 0)
			)
			(226
				(client cel: 2)
			)
			(245
				(client cel: 1)
			)
			(292
				(client cel: 1)
			)
			(314
				(client cel: 3)
			)
		)
		(Wait 0)
		(Wait 5)
		(Animate (gCast elements:) 0)
		(Wait 5)
	)
)

(instance rm630 of Rm
	(properties
		noun 4
		picture 630
		vanishingY -420
	)

	(method (init)
		(HandsOff)
		(LoadMany rsVIEW 8 2 11 632 29 30)
		((ScriptID 36 0) x: 5 y: 2 textX: 20 textY: 150) ; johariTalker
		(= [local34 0] @local29)
		(= [local47 0] @local37)
		(= [local47 1] @local43)
		(leopard init: setScale: 170)
		(skull init:)
		(doorway init:)
		(treehouse init:)
		(tree init:)
		(gLongSong number: 630 setLoop: -1 play: 127)
		(if (== gPrevRoomNum 640)
			(gEgo
				x: 121
				y: 89
				z: 30
				setScale: 420
				origStep: 16386
				init:
				get: 6 ; theGrapnel
				changeGait: 2 0 ; sneaking
			)
			(leopardLady setScale: 420 init:)
			(rope cel: 3 cycleSpeed: 3 init:)
			(super init: &rest)
			(= local22 0)
			(= local24 4)
			(leopard show:)
			(self setScript: backFence)
		else
			(gEgo
				view: 4
				loop: 3
				cel: 4
				x: 301
				y: 101
				z: 30
				noun: 5
				setPri: 2
				setScale: 420
				init:
				hide:
			)
			(leopardLady setScale: 420 init: hide:)
			(theHut init:)
			(egoTell init: gEgo @local29 @local34)
			(johariTell init: leopardLady @local37 @local47 @local53)
			(gWalkHandler addToFront: self)
			(super init: &rest)
			(ClearFlag 66)
			(self setScript: enterFence)
		)
		(gGame save: 1)
		(HandsOff)
	)

	(method (dispose)
		(gEgo z: 0)
		(gWalkHandler delete: self)
		(UnLoad 128 8)
		(UnLoad 128 2)
		(UnLoad 128 11)
		(UnLoad 128 632)
		(UnLoad 128 29)
		(UnLoad 128 30)
		(LoadMany 0 36 964 57)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(!= gPrevRoomNum 640)
				(> (gEgo x:) 280)
				(gEgo mover:)
				(not script)
			)
			(if local16
				(HandsOff)
				(self setScript: getCross)
			else
				(self setScript: promptUser)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(if local16
					(HandsOff)
					(self setScript: getCross)
				else
					(self setScript: promptUser)
				)
			)
			(80 ; calmSpell
				(SetFlag 66)
				(super doVerb: 80)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance promptUser of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 0)
				(if (localproc_4)
					(= register 1)
					(gMessager say: 1 6 14) ; "If you want to get some more practice before you get killed, go ahead. I'll wait around here for you to get back."
				)
				(gEgo x: 302 setMotion: 0)
				(= cycles 5)
			)
			(1
				(if register
					(gCurRoom newRoom: 170)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance throwFood of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 9
					y: (- (gEgo y:) 3)
					setLoop: 1
					setCycle: End self
				)
			)
			(1
				(gEgo y: (+ (gEgo y:) 3) normalize: z: 30)
				(= cycles 5)
			)
			(2
				(gMessager say: 2 6 8 0 self) ; "You throw some food to the hungry leopard."
			)
			(3
				(leopard
					moveSpeed: 3
					cycleSpeed: 3
					setMotion: MoveTo 197 142 self
				)
			)
			(4
				(leopard view: 632)
				(if (== (leopard loop:) 3)
					(leopard setLoop: 3)
				else
					(leopard setLoop: 2)
				)
				(leopard
					cycleSpeed: 10
					setCycle: OccasionalCycle self 1 10 60
					setMotion: 0
				)
				(= cycles 1)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance ropeThrow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 8
					x: 305
					y: 99
					drop: 6 ; theGrapnel
					setLoop: 1
					setCel: 0
					setCycle: CT 5 1 self
				)
			)
			(1
				(gEgo setCycle: CT 6 1)
				(rope init: cycleSpeed: 3 setCycle: End self)
			)
			(2
				(rope stopUpd:)
				(gEgo view: 0 x: 305 y: 103 z: 30 setScale:)
				(= local16 1)
				(if (IsFlag 66)
					(gCurRoom setScript: getCross)
				else
					(self setScript: leopardApproach self)
				)
			)
			(3
				(leopard
					view: 632
					cycleSpeed: 6
					setLoop: 1
					setPri: 1
					setCycle: End self
				)
			)
			(4
				(leopard
					view: 632
					setLoop: 0
					y: 116
					moveSpeed: 4
					cycleSpeed: 4
					setCycle: JumpCycler 3 6
					setMotion: JumpOver 265 140 50 self
				)
			)
			(5
				(HandsOn)
				(leopard
					view: 631
					y: 156
					moveSpeed: 6
					cycleSpeed: 6
					setLoop: -1
					setPri: -1
					setCycle: Walk
					setMotion: xDPath 259 182 281 161 240 121 179 149
				)
				(self dispose:)
			)
		)
	)
)

(instance getCross of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 12
					x: 295
					setPri: 15
					origStep: 257
					setLoop: 1
					setCel: 0
					setCycle: Walk
					setMotion: MoveTo (+ (gEgo x:) local24) (gEgo y:) self
				)
			)
			(1
				(cond
					((and (== global209 1) (IsFlag 66))
						(if (== (gEgo trySkill: 2 175) -1) ; agility
							(= local21 2)
							(LoadMany rsVIEW 2 11)
							(leopard setScript: leopardApproach 0 1)
							(gCurRoom setScript: unbalance 0 0)
						else
							(gCurRoom setScript: ropeCrossing 0 1)
						)
					)
					((or (== global209 2) (== global209 3))
						(gCurRoom setScript: mediumCross)
					)
					(else
						(LoadMany rsVIEW 2 11 6)
						(leopard setScript: leopardApproach 0 1)
						(gCurRoom setScript: unbalance 0 1)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance mediumCross of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== global209 3)
					(= local20 180)
				)
				(cond
					((== gPrevRoomNum 640)
						(gEgo code: backCheck)
					)
					((== (gEgo trySkill: 2 175) -1) ; agility
						(gEgo code: stepCheck)
					)
					(else
						(gEgo code: crossCheck)
					)
				)
				(if (not (IsFlag 66))
					(self setScript: leopardApproach self 0)
				else
					(= cycles 1)
				)
			)
			(1
				(bridgeControls init: show: dispose:)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance ropeCrossing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(gEgo setMotion: MoveTo 150 103 self)
				else
					(gEgo code: 0)
					(= cycles 1)
				)
			)
			(1
				(gEgo
					view: 2
					setLoop: -1
					setPri: -1
					yStep: 1
					xStep: 2
					setCycle: Walk
					setMotion: DPath 121 98 121 97 self
				)
			)
			(2
				(gMessager say: 1 6 7 0 self) ; "Good luck."
			)
			(3
				(gCurRoom newRoom: 640)
			)
		)
	)
)

(instance leopardApproach of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(leopard
					view: 631
					cycleSpeed: 2
					moveSpeed: 2
					setCycle: Walk
					setLoop: -1
				)
				(cond
					((== gPrevRoomNum 640)
						(if (> (leopardAttack state:) 0)
							(leopard setMotion: MoveTo 200 100 self)
						else
							(leopard setMotion: MoveTo 175 103 self)
						)
					)
					((> (leopardAttack state:) 0)
						(leopard setMotion: MoveTo 220 132 self)
					)
					(else
						(leopard setMotion: MoveTo 225 132 self)
					)
				)
			)
			(1
				(leopard setLoop: 0)
				(unbalance cue:)
				(= cycles 3)
			)
			(2
				(if local28
					(localproc_1)
				)
				(if register
					(client setScript: leopardStart)
				)
				(self dispose:)
			)
		)
	)
)

(instance leopardStart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(leopard view: 632 setLoop: 1 setCycle: CT 3 1 self)
			)
			(1 0)
			(2
				(leopard setCycle: CT 5 1 self)
			)
			(3
				(leopard
					y: 116
					setLoop: 0
					cycleSpeed: 4
					moveSpeed: 4
					setCycle: JumpCycler 3 6
					setMotion: JumpOver 265 140 60 self
				)
			)
			(4
				(client setScript: getEgo)
			)
		)
	)
)

(instance getEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(leopard
					view: 631
					cel: 0
					y: (+ (leopard y:) 6)
					setLoop: 6
					setCycle: CT 1 1 self
				)
			)
			(1
				(leopard
					setCycle: Walk
					setLoop: 1
					setMotion: MoveTo (+ (gEgo x:) 5) 152 self
				)
			)
			(2
				((gCurRoom script:) cue:)
				(self dispose:)
			)
		)
	)
)

(instance unbalance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: MoveTo (- (gEgo x:) 30) (gEgo y:) self
				)
			)
			(1 0)
			(2
				(if (leopard script:)
					(leopardStart cue:)
				)
				(gEgo setMotion: MoveTo (- (gEgo x:) 5) (gEgo y:) self)
			)
			(3
				(gEgo
					view: 11
					setLoop: 3
					setCycle: End self
					setMotion: MoveTo (- (gEgo x:) 3) (- (gEgo y:) 2)
				)
			)
			(4
				(gCurRoom setScript: egoFell 0 0)
			)
		)
	)
)

(instance egoFell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (or (== global209 3) (== global209 2))
					(bridgeControls state: (& (bridgeControls state:) $ffdf))
				)
				(gEgo
					code: 0
					view: 6
					loop: local22
					cel: 0
					setPri: -1
					moveSpeed: 5
					setCycle: 0
					setMotion: JumpX -55 self
				)
			)
			(1
				(gEgo setCycle: End self)
				(sFx number: 920 play: 127)
				(ShakeScreen 1)
			)
			(2
				(HandsOff)
				(if register
					(self cue:)
				)
			)
			(3
				(switch local21
					(0
						(EgoDead 9 630 633 End) ; "You knew what to do, but you blew it. Too bad you didn't practice your dodges and learn your leaps well enough before you became cat food."
					)
					(1
						(EgoDead 10 630 633 End) ; "When the cat no longer sat, ya should'a scat. You'd best elude the leopard's leap or you'll be munched for lunch."
					)
					(2
						(EgoDead 11 630 633 End) ; "If you're going to walk a tightrope over certain death, make sure you know what you are doing first. Drill your skill before you're killed."
					)
					(else
						(EgoDead 6 630 633 End) ; "Next time you feed the kitty, make sure you aren't on the menu."
					)
				)
			)
		)
	)
)

(instance enterFence of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(gMessager say: 1 6 1 0 self) ; "Climb up here. This is the spot nearest to my father's hut."
			)
			(2
				(gEgo show:)
				(leopard show:)
				(leopardLady show:)
				(= cycles 2)
			)
			(3
				(leopard setMotion: xDPath 259 182 281 161 240 121 179 149)
				(gMessager say: 1 6 2 0 self) ; "You can see Chui, our pet black leopard, wandering down there. He is trained to eat strangers and he is always very hungry. You need to be very careful or he will attack you."
			)
			(4
				(gEgo setPri: -1 setCycle: Beg self)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance backFence of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 6) self)
				(leopard setMotion: xDPath 259 182 281 161 240 121 179 149)
			)
			(1
				(gMessager say: 1 6 4 0 self) ; "Hurry up! The guards will see you at any minute!"
			)
			(2
				(HandsOff)
				(gEgo setMotion: DPath 119 99 154 101 self)
			)
			(3
				(gEgo
					view: 12
					y: 103
					setCycle: Walk
					setMotion: MoveTo (+ (gEgo x:) 15) 103 self
				)
			)
			(4
				(if (or (== global209 2) (== global209 3))
					(gEgo
						view: 12
						setLoop: 0
						setMotion: MoveTo (- (gEgo x:) 3) (gEgo y:)
					)
					(client setScript: mediumCross)
				else
					(self cue:)
				)
			)
			(5
				(gEgo origStep: 257 setMotion: MoveTo 303 103 self)
			)
			(6
				(gCurRoom setScript: egoDown self)
			)
		)
	)
)

(instance egoDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(moveStraight dispose:)
				(gEgo view: 4 setLoop: 3 setCel: 0 code: 0)
				(= cycles 5)
			)
			(1
				(gEgo cycleSpeed: 10 setCycle: End self)
			)
			(2
				(rope setCycle: CT 0 -1 self)
			)
			(3
				(rope dispose:)
				(= cycles 5)
			)
			(4
				(if (gEgo has: 46) ; theMagicDrum
					(gCurRoom setScript: trans)
				else
					(self cue:)
				)
			)
			(5
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 0)
				(= cycles 5)
			)
			(6
				(= seconds 1)
			)
			(7
				(gMessager say: 2 6 5 0 self) ; "You grab your grapnel and hurry back to the Simbani village with the Spear of Death."
			)
			(8
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance trans of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 0)
				(= cycles 5)
			)
			(1
				(= seconds 1)
			)
			(2
				(gMessager say: 2 6 26 0 self) ; "You camp out for the rest of the night and next day. Then Johari takes you back to the village."
			)
			(3
				(++ gDay)
				(= gClock 3000)
				(gCurRoom newRoom: 620)
			)
		)
	)
)

(instance moveForward of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0)
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) local24) (gEgo y:) self
				)
			)
			(1
				(+= local19 6)
				(if (not (leopard script:))
					(cond
						((< local25 2)
							(cond
								((localproc_2)
									(++ local25)
									(localproc_1)
									(leopard setScript: leopardAttack)
								)
								((and (not register) (< (gEgo x:) 258))
									(leopard setScript: leopardChase)
								)
							)
						)
						((not local14)
							(leopard
								moveSpeed: 6
								cycleSpeed: 6
								setCycle: Walk
								setMotion: MoveTo 259 182 leopard
							)
							(= local14 1)
						)
					)
				)
				(= cycles 1)
			)
			(2
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance leopardChase of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gPrevRoomNum 640)
					(leopard
						setCycle: Walk
						setMotion:
							MoveTo
							(+ (leopard x:) 3)
							(+ (leopard y:) 2)
							self
					)
				else
					(leopard
						setCycle: Backward
						setMotion:
							MoveTo
							(- (leopard x:) 3)
							(- (leopard y:) 2)
							self
					)
				)
			)
			(1
				(leopard setCycle: 0)
				(self dispose:)
			)
		)
	)
)

(instance moveStraight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0)
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) local24) (gEgo y:) self
				)
			)
			(1
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance leopardAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(leopard view: 632 setLoop: 1 setCycle: End self)
				(sFx number: 909 play:)
			)
			(1
				(= local12 0)
				(if (== global209 2)
					(= seconds 2)
				else
					(self cue:)
				)
			)
			(2
				(= local12 1)
				(= seconds 0)
				(leopard
					y: (- (leopard y:) 6)
					setLoop: 0
					cycleSpeed: 4
					moveSpeed: 4
					setCycle: JumpCycler 3 6
					setMotion: Attack (+ (gEgo x:) 13) 142 68 self
				)
			)
			(3
				(if register
					(client setScript: getEgo)
				else
					(if (gEgo script:)
						((gEgo script:) cue:)
					)
					(self cue:)
				)
			)
			(4
				(leopard
					view: 631
					y: (+ (leopard y:) 6)
					cel: 0
					setPri: -1
					setLoop: 6
					setCycle: End self
				)
			)
			(5
				(leopard setScript: leopardApproach 0 0)
				(self dispose:)
			)
		)
	)
)

(instance assistDuck of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0)
				(if (== (leopardAttack state:) 1)
					(leopardAttack cue:)
				)
				(if (== (gEgo trySkill: 2 (+ local20 20)) -1) ; agility
					(= local13 1)
					(= local21 0)
				else
					(+= local20 5)
					(= local13 0)
				)
				(gEgo view: 29 cel: 0 loop: local22 setCycle: CT 3 1 self)
			)
			(1 0)
			(2
				(gEgo cycleSpeed: 12 setCycle: CT 9 1 self)
			)
			(3
				(gEgo view: 12 cycleSpeed: 6 setLoop: local22 setCycle: Walk)
				(self dispose:)
			)
		)
	)
)

(instance duckOnly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0)
				(gEgo view: 29 cel: 0 loop: local22 setCycle: End self)
			)
			(1
				(gEgo
					view: 12
					cycleSpeed: 6
					setLoop: local22
					origStep: 257
					setCycle: Walk
				)
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance duckDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0)
				(if (== (gEgo trySkill: 2 (+ local20 20)) -1) ; agility
					(= local13 1)
					(= local21 0)
				else
					(+= local20 5)
					(= local13 0)
				)
				(gEgo view: 29 cel: 0 loop: local22 setCycle: CT 3 1 self)
			)
			(1 0)
			(2
				(gEgo cycleSpeed: 12 setCycle: CT 9 1 self)
			)
			(3
				(gEgo
					view: 12
					cycleSpeed: 6
					setLoop: local22
					origStep: 257
					setCycle: Walk
				)
				(self dispose:)
			)
		)
	)
)

(instance assistJump of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0)
				(if (== (leopardAttack state:) 1)
					(leopardAttack cue:)
				)
				(= cycles 1)
			)
			(1
				(= cycles 10)
			)
			(2
				(if (== (gEgo trySkill: 2 (+ local20 20)) -1) ; agility
					(= local13 1)
					(= local21 0)
				else
					(+= local20 5)
					(= local13 0)
				)
				(gLongSong2 number: 250 setLoop: 1 play:)
				(gEgo
					view: 30
					cel: 0
					cycleSpeed: 5
					moveSpeed: 5
					setLoop: local22
					setCycle: JumpCycler 1 5
					setMotion: JumpX 53 self
				)
			)
			(3
				(gEgo
					view: 12
					moveSpeed: 6
					cycleSpeed: 6
					setLoop: local22
					setCycle: Walk
				)
				(self dispose:)
			)
		)
	)
)

(instance jumpUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0)
				(if (== (gEgo trySkill: 2 (+ local20 20)) -1) ; agility
					(= local13 1)
					(= local21 0)
				else
					(+= local20 5)
					(= local13 0)
				)
				(gLongSong2 number: 250 setLoop: 1 play:)
				(gEgo
					view: 30
					cel: 0
					cycleSpeed: 5
					moveSpeed: 5
					setLoop: local22
					setCycle: JumpCycler 1 5
					setMotion: JumpX 53 self
				)
			)
			(1
				(gEgo
					view: 12
					moveSpeed: 6
					cycleSpeed: 6
					setLoop: local22
					setCycle: Walk
				)
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance preCrossing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 151 (gEgo y:) self)
			)
			(1
				(gCurRoom setScript: ropeCrossing 0 0)
			)
		)
	)
)

(instance crossCheck of Code
	(properties)

	(method (doit)
		(if (< (gEgo x:) 166)
			((gCurRoom script:) register: 0)
			(bridgeControls state: (& (bridgeControls state:) $ffdf))
			(HandsOff)
			(gEgo solvePuzzle: 301 8 4)
			(moveForward dispose:)
			(leopardAttack dispose:)
			(if (and (not local14) (not (IsFlag 66)))
				(leopard setCycle: Walk)
				(leopard cue:)
				(leopard cue:)
			)
			(gCurRoom setScript: preCrossing)
		)
	)
)

(instance backCheck of Code
	(properties)

	(method (doit)
		(if (> (gEgo x:) 302)
			(bridgeControls state: (& (bridgeControls state:) $ffdf))
			(moveForward dispose:)
			(leopardAttack dispose:)
			(gCurRoom setScript: egoDown)
		)
	)
)

(instance stepCheck of Code
	(properties)

	(method (doit)
		(if (< (gEgo x:) 270)
			(moveForward dispose:)
			(leopardAttack dispose:)
			(= local21 2)
			(gCurRoom setScript: egoFell 0 1)
		)
	)
)

(instance leopard of Actor
	(properties
		x 259
		y 182
		noun 7
		view 631
		loop 1
		cel 7
		signal 16384
	)

	(method (doVerb theVerb &tmp temp0)
		(cond
			((OneOf theVerb 24 28 27) ; theRations, theMeat, theFish
				(= temp0
					(switch theVerb
						(28 18) ; theMeat
						(27 17) ; theFish
						(24 14) ; theRations
					)
				)
				(if (not (IsFlag 66))
					(SetFlag 66)
					(gEgo drop: temp0 1 solvePuzzle: 300 5 4 addHonor: 20)
					(gCurRoom setScript: throwFood)
				else
					(gEgo drop: temp0 1)
					(gMessager say: 11 6 27) ; "You loft the leopard some delectable delights to appease its palate."
				)
			)
			((OneOf theVerb 20 33 16) ; theDaggers, theRocks, theGrapnel
				(gEgo addHonor: -30)
				(gMessager say: 1 6 12) ; "Don't you even think about hurting Chui. He and I were cubs together. Don't you dare!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(self yStep: 1 setCycle: Walk hide:)
	)

	(method (setHeading param1)
		(if (not (& signal $0800))
			(+= param1 45)
			(super setHeading: param1 &rest)
			(= loop
				(switch loop
					(0 2)
					(1 1)
					(2 0)
					(3 3)
				)
			)
		)
	)

	(method (cue)
		(leopard setLoop: -1 setMotion: xDPath 259 182 281 161 240 121 179 149)
	)
)

(instance leopardLady of View
	(properties
		x 292
		y 119
		z 30
		noun 1
		view 974
		loop 5
		priority 1
		signal 16
	)
)

(instance theHut of Feature
	(properties
		x 126
		y 27
		noun 3
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 16) ((gInventory at: 6) state:) (not local15)) ; theGrapnel, theGrapnel
			(= local15 1)
			(gEgo solvePuzzle: 299 5 4)
			(gCurRoom setScript: ropeThrow)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance rope of Prop
	(properties
		x 310
		y 70
		view 630
		priority 10
		signal 16400
	)
)

(instance egoTell of Teller
	(properties)
)

(instance johariTell of Teller
	(properties)
)

(instance bridgeControls of GloryControls
	(properties)

	(method (init)
		(super init: &rest)
		(= local28 1)
		(= window bridgeWin)
		(User input: 1)
		(gGame setCursor: 999)
		(= icon1 iconJump)
		(= icon2 iconDrop)
		(= icon3 iconPush)
		(= icon4 iconPull)
		(= icon5 iconL)
		(= icon6 iconR)
		(= icon7 iconQuit)
		(self
			add:
				iconJump
				iconDrop
				iconPush
				iconPull
				iconL
				iconR
				iconQuit
				iconDummy
			eachElementDo: #lowlightColor -1
			eachElementDo: #highlightColor -1
			eachElementDo: #signal 129
		)
		(self disable: iconPush iconPull iconQuit)
		(if (== gPrevRoomNum 640)
			(self disable: iconL)
		else
			(self disable: iconR)
		)
		(SetCursor 121 43 182 127)
	)

	(method (dispose)
		(= local11 0)
		(super dispose:)
	)

	(method (dispatchEvent event &tmp temp0 temp1)
		(= gGameTime (GetTime))
		(Animate (gCast elements:) 1)
		(if gDoMotionCue
			(= gDoMotionCue 0)
			(gCast eachElementDo: #motionCue)
		)
		(if (& (= temp0 (event type:)) $0040) ; direction
			(&= temp0 $ffbf) ; evPEEK | evVERB | evHELP | evMOVE | evJOYUP | evJOYDOWN | evSAID | evMENUHIT | evMENUSTART | evKEYUP | evMOUSEKEYBOARD | evMOUSERELEASE | evNULL | $0c00
			(switch (event message:)
				(JOY_UP
					(return 0)
				)
				(JOY_DOWN
					(return 0)
				)
				(else
					(super dispatchEvent: event)
				)
			)
		else
			(= temp1 (event message:))
			(if (== temp0 evKEYBOARD)
				(cond
					((== temp1 KEY_8)
						(return 0)
					)
					((== temp1 KEY_2)
						(return 0)
					)
					(else
						(super dispatchEvent: event)
					)
				)
			else
				(super dispatchEvent: event)
			)
		)
	)

	(method (hide)
		(SetCursor -2)
		(super hide:)
	)

	(method (show)
		(if local11
			(window open:)
			(self eachElementDo: #show)
		else
			(= local11 1)
			(super show:)
		)
	)
)

(instance iconJump of IconI
	(properties
		view 470
		loop 1
		cel 0
		nsLeft 2
		nsTop 2
		maskView 470
		maskLoop 10
	)

	(method (highlight param1)
		(if (not (& signal $0020))
			(return)
		)
		(if param1
			(DrawCel view loop 2 nsLeft nsTop)
		else
			(DrawCel view loop 0 nsLeft nsTop)
		)
	)

	(method (select)
		(if (super select:)
			(if (not (or (gEgo script:) (gEgo mover:)))
				(if (and (== global209 2) (not local12))
					(gEgo setScript: assistJump)
				else
					(gEgo setScript: jumpUp)
				)
			)
			(return 1)
		)
	)

	(method (onMe param1)
		(return
			(if
				(and
					(super onMe: param1)
					(not
						(IsItSkip
							view
							loop
							cel
							(- (param1 y:) nsTop)
							(- (param1 x:) nsLeft)
						)
					)
				)
				(self highlight: 1)
			else
				(self highlight: 0)
			)
		)
	)
)

(instance iconR of IconI
	(properties
		view 470
		loop 9
		cel 0
		nsLeft 60
		nsTop 12
		maskView 470
		maskLoop 10
		maskCel 5
	)

	(method (highlight param1)
		(if param1
			(DrawCel view loop 2 nsLeft nsTop)
		else
			(DrawCel view loop 0 nsLeft nsTop)
		)
	)

	(method (select)
		(if (and (not (& signal $0004)) (super select: &rest))
			(cond
				((IsFlag 66)
					(gEgo setScript: moveStraight)
				)
				((not (or (gEgo script:) (gEgo mover:)))
					(gEgo setScript: moveForward)
				)
			)
			(return 1)
		)
	)

	(method (onMe param1)
		(if (not (& signal $0004))
			(if
				(and
					(super onMe: param1)
					(not
						(IsItSkip
							view
							loop
							cel
							(- (param1 y:) nsTop)
							(- (param1 x:) nsLeft)
						)
					)
				)
				(self highlight: 1)
			else
				(self highlight: 0)
			)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconL of IconI
	(properties
		view 470
		loop 8
		cel 0
		nsLeft 3
		nsTop 12
		maskView 470
		maskLoop 10
		maskCel 4
	)

	(method (highlight param1)
		(if (not (& signal $0020))
			(return)
		)
		(if param1
			(DrawCel view loop 2 nsLeft nsTop)
		else
			(DrawCel view loop 0 nsLeft nsTop)
		)
	)

	(method (select)
		(if (and (not (& signal $0004)) (super select: &rest))
			(cond
				((IsFlag 66)
					(gEgo setScript: moveStraight)
				)
				((not (or (gEgo script:) (gEgo mover:)))
					(gEgo setScript: moveForward)
				)
			)
			(return 1)
		)
	)

	(method (onMe param1)
		(if (not (& signal $0004))
			(if
				(and
					(super onMe: param1)
					(not
						(IsItSkip
							view
							loop
							cel
							(- (param1 y:) nsTop)
							(- (param1 x:) nsLeft)
						)
					)
				)
				(self highlight: 1)
			else
				(self highlight: 0)
			)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconPush of IconI
	(properties
		view 470
		loop 10
		cel 2
		nsLeft 2
		nsTop 34
		signal 4
		maskView 470
		maskLoop 10
		maskCel 2
	)

	(method (onMe param1)
		(if
			(and
				(super onMe: param1)
				(not
					(IsItSkip
						view
						loop
						cel
						(- (param1 y:) nsTop)
						(- (param1 x:) nsLeft)
					)
				)
			)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconPull of IconI
	(properties
		view 470
		loop 10
		cel 3
		nsLeft 52
		nsTop 34
		signal 4
		maskView 470
		maskLoop 10
		maskCel 3
	)

	(method (onMe param1)
		(if
			(and
				(super onMe: param1)
				(not
					(IsItSkip
						view
						loop
						cel
						(- (param1 y:) nsTop)
						(- (param1 x:) nsLeft)
					)
				)
			)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconDrop of IconI
	(properties
		view 470
		loop 2
		cel 0
		nsLeft 51
		nsTop 2
		maskView 470
		maskLoop 10
		maskCel 1
	)

	(method (highlight param1)
		(if param1
			(DrawCel view loop 2 nsLeft nsTop)
		else
			(DrawCel view loop 0 nsLeft nsTop)
		)
	)

	(method (select)
		(if (super select: &rest)
			(cond
				((or (gEgo script:) (gEgo mover:))
					(return 1)
				)
				((or (IsFlag 66) local14)
					(gEgo setScript: duckOnly)
				)
				((== global209 2)
					(if (not local12)
						(gEgo setScript: assistDuck)
					else
						(gEgo setScript: duckOnly)
					)
				)
				((leopard script:)
					(gEgo setScript: duckDown)
				)
				(else
					(gEgo setScript: duckOnly)
				)
			)
			(return 1)
		)
	)

	(method (onMe param1)
		(return
			(if
				(and
					(super onMe: param1)
					(not
						(IsItSkip
							view
							loop
							cel
							(- (param1 y:) nsTop)
							(- (param1 x:) nsLeft)
						)
					)
				)
				(self highlight: 1)
			else
				(self highlight: 0)
			)
		)
	)
)

(instance iconQuit of IconI
	(properties
		view 470
		loop 7
		cel 0
		nsLeft 24
		nsTop 2
		signal 4
		maskView 470
		maskLoop 7
		maskCel 2
	)

	(method (onMe param1)
		(if
			(and
				(super onMe: param1)
				(not
					(IsItSkip
						view
						loop
						cel
						(- (param1 y:) nsTop)
						(- (param1 x:) nsLeft)
					)
				)
			)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconDummy of IconI
	(properties)

	(method (show))

	(method (onMe)
		(return 0)
	)
)

(instance bridgeWin of Window
	(properties
		top 111
		left 45
		bottom 175
		right 125
		color 17
		back 17
	)

	(method (open)
		(super open: &rest)
		(DrawCel 470 0 0 0 0 -1)
	)
)

(instance skull of Feature
	(properties
		x 28
		y 112
		noun 6
		nsTop 81
		nsLeft 7
		nsBottom 143
		nsRight 50
	)
)

(instance doorway of Feature
	(properties
		x 119
		y 47
		noun 8
		nsTop 30
		nsLeft 108
		nsBottom 64
		nsRight 130
	)

	(method (doVerb theVerb)
		(if (== theVerb 16) ; theGrapnel
			(theHut doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance treehouse of Feature
	(properties
		x 131
		y 38
		noun 9
		nsTop 11
		nsLeft 66
		nsBottom 65
		nsRight 197
	)

	(method (doVerb theVerb)
		(if (== theVerb 16) ; theGrapnel
			(theHut doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance tree of Feature
	(properties
		x 132
		y 100
		noun 10
		nsTop 71
		nsLeft 83
		nsBottom 130
		nsRight 181
	)

	(method (doVerb theVerb)
		(if (== theVerb 16) ; theGrapnel
			(theHut doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sFx of Sound
	(properties)
)

(instance quest of GameControls
	(properties)

	(method (init)
		(gGame setCursor: 999)
		((= window (GloryWindow new:))
			top: 60
			left: 82
			bottom: 130
			right: 238
			priority: 15
			yourself:
		)
		(self add: titleIcon yesIcon noIcon)
		(super init: &rest)
	)
)

(instance titleIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 0
		signal 4
		maskView 361
		maskLoop 3
	)

	(method (show &tmp [temp0 50])
		(Message msgGET 630 2 6 3 1 @temp0) ; "Do you wish to leave and practice your tightrope walking skills?"
		(Display @temp0 dsWIDTH 155 dsCOORD 5 3 dsCOLOR 17)
	)
)

(instance yesIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 38
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= local0 1)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show)
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display @local1 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
			(= temp0 46)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 17)
		)
		(Display @local1 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

(instance noIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 53
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= local0 0)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show &tmp [temp0 15])
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display @local6 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
			(= temp0 46)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 17)
		)
		(Display @local6 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

