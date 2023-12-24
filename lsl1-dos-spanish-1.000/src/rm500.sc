;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Language)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use Sound)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	rm500 0
	aBum 1
)

(local
	aBumThreat
	bumLoop
	bumBegged
	bumVerb
	bumObj
	[unused 2]
	ringInc
	[aBumPolyPts 8]
)

(procedure (MakePoly &tmp rL rT rR rB) ; UNUSED
	(= rL (- (aBum brLeft:) 5))
	(= rT (- (aBum brTop:) 5))
	(= rR (+ (aBum brRight:) 6))
	(= rB (aBum brBottom:))
	(= [aBumPolyPts 0] (= [aBumPolyPts 6] rL))
	(= [aBumPolyPts 1] (= [aBumPolyPts 3] rT))
	(= [aBumPolyPts 2] (= [aBumPolyPts 4] rR))
	(= [aBumPolyPts 5] (= [aBumPolyPts 7] rB))
	(aBumPoly points: @aBumPolyPts size: 4)
	(gCurRoom addObstacle: aBumPoly)
)

(instance rm500 of LLRoom
	(properties
		lookStr {You are outside Lost Wages' one and only Quiki-Mart Convenience Store. A telephone hangs from the utility pole, minus its directory.}
		picture 500
		north 510
		east 600
		west 170
	)

	(method (init)
		(LoadMany rsVIEW 501 808)
		(LoadMany rsSOUND 507 504)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 172 149 215 149 215 152 172 152
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 135 270 135 258 147 81 147 81 137 129 131 319 4
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 68 140 42 140 35 112 0 112 0 0 76 0 76 136
					yourself:
				)
		)
		(fTelephone init: approachVerbs: 3 4 10 11 5 2) ; Do, Inventory, Zipper, Taste/Smell, Talk, Look
		(fEntryLights init:)
		(fLight init:)
		(street init:)
		(darkAlley init:)
		(fWindow init:)
		(fArtGallery init:)
		(fSign init:)
		(switch gPrevRoomNum
			(600
				(self style: 11)
				(if (< (gEgo y:) 135)
					(gEgo y: 135)
				)
			)
			(510
				(HandsOff)
				(gCurRoom setScript: sFromStore)
			)
			(505
				(gEgo
					moveHead: 0
					normal: 0
					view: 501
					setLoop: 0
					setCel: 5
					x: 172
					y: 150
				)
				(HandsOff)
				(if (IsFlag 19) ; fLarryPanting
					(gCurRoom setScript: sHot_Bothered)
				else
					(gCurRoom setScript: sFromTelephone)
				)
			)
			(170
				(gEgo y: 145)
			)
			(200 0)
			(else
				(gEgo posn: 160 150)
			)
		)
		(gEgo init:)
		(super init:)
		(if (and (ObjInRoom 11) (> (gEgo x:) 50) (!= gPrevRoomNum 505))
			(if (IsFlag 99) ; fBumTgl
				(aBum setScript: sBumBegs)
				(Load rsSOUND 111 120)
				(aBum cycleSpeed: gHowFast moveSpeed: (+ 1 gHowFast) init:)
				(aBumHead cycleSpeed: (+ 3 gHowFast) init:)
			)
			(ToggleFlag 99)
		)
		(self setRegions: 700) ; sidewalk
		(if (and (!= gPrevRoomNum 505) (IsFlag 39)) ; fSurveyCalled
			(sfxPhoneRinging prevSignal: 0)
			(sfxPhoneRinging play:)
			(SetFlag 26) ; fPhoneRinging
		)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script)
			((< (gEgo y:) 125)
				(gCurRoom newRoom: 170)
			)
			((SteppedOn gEgo 2)
				(HandsOff)
				(gCurRoom setScript: sToStore)
			)
			((== (sfxPhoneRinging prevSignal:) 1)
				(switch ringInc
					(0
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 500 0 #time 3 #dispose #at -1 20) ; "Ring."
					)
					(1
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 500 1 #time 3 #dispose #at -1 20) ; "Ring ring."
					)
					(2
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 500 2 #time 3 #dispose #at -1 20) ; "Ring ring ring."
					)
					(3
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 500 3 #time 3 #dispose #at -1 20) ; "Ring ring ring ring."
					)
					(4
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 500 4 #time 4 #dispose #at -1 20) ; "How long are we going to do this before you answer the phone, Larry?!"
					)
				)
				(sfxPhoneRinging prevSignal: 0)
				(if (== ringInc 8)
					(= ringInc 4)
				else
					(++ ringInc)
				)
			)
		)
	)

	(method (dispose)
		(gTheMusic fade:)
		(super dispose:)
	)
)

(instance sFromStore of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 99 131 setMotion: MoveTo 82 138 self)
			)
			(1
				(gEgo setMotion: MoveTo 79 148 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sToStore of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 85 134 self)
			)
			(1
				(gEgo setMotion: PolyPath 118 130 self)
			)
			(2
				(gCurRoom newRoom: 510)
			)
		)
	)
)

(instance sBumBegs of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(cond
			((and (== state 1) (< (aBum distanceTo: gEgo) 45))
				(= cycles 1)
			)
			(
				(or
					(and (== state 4) (gEgo mover:))
					(== (gCurRoom script:) (ScriptID 813 1)) ; lRS
					(== (gEgo view:) 806)
				)
				(= state 7)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aBum setCycle: Walk setMotion: MoveTo 0 158 self)
			)
			(1
				(gTheMusic number: 120 setLoop: 1 flags: 1 play: 127)
				(aBum setCycle: Walk setMotion: MoveTo 160 158 self)
			)
			(2
				(Face gEgo aBum)
				(aBum setMotion: 0)
				(= cycles 1)
			)
			(3
				(= bumBegged 1)
				(aBum setMotion: 0 setLoop: 4 setCycle: End)
				(aBumHead cycleSpeed: (+ 3 gHowFast) setCycle: RandCycle 7 self)
			)
			(4
				(if (not (gCurRoom script:))
					(HandsOn)
				)
				(Print 500 5 #time 5) ; "Got any sshhpare change, buddy?"
				(= seconds 5)
			)
			(5
				(aBumHead setCycle: RandCycle 10 self)
			)
			(6
				(Print 500 6 #time 5) ; "Well, ok. Ya got any sshhpare wine, then?"
				(= seconds 5)
			)
			(7
				(aBum setLoop: 4 setCycle: Beg)
				(aBumHead setCycle: RandCycle 10 self)
			)
			(8
				(Print 500 7 #time 5) ; "Al'right. Be that way!"
				(= seconds 5)
			)
			(9
				(aBum setScript: sBumLeaves)
			)
		)
	)
)

(instance sGetKnife of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (== (aBum loop:) 1) (gEgo has: 11)) ; pocketKnife
					(Print 500 8) ; "He's headed for that dark alley, Larry maybe you should just catch him next time."
					(self dispose:)
				)
				(= cycles 1)
			)
			(1
				(HandsOff)
				(cond
					((<= (gEgo x:) (aBum x:))
						(= bumLoop 1)
						(aBum view: 502 setMotion: 0 setLoop: 1)
					)
					((> (gEgo x:) (aBum x:))
						(aBum view: 502 setMotion: 0 setLoop: 0)
					)
				)
				(if (> (aBum distanceTo: gEgo) 45)
					(if (<= (gEgo x:) (aBum x:))
						(gEgo
							setMotion: PolyPath (- (aBum x:) 45) (aBum y:) self
						)
					else
						(gEgo
							setMotion: PolyPath (+ (aBum x:) 45) (aBum y:) self
						)
					)
				else
					(= cycles 1)
				)
			)
			(2
				(Face gEgo aBum)
				(= cycles 3)
			)
			(3
				(gEgo put: 12) ; wine
				(aBum
					setLoop: (+ 4 (mod (aBum loop:) 2))
					setCel: 0
					setCycle: End self
				)
			)
			(4
				(aBum setLoop: (+ 6 (mod (aBum loop:) 2)) setCycle: End self)
			)
			(5
				(sfxGlug play: self)
				(Print 500 9 #at -1 20 #dispose) ; "Glug, glug, glug, glug, glug, glug, glug, etc."
				(aBum
					setLoop: (+ 8 (mod (aBum loop:) 2))
					setCycle: ForwardCounter
				)
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(aBum
					setLoop: (+ 6 (mod (aBum loop:) 2))
					setCel: 3
					setCycle: Beg self
				)
			)
			(7
				(aBum setLoop: bumLoop)
				(= cycles 1)
			)
			(8
				(aBum setLoop: (+ 4 (mod (aBum loop:) 2)) setCel: 0)
				(= cycles 1)
			)
			(9
				(aBumHead
					cycleSpeed: (+ 4 gHowFast)
					setCycle: RandCycle 20 self
				)
			)
			(10
				(Print 500 10) ; "I ain't got no remote control, but, sssshay, I'll tell ya what: here'ssh my trussshty ol' pocket knife. Ya never know! There are sssshome kinky girlssh in this town. Sssshexy hunkssh like ussh might have to defend oursshelves sometime!"
				(= cycles 1)
			)
			(11
				(aBum setCycle: Beg self)
			)
			(12
				(gEgo get: 11) ; pocketKnife
				(Points 68 5)
				(Print 500 11) ; "With that, he "sssshtumbles" off into the darkness."
				(= cycles 1)
			)
			(13
				(if (not (gCurRoom script:))
					(HandsOn)
				)
				(aBum setScript: sBumLeaves)
			)
		)
	)
)

(instance sBumInteraction of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (== (aBum loop:) 1) (gEgo has: 11)) ; pocketKnife
					(Print 500 12) ; "He's headed for that dark alley, Larry maybe you should just catch him next time."
					(self dispose:)
				)
				(= cycles 1)
			)
			(1
				(HandsOff)
				(aBum setMotion: 0)
				(if (> (aBum distanceTo: gEgo) 45)
					(if (<= (gEgo x:) (aBum x:))
						(gEgo
							setMotion: PolyPath (- (aBum x:) 45) (aBum y:) self
						)
					else
						(gEgo
							setMotion: PolyPath (+ (aBum x:) 45) (aBum y:) self
						)
					)
				else
					(= cycles 1)
				)
			)
			(2
				(aBum
					setLoop: (+ 4 (mod (aBum loop:) 2))
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(if (== bumVerb 1)
					(switch register
						(11
							(Print 500 13) ; "Cheezzzz! This guy could make that dog smell refreshing!"
						)
						(3
							(Print 500 14) ; "You search the bum diligently and find nothing but a strong aroma, which you allow him to keep!"
						)
					)
				)
				(self cue:)
			)
			(4
				(if (== bumObj 1)
					(switch register
						(4
							(Print 500 15) ; "Here ya go, pal. Take my diamond ring! A guy like me doesn't need commitment!"
						)
						(6
							(Print 500 16) ; ""I got this from a fella that reminds me of you," you say to the bum."
						)
						(7
							(Print 500 17) ; ""Peace, baby!" you say, handing the flower to the bum."
						)
						(9
							(Print 500 18) ; ""Want a piece?" you say."
						)
						(13
							(Print 500 19) ; "Have you seen the kind of filth they're selling inside this conveniece store!" you state, indignantly. "Why, it's an outrage!"
						)
						(15
							(Print 500 20) ; "Take this bottle of pills," you tell the bum. "I'm sure I'll have no use for any aphrodisiacs this evening. After all, I only hung on the side of a fire escape dangling from a velveteen ribbon to get these babies!"
						)
						(5
							(Print 500 21) ; "Here take a swig of this gramps."
						)
					)
				)
				(self cue:)
			)
			(5
				(if (OneOf register 3 5 10 11 6 7 9 13 15 4 5)
					(aBum setLoop: (+ 4 (mod (aBum loop:) 2)) setCycle: Beg)
					(aBumHead
						init:
						cycleSpeed: (+ 3 gHowFast)
						setCycle: RandCycle 15 self
					)
				else
					(self cue:)
				)
			)
			(6
				(if (== bumVerb 1)
					(switch register
						(3
							(Print 500 22) ; "Ssshay, buddy," grins the bum, "I kinda enjoyed that!"
						)
						(5
							(Print 500 23) ; "Howsha 'bout a drink, Shonney?"
						)
						(10
							(Print 500 24) ; "HEY! I may be down, but I ain't THAT out!"
						)
					)
				)
				(self cue:)
			)
			(7
				(if (== bumObj 1)
					(switch register
						(6
							(gEgo put: 6) ; remoteControl
							(Print 500 25) ; "Hey, thankshh, Misshter. Now I can go visshit that hooker!"
						)
						(7
							(gEgo put: 7) ; rose
							(Print 500 26) ; ""Make love, not war!" he replies, pocketing your rose."
						)
						(9
							(gEgo put: 9) ; candy
							(Print 500 27) ; ""I'm trying to cut back," the bum replies."
						)
						(13
							(gEgo put: 13) ; magazine
							(Print 500 28) ; "Yeah. I'll give it further ssshtudy back at my placessh."
						)
						(15
							(gEgo put: 15) ; pills
							(Print 500 29) ; "Thanks. How droll."
						)
						(4
							(gEgo put: 4) ; ring
							(Print 500 30) ; "Thankshh. Does thissh mean we're engashhged?"
						)
						(5
							(gEgo put: 5) ; whiskey
							(Print 500 31) ; "Burp. Thanks, I needed that! See ya 'round!!"
						)
					)
				)
				(self cue:)
			)
			(8
				(= bumVerb 0)
				(= bumObj 0)
				(aBum setScript: sBumLeaves)
			)
		)
	)
)

(instance sBumLeaves of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (== state 2) (!= aBumThreat 1) (aBum isBlocked: 1))
			(= aBumThreat 1)
			(Print 500 32) ; "Outta my way shhonney, I know marssshhal artshhh!"
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(if (not (gCurRoom script:))
					(HandsOn)
				)
				(= seconds 1)
			)
			(1
				1
				(if (and (OneOf (aBum loop:) 4 5) (!= (aBum cel:) 0))
					(aBum setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(2
				2
				(aBum
					setLoop: 1
					setCycle: Walk
					setMotion: PolyPath -28 155 self
				)
			)
			(3
				3
				(HandsOn)
				(aBum dispose:)
				(gTheMusic fade:)
				(self dispose:)
			)
		)
	)
)

(instance sHot_Bothered of Script
	(properties
		name {sHot&Bothered}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(gEgo
					egoSpeed: (* 4 gLarrySpeed)
					view: 501
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(gEgo setLoop: 2 setCycle: ForwardCounter 10 self)
			)
			(3
				(gEgo view: 501 setLoop: 0 setCel: 5 setCycle: CT 2 1 self)
			)
			(4
				(sfxHangUpHere play:)
				(gEgo setCycle: Beg self)
			)
			(5
				(Print 500 33 #at -1 20) ; "You hang up the telephone and wipe the sweat from your hands!"
				(HandsOn)
				(ClearFlag 19) ; fLarryPanting
				(gEgo normal: 1)
				(NormalEgo 0)
				(self dispose:)
			)
		)
	)
)

(instance sFromTelephone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(gEgo moveHead: 0)
				(gEgo
					egoSpeed: (* 3 gLarrySpeed)
					view: 501
					setLoop: 0
					setCel: 5
					setCycle: CT 2 -1 self
				)
			)
			(2
				(sfxHangUpHere play:)
				(gEgo setCycle: Beg self)
			)
			(3
				(HandsOn)
				(gEgo normal: 1)
				(NormalEgo 0)
				(self dispose:)
			)
		)
	)
)

(instance sToTelephone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(gEgo moveHead: 0)
				(gEgo
					egoSpeed: (* 3 gLarrySpeed)
					view: 501
					setLoop: 0
					setCel: 0
					setCycle: CT 2 1 self
				)
			)
			(2
				(if (IsFlag 26) ; fPhoneRinging
					(sfxPhoneRinging stop:)
				)
				(sfxHangUpHere play:)
				(gEgo setCycle: End self)
			)
			(3
				(if (IsFlag 26) ; fPhoneRinging
					(Points 48 5)
				)
				(gCurRoom newRoom: 505)
			)
		)
	)
)

(instance sfxGlug of Sound
	(properties
		flags 1
		number 111
	)
)

(instance sfxHangUpHere of Sound
	(properties
		flags 1
		number 507
	)
)

(instance fEntryLights of Feature
	(properties
		x 48
		y 69
		nsTop 62
		nsLeft 31
		nsBottom 77
		nsRight 66
		description {the lights}
		sightAngle 40
		lookStr {The lights above the doorway illuminate the entrance to the Quiki-Mart store.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance darkAlley of Feature
	(properties
		x 31
		y 68
		nsTop -1
		nsBottom 138
		nsRight 63
		description {the dark alley}
		sightAngle 40
		lookStr {You're not sure, but you think you hear cries of "Help" coming from that dark alley over there.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(Print 500 34) ; "Hello!" you cry into the darkness, "is there anybody back there?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance street of Feature
	(properties
		x 159
		y 175
		nsTop 161
		nsBottom 189
		nsRight 319
		description {the street}
		sightAngle 40
		lookStr {When you look hard enough, you think you can just barely make out the outline of a car speeding toward you.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fWindow of Feature
	(properties
		x 159
		y 79
		nsTop 50
		nsLeft 98
		nsBottom 108
		nsRight 220
		description {the window}
		sightAngle 40
		approachX 170
		approachY 120
		lookStr {This window looks perfectly rectangular -- to you!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 500 35) ; "It does feel like glass."
			)
			(5 ; Talk
				(Print 500 36) ; "They could hear you better if you went inside the store."
			)
			(4 ; Inventory
				(switch invItem
					(4 ; ring
						(Print 500 37) ; "You swipe the diamond ring across the Quiki-Mart window, leaving a giant scratch in the glass. You hope you were not observed!"
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fSign of Feature
	(properties
		x 130
		y 146
		z 125
		nsTop -1
		nsLeft 22
		nsBottom 44
		nsRight 239
		description {the sign}
		sightAngle 40
		lookStr {This sign indicates you are currently in front of the lovely Lost Wages Quiki-Mart.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 500 38) ; "That sign is too high for you to reach."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fTelephone of Feature
	(properties
		x 186
		y 150
		z 39
		nsTop 87
		nsLeft 178
		nsBottom 135
		nsRight 194
		description {the telephone}
		sightAngle 40
		approachX 172
		approachY 150
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Points 86 1)
				(Print 500 39) ; "There are some numbers scribbled on the side of the telephone. The only thing legible (and printable) is: "555-6969.""
			)
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: sToTelephone)
			)
			(5 ; Talk
				(self doVerb: 3)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; wallet
						(self doVerb: 3)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fLight of Feature
	(properties
		x 171
		y 154
		z 107
		nsTop 40
		nsLeft 163
		nsBottom 55
		nsRight 180
		description {the light}
		sightAngle 40
		lookStr {The street light casts its yellow glow across the area, thoughtfully illuminating the many pieces of trash that line this thoroughfare.}
	)
)

(instance fArtGallery of Feature
	(properties
		x 286
		y 89
		nsTop 47
		nsLeft 254
		nsBottom 131
		nsRight 319
		description {the art gallery}
		sightAngle 40
		lookStr {The Lost Wages Art Emporium will satisfy your every need for modern art, as long as you're looking for something with dead fish!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 500 40) ; "The locked gate effectively prevents you from any cultural enlightenment by entering the Art Gallery."
			)
			(5 ; Talk
				(Print 500 41) ; "You have no wish to talk to a bunch of paintings."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance aBumHead of Prop
	(properties
		z 1000
		description {the bum}
		lookStr {The bum looks like a man that could (ab)use a drink.}
		view 502
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(aBum doVerb: theVerb invItem)
	)

	(method (doit)
		(super doit:)
		(if (OneOf (aBum loop:) 4 5)
			(aBumHead z: 22)
		else
			(aBumHead z: 1000)
		)
		(cond
			((== (aBum loop:) 4)
				(aBumHead loop: 2 x: (+ (aBum x:) 10) y: (aBum y:))
			)
			((== (aBum loop:) 5)
				(aBumHead loop: 3 x: (- (aBum x:) 10) y: (aBum y:))
			)
		)
	)
)

(instance aBum of Person
	(properties
		x -60
		y 154
		description {the bum}
		lookStr {The bum looks like a man that could (ab)use a drink.}
		yStep 1
		view 502
		xStep 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(= bumVerb 1)
				(aBum setScript: sBumInteraction 0 theVerb)
			)
			(5 ; Talk
				(= bumVerb 1)
				(aBum setScript: sBumInteraction 0 theVerb)
			)
			(10 ; Zipper
				(= bumVerb 1)
				(aBum setScript: sBumInteraction 0 theVerb)
			)
			(11 ; Taste/Smell
				(= bumVerb 1)
				(aBum setScript: sBumInteraction 0 theVerb)
			)
			(4 ; Inventory
				(= bumObj 1)
				(switch invItem
					(12 ; wine
						(aBum setScript: sGetKnife)
					)
					(5 ; whiskey
						(aBum setScript: sBumInteraction 0 invItem)
					)
					(0 ; wallet
						(Print 500 42) ; "You fish a dollar out of your wallet and hand it to the bum. "Gossshhh thanssskks, buddy," he says sarcastically. "With all thisssh money, maybe I can finally invessst in sssome sssmall company, growth mutual fundsssh!""
						(-= gLarryDollars 1)
					)
					(1 ; breathSpray
						(Print 500 43) ; "Although the bum IS in need of an industrial-strength deodorant, your breath spray doesn't have enough horsepower to kill that aroma!"
					)
					(2 ; watch
						(Print 500 44) ; ""Say, would you like a watch?" you yell to the bum."
						(Print 500 45) ; "No," he responds, "would you like TO watch?"
					)
					(3 ; apple
						(Print 500 46) ; ""An apple a day keeps the doctor away!" you pontificate."
						(Print 500 47) ; ""A gallon a day keeps the pink elephants away," he mutters."
					)
					(4 ; ring
						(aBum setScript: sBumInteraction 0 invItem)
					)
					(6 ; remoteControl
						(aBum setScript: sBumInteraction 0 invItem)
					)
					(7 ; rose
						(aBum setScript: sBumInteraction 0 invItem)
					)
					(8 ; lubber
						(Print 500 48) ; "No, Larry. You'd better keep that for yourself."
					)
					(9 ; candy
						(aBum setScript: sBumInteraction 0 invItem)
					)
					(13 ; magazine
						(aBum setScript: sBumInteraction 0 invItem)
					)
					(15 ; pills
						(aBum setScript: sBumInteraction 0 invItem)
					)
					(else
						(if 1
							(= global314
								(Memory
									memALLOC_CRIT
									(StrLen ((Inv at: invItem) description:))
								)
							)
							(= global323
								(Memory
									memALLOC_CRIT
									(StrLen ((Inv at: invItem) description:))
								)
							)
							(StrSplitInTwo
								global314
								global323
								((Inv at: invItem) description:)
							)
							(Printf 500 49 global314 global323) ; "That bum has no need for %s."
							(Memory memFREE global314)
							(Memory memFREE global323)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sfxPhoneRinging of Sound
	(properties
		flags 1
		number 504
		loop -1
	)
)

(instance aBumPoly of Polygon
	(properties
		type PBarredAccess
	)
)

