;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 216)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use PolyPath)
(use Polygon)
(use RFeature)
(use Motion)
(use Actor)
(use System)

(public
	rm216 0
)

(local
	local0
	local1
	local2
	[local3 18] = [73 174 25 174 25 162 31 157 49 154 67 157 73 162 97 166 97 172]
	[local21 40] = [0 0 319 0 319 102 272 102 307 122 262 143 201 147 193 134 274 119 187 108 185 128 153 129 145 122 111 125 107 119 148 113 143 107 119 112 24 100 0 87]
	[local61 8] = [233 159 246 155 260 159 245 163]
	[local69 8] = [105 150 118 145 129 150 117 154]
	[local77 10] = [0 112 36 111 46 116 39 119 0 120]
	[local87 12] = [63 115 76 115 100 124 111 142 90 142 61 126]
	[local99 10] = [37 122 52 116 98 125 105 143 43 143]
	local109 = 1
	local110
	local111
	local112
	local113
)

(instance rm216 of KQ5Room
	(properties
		picture 216
		north 15
		east 15
		south 15
		west 15
	)

	(method (init)
		(super init:)
		(= local113 gUseSortedFeatures)
		(= gUseSortedFeatures 1)
		(self addObstacle: poly0 poly1 poly2 poly3 poly4)
		(self setFeatures: fireRing)
		(gAddToPics add: fireRing doit:)
		(if (IsFlag 32)
			(self
				setFeatures:
					horse1
					horse2
					horse3
					dancer
					camel
					littleTent
					bigTent
			)
			(gGlobalSound number: 46 loop: -1 playBed:)
			(gAddToPics add: horse1 horse2 horse3 camel doit:)
			(if (== (gGame detailLevel:) 3)
				(crowd1 init: cycleSpeed: 2 setScript: (crowdScript new:))
				(crowd2 init: cycleSpeed: 2 setScript: (crowdScript new:))
				(girl init: setScript: girlScript)
			else
				(crowd1 init: stopUpd:)
				(crowd2 init: stopUpd:)
				(girl init: stopUpd:)
			)
			(if (not (IsFlag 53))
				(HandsOff)
				(SetFlag 53)
				(drunkGuy init: setScript: drunkGuyScript)
			else
				(drunkGuy
					loop: 2
					posn: 60 129
					cel: (- (NumCels drunkGuy) 1)
					init:
					stopUpd:
				)
			)
			(self addObstacle: poly6)
			(fire loop: 2)
		else
			(gGlobalSound number: 44 loop: -1 play: 90)
			(gGlobalSound2 number: 2 loop: -1 play:)
			(gGlobalSound3 number: 3 loop: -1 play:)
			(self addObstacle: poly5)
			(fire loop: 1)
		)
		(fire init: cycleSpeed: 3 setCycle: Fwd)
		(if (< (gGame detailLevel:) (fire detailLevel:))
			(fire stopUpd:)
		)
		(waterJug init: stopUpd:)
		(switch gPrevRoomNum
			(17
				(gEgo posn: 175 142)
			)
			(else
				(gEgo
					x: (if (> (gEgo x:) 100) 309 else 10)
					y: (if (< (gEgo y:) 150) 185 else 165)
				)
			)
		)
		(gEgo view: 0 illegalBits: -32768 setPri: -1 setStep: 3 2 init:)
		(if (not (IsFlag 49))
			(SetFlag 49)
			(SetScore 3)
		)
		(self setFeatures: littleTent bigTent)
		(poly0 points: @local3 size: 9)
		(poly1 points: @local21 size: 20)
		(poly2 points: @local61 size: 4)
		(poly3 points: @local69 size: 4)
		(poly4 points: @local77 size: 5)
		(poly5 points: @local87 size: 6)
		(poly6 points: @local99 size: 5)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			(local112
				(if (gEgo mover:)
					(= local112 0)
					(gEgo show:)
					((gEgo head:) show:)
					(waterJug cel: 0 stopUpd:)
				)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(switch (gEgo edgeHit:)
					(EDGE_TOP
						(-- global315)
					)
					(EDGE_BOTTOM
						(= global314 10)
						(= global315 8)
					)
					(EDGE_RIGHT
						(= global314 9)
						(= global315 7)
					)
					(EDGE_LEFT
						(= global314 11)
						(= global315 7)
					)
				)
				(gCurRoom newRoom: temp0)
			)
			((& (gEgo onControl: 0) $4000)
				(if
					(and
						(IsFlag 32)
						(== (Random 1 4) 1)
						(not (IsFlag 102))
						(== global100 0)
					)
					(if
						(not
							((ScriptID 754) ; CPCheck
								doit:
									{There is a bandit inside the smaller tent! Graham must use Crispin's wand to cast a sleep spell on him.}
							)
						)
						(SetFlag 92)
					else
						(SetFlag 93)
						(SetFlag 102)
					)
				)
				(gCurRoom newRoom: 17)
			)
			((& (gEgo onControl: 0) $0010)
				(gCurRoom setScript: killEgo)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
			(else
				(switch (event message:)
					(5 ; Talk
						(PrintDC 216 0) ; "This is no time for talking!"
						(event claimed: 1)
					)
				)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(gGlobalSound2 fade:)
		(gGlobalSound fade:)
		(gGlobalSound3 fade:)
		(= gUseSortedFeatures local113)
		(super newRoom: newRoomNumber)
	)
)

(instance searchDrunk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 70 143 self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 56
					loop: 1
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(= cycles 15)
			)
			(3
				(= cycles 15)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(PrintDC 216 1) ; "Whew! Holding his nose against the drunken bandit's pungent odor, Graham searches him but doesn't find anything of importance."
				(gEgo
					normal: 1
					view: 0
					setCycle: KQ5SyncWalk
					cycleSpeed: 0
					loop: 7
					cel: 1
				)
				((gEgo head:) show:)
				(= cycles 2)
			)
			(6
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance drunkGuyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(drunkGuy setLoop: 0 cycleSpeed: 2 setCycle: End self)
			)
			(2
				(drunkGuy
					loop: 1
					posn: (+ (drunkGuy x:) 4) (+ (drunkGuy y:) 1)
					cel: 0
					setCycle: End self
				)
			)
			(3
				(drunkGuy
					loop: 2
					posn: (- (drunkGuy x:) 2) (+ (drunkGuy y:) 5)
					cel: 0
					setCycle: End self
				)
			)
			(4
				(HandsOn)
				(drunkGuy setScript: 0 ignoreActors: stopUpd:)
			)
		)
	)
)

(instance killEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo signal: 16384 setMotion: MoveTo 81 110 self)
			)
			(1
				(gGlobalSound number: 129 priority: 500 loop: 1 play:)
				(Print 216 2 #at 20 20 #dispose) ; "An intruder!"
				(crowd1 setScript: 0 setCycle: 0)
				(crowd2 setScript: 0 setCycle: 0)
				(girl setScript: 0 setCycle: 0)
				(killingBandit init: cycleSpeed: 2 setCycle: End self)
			)
			(2
				(gEgo hide:)
				((gEgo head:) hide:)
				(killingBandit
					posn: (+ (killingBandit x:) 9) (+ (killingBandit y:) 1)
					loop: 1
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(3
				(killingBandit loop: 2 cel: 0)
				(gEgo
					show:
					normal: 0
					view: 426
					y: (+ (gEgo y:) 7)
					loop: 3
					cel: 0
					cycleSpeed: 4
					setCycle: End self
				)
			)
			(4
				(cls)
				(= seconds 2)
			)
			(5
				(= global330
					{That wasn't a very smart move!}
				)
				(EgoDead)
			)
		)
	)
)

(instance girlScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local1
					(= cycles 1)
				else
					(= cycles 15)
				)
			)
			(1
				(girl view: 385 setLoop: 0 cel: 0 setCycle: End self)
			)
			(2
				(girl setLoop: 2 cel: 0 setCycle: End self)
			)
			(3
				(girl setLoop: 4 cel: 0 setCycle: End self)
			)
			(4
				(girl setLoop: 6 cel: 0 setCycle: End self)
			)
			(5
				(girl view: 387 cel: 0 setLoop: 0 setCycle: End self)
			)
			(6
				(girl setLoop: 2 cel: 0 setCycle: Fwd)
				(= seconds 2)
			)
			(7
				(girl setLoop: 4 cel: 0 setCycle: Fwd)
				(= seconds 2)
			)
			(8
				(girl view: 389 cel: 0 setLoop: 0 setCycle: End self)
			)
			(9
				(girl cel: 0 setLoop: 2 setCycle: End self)
			)
			(10
				(girl cel: 0 setLoop: 4 setCycle: End self)
			)
			(11
				(girl cel: 0 setLoop: 6 setCycle: End self)
			)
			(12
				(girl cel: 0 setLoop: 8 setCycle: End self)
			)
			(13
				(girl view: 385 setLoop: 1 cel: 0 setCycle: End self)
			)
			(14
				(girl setLoop: 3 cel: 0 setCycle: End self)
			)
			(15
				(girl setLoop: 5 cel: 0 setCycle: End self)
			)
			(16
				(girl setLoop: 7 cel: 0 setCycle: End self)
			)
			(17
				(girl view: 387 cel: 0 setLoop: 1 setCycle: End self)
			)
			(18
				(girl setLoop: 3 cel: 0 setCycle: Fwd)
				(= seconds 2)
			)
			(19
				(girl setLoop: 5 cel: 0 setCycle: Fwd)
				(= seconds 2)
			)
			(20
				(girl view: 389 cel: 0 setLoop: 1 setCycle: End self)
			)
			(21
				(girl cel: 0 setLoop: 3 setCycle: End self)
			)
			(22
				(girl cel: 0 setLoop: 5 setCycle: End self)
			)
			(23
				(girl cel: 0 setLoop: 7 setCycle: End self)
			)
			(24
				(girl cel: 0 setLoop: 9 setCycle: End self)
			)
			(25
				(++ local1)
				(self init:)
			)
		)
	)
)

(instance crowdScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(client cel: 0)
				(= state -1)
				(= seconds (Random 4 8))
			)
		)
	)
)

(instance walkToJug of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (or (!= (gEgo x:) 84) (!= (gEgo y:) 168))
					(gEgo
						ignoreActors: 1
						illegalBits: 0
						setMotion: PolyPath 84 168 self
					)
				else
					(= cycles 1)
				)
			)
			(1
				(if (== ((gTheIconBar curIcon:) message:) 3)
					(waterJug cycleSpeed: 12)
					(Print 216 3 #at 110 120 #dispose) ; "Ah! Life-giving water! Nectar of the gods! Graham can now feel renewal flowing through him."
					(= global322 0)
					(= local110 1)
					(= cycles 1)
				else
					(gEgo loop: 2)
					(RedrawCast)
					(= cycles 2)
				)
			)
			(2
				(if local110
					(gEgo hide:)
					((gEgo head:) hide:)
					(waterJug cel: 1 setCycle: End self)
				else
					(PrintDC 216 4) ; "A large clay jar full of water stands by the campfire."
					(= cycles 1)
				)
			)
			(3
				(= cycles 1)
				(if local110
					(+= cycles 16)
				)
			)
			(4
				(if local110
					(waterJug setCycle: CT 2 -1 self)
				else
					(= cycles 1)
				)
			)
			(5
				(= cycles 1)
				(if local110
					(+= cycles 4)
				)
			)
			(6
				(if (and local110 (< local110 3))
					(waterJug setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(7
				(cond
					((and local109 (!= local110 0) (< local110 3))
						(++ local110)
						(-= state 5)
					)
					(local110
						(waterJug cel: 1)
						(= local109 (= local110 0))
						(= local112 1)
						(cls)
					)
				)
				(= cycles 1)
			)
			(8
				(HandsOn)
				(= local111 1)
				(client setScript: 0)
			)
		)
	)
)

(instance fire of Prop
	(properties
		x 49
		y 173
		z 7
		view 416
		signal 16384
		detailLevel 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(PrintDC
					(if (IsFlag 32)
						{The campfire, all but forgotten, has been reduced to a pile of glowing embers.}
					else
						{The flaming campfire makes the oppressive heat of the desert even worse.}
					)
				)
			)
			(3
				(PrintDC
					(if (IsFlag 32)
						{The glowing coals of the dying campfire are of no interest to Graham.}
					else
						{Graham wisely chooses to avoid the flames and heat of the blazing campfire.}
					)
				)
			)
			(else
				(super doVerb: &rest)
			)
		)
	)
)

(instance waterJug of Prop
	(properties
		x 81
		y 169
		view 416
		loop 3
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(PrintDC 216 4) ; "A large clay jar full of water stands by the campfire."
			)
			(3
				(if local109
					(gCurRoom setScript: walkToJug)
				else
					(PrintDC 216 5) ; "Graham has had all the water he wants for now."
				)
			)
			(else
				(super doVerb: &rest)
			)
		)
	)
)

(instance crowd1 of Prop
	(properties
		x 66
		y 93
		onMeCheck 2
		view 420
		detailLevel 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(PrintDC 216 6) ; "Overhearing loud music and laughter from within the larger tent, Graham guesses the bandits must be celebrating their latest plunder."
			)
			(else
				(super doVerb: &rest)
			)
		)
	)
)

(instance crowd2 of Prop
	(properties
		x 158
		y 67
		onMeCheck 2
		view 420
		loop 1
		detailLevel 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(PrintDC 216 6) ; "Overhearing loud music and laughter from within the larger tent, Graham guesses the bandits must be celebrating their latest plunder."
			)
			(else
				(super doVerb: &rest)
			)
		)
	)
)

(instance fireRing of RPicView
	(properties
		x 49
		y 172
		view 416
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(PrintDC
					(if (IsFlag 32)
						{The campfire, all but forgotten, has been reduced to a pile of glowing embers.}
					else
						{The flaming campfire makes the oppressive heat of the desert even worse.}
					)
				)
			)
			(3
				(PrintDC
					(if (IsFlag 32)
						{The glowing coals of the dying campfire are of no interest to Graham.}
					else
						{Graham wisely chooses to avoid the flames and heat of the blazing campfire.}
					)
				)
			)
			(else
				(super doVerb: &rest)
			)
		)
	)
)

(instance horse1 of RPicView
	(properties
		x 282
		y 58
		view 422
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(PrintDC 216 7) ; "The bandits' horses rest in the desert sun while their unsavory owners revel within the large tent."
			)
			(3
				(if (not local0)
					(++ local0)
					(PrintDC 216 8) ; "Disturbing the horses would be very unwise at this time."
				)
			)
			(4
				(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
					(28 0)
					(else
						(PrintDC 216 9) ; "It would be unwise to disturb the horses right now."
					)
				)
			)
			(else
				(super doVerb: &rest)
			)
		)
	)
)

(instance horse2 of RPicView
	(properties
		x 296
		y 70
		view 422
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(PrintDC 216 7) ; "The bandits' horses rest in the desert sun while their unsavory owners revel within the large tent."
			)
			(3
				(PrintDC 216 8) ; "Disturbing the horses would be very unwise at this time."
			)
			(4
				(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
					(28 0)
					(else
						(PrintDC 216 9) ; "It would be unwise to disturb the horses right now."
					)
				)
			)
			(else
				(super doVerb: &rest)
			)
		)
	)
)

(instance horse3 of RPicView
	(properties
		x 305
		y 88
		view 422
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(PrintDC 216 7) ; "The bandits' horses rest in the desert sun while their unsavory owners revel within the large tent."
			)
			(3
				(PrintDC 216 8) ; "Disturbing the horses would be very unwise at this time."
			)
			(4
				(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
					(28 0)
					(else
						(PrintDC 216 9) ; "It would be unwise to disturb the horses right now."
					)
				)
			)
			(else
				(super doVerb: &rest)
			)
		)
	)
)

(instance camel of RPicView
	(properties
		x 166
		y 110
		view 422
		loop 3
		priority 7
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(PrintDC 216 10) ; "A lone camel waits near the large tent while his owner celebrates inside."
			)
			(3
				(PrintDC 216 11) ; "The bandits would notice if Graham disturbed the camel."
			)
			(4
				(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
					(28 0)
					(else
						(PrintDC 216 12) ; "It would be unwise to disturb the camel right now."
					)
				)
			)
			(else
				(super doVerb: &rest)
			)
		)
	)
)

(instance bigTent of RFeature
	(properties
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 32)
					(PrintDC 216 6) ; "Overhearing loud music and laughter from within the larger tent, Graham guesses the bandits must be celebrating their latest plunder."
				else
					(PrintDC 216 13) ; "Two tents sit silently in the desert apparently deserted for the moment."
				)
			)
			(else
				(super doVerb: &rest)
			)
		)
	)
)

(instance littleTent of RFeature
	(properties
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(PrintDC 216 14) ; "There doesn't seem to be any activity going on within the smaller tent."
			)
			(else
				(super doVerb: &rest)
			)
		)
	)
)

(instance dancer of RFeature
	(properties
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(PrintDC 216 15) ; "A beautiful harem girl belly dances for the rowdy bandits."
			)
			(else
				(super doVerb: &rest)
			)
		)
	)
)

(instance girl of Prop
	(properties
		x 176
		y 84
		view 385
		priority 4
		signal 16400
		cycleSpeed 3
		detailLevel 3
	)

	(method (checkDetail param1)
		(super checkDetail: &rest)
		(cond
			((not detailLevel))
			((& signal $0001)
				(|= signal $0100)
			)
			((& signal $0002)
				(&= signal $feff)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(PrintDC 216 15) ; "A beautiful harem girl belly dances for the rowdy bandits."
			)
			(else
				(super doVerb: &rest)
			)
		)
	)
)

(instance drunkGuy of Prop
	(properties
		x 58
		y 123
		view 421
		cycleSpeed 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (self script:)
					(PrintDC 216 16) ; "*** This guy really knows how to party!"
				else
					(PrintDC 216 17) ; "With disgust, Graham looks at a drunken bandit lying face down in the desert sand...completely passed out."
				)
			)
			(3
				(if (not local2)
					(HandsOff)
					(= local2 1)
					(self setScript: searchDrunk)
				)
			)
			(else
				(super doVerb: &rest)
			)
		)
	)
)

(instance killingBandit of Actor
	(properties
		x 73
		y 117
		view 426
		priority 2
		signal 16400
	)
)

(instance poly0 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly2 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly3 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly4 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly5 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly6 of Polygon
	(properties
		type PBarredAccess
	)
)

