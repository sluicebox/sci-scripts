;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use Teller)
(use n814)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm300 0
	sheriffTalker 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	[local7 2]
	local9
	[local10 8] = [0 16 -22 -15 -8 -6 -17 999]
	[local18 6] = [0 7 13 12 11 999]
	[local24 3] = [0 -24 999]
	[local27 3] = [0 11 999]
	[local30 4] = [0 -14 -23 999]
	[local34 3] = [0 12 999]
	[local37 3] = [0 10 999]
	[local40 4] = [0 7 -24 999]
	[local44 3] = [0 -18 999]
	[local47 3] = [0 19 999]
	[local50 13]
	[local63 12] = [0 -22 -15 -24 -8 -14 -23 -6 -24 -17 -18 999]
)

(procedure (localproc_0)
	(if (< gTimeOfDay 4)
		(gMessager say: 12 0 2) ; "This seems like a quiet little town. On the porch ahead of you are two people. The standing one is large, rather ugly, and playing with a yo-yo. The seated person smoking a pipe looks like he might be the Sheriff."
	else
		(gMessager say: 12 0 1) ; "Spielburg remains colorful, even at night."
	)
)

(instance rm300 of Rm
	(properties
		noun 12
		picture 300
		style 8
	)

	(method (dispose)
		(= global451 0)
		(SetFlag 88)
		(= gUseSortedFeatures local5)
		(super dispose:)
	)

	(method (init)
		(= [local50 0] @local10)
		(= [local50 1] @local18)
		(= [local50 2] @local24)
		(= [local50 3] @local27)
		(= [local50 4] @local30)
		(= [local50 5] @local34)
		(= [local50 6] @local37)
		(= [local50 7] @local40)
		(= [local50 8] @local27)
		(= [local50 9] @local44)
		(= [local50 10] @local47)
		(= [local50 11] 999)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 282 189 316 148 316 93 288 93 282 107 265 105 251 110 258 120 225 143 185 149 164 145 147 151 123 152 106 149 89 149 66 144 52 133 0 133
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 162 35 177 200 177 200 189 0 189
					yourself:
				)
		)
		(LoadMany rsVIEW 300 515 606 517)
		(gEgo
			illegalBits: (if (< gTimeOfDay 4) -16384 else -32768)
			ignoreControl: -32768
			init:
		)
		(super init: &rest)
		(= local5 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(self
			setFeatures:
				onBarberNote
				onInnSign
				tubOSuds
				onJailSign
				sheriffsDoor
				statue1
				statue2
				innWindow
				jailCell
				jailWindow
				onScissors
		)
		(gLongSong fade:)
		(self setRegions: 811 801) ; Street, Town
		(if (or (not gNight) (and (== gPrevRoomNum 65) (IsFlag 293)))
			(openedGate init: stopUpd:)
		else
			(closedGate init: stopUpd:)
		)
		(= gPerspective 70)
		(= local2 1)
		(if (not (IsFlag 88))
			(= gDay 0)
			(FixTime 11)
			(SetFlag 328)
		)
		(gTheIconBar enable:)
		(NormalEgo)
		(if (< gTimeOfDay 4)
			(sheriffTeller init: sheriff @local10 @local50 @local63)
			(sheriff init: actions: sheriffTeller)
			(yoyo init:)
			(otto init:)
			(= local9 1)
		else
			(= local9 0)
		)
		(innDoor cycleSpeed: 6 ignoreActors: init: stopUpd:)
		(switch gPrevRoomNum
			(301
				(innDoor setScript: closeInnDoor)
			)
			(310
				(gCurRoom setScript: enterFrom310)
			)
			(320
				(gEgo posn: 305 113 setMotion: MoveTo 305 125)
			)
			(999
				(gEgo
					init:
					view: 515
					setLoop: 3
					setCel: 5
					setScript: egoWakes
				)
			)
			(73
				(gEgo init: setCel: 0 posn: 26 163 setMotion: MoveTo 55 154)
			)
			(else
				(HandsOff)
				(gEgo posn: 256 235)
				(gCurRoom setScript: sEnter)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(not local0)
				(> (gEgo x:) 0)
				(< (gEgo y:) 189)
				(> (gEgo y:) 124)
			)
			(= local0 1)
		)
		(cond
			(script)
			((and (< (gEgo x:) 7) local0)
				(self style: 11)
				(gCurRoom setScript: enter310)
			)
			((and local0 (== (gEgo onControl: 1) 128))
				(= local0 0)
				(gCurRoom setScript: enter320)
			)
			((== (gEgo edgeHit:) 3)
				(cond
					((IsObject openedGate)
						(HandsOff)
						(gCurRoom setScript: sExitTown)
					)
					((== (gCurRoom script:) climbOut)
						(climbOut changeState: 2)
					)
				)
			)
		)
	)
)

(instance openedGate of View
	(properties
		x 127
		y 189
		noun 10
		view 300
		loop 1
		cel 1
		priority 15
		signal 16400
	)
)

(instance closedGate of View
	(properties
		x 242
		y 189
		noun 1
		view 300
		loop 1
		priority 14
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((not [gEgoStats 11]) ; climbing
						(gMessager say: 1 4 0 1) ; "Leave the climbing to those who know how."
					)
					((<= (Random 3 10) (++ local3))
						(gMessager say: 1 4 0 2) ; "You'd better not try to climb the wall any more right now. You've been at this long enough that someone is likely to notice."
						(= local3 10)
					)
					((TrySkill 11 35 0) ; climbing
						(gCurRoom setScript: climbOut)
					)
					(else
						(gMessager say: 1 4 0 3) ; "The wall is too smooth to climb with your level of skill, but keep practicing."
					)
				)
			)
			(18 ; thiefKit
				(gMessager say: 1 17) ; "The gate is securely barred. There's no lock for you to open."
			)
			(17 ; lockPick
				(gMessager say: 1 17) ; "The gate is securely barred. There's no lock for you to open."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sheriff of Actor
	(properties
		x 159
		y 120
		noun 14
		view 300
		loop 3
		priority 1
		signal 16
		illegalBits 0
	)

	(method (init)
		(if (== gHowFast 0)
			(smoke addToPic:)
			(puff addToPic:)
		else
			(= local6 0)
			(smoke init: cycleSpeed: 9 setCycle: Fwd ignoreActors: stopUpd:)
			(puff init: ignoreActors: hide:)
			(self setScript: sheriffScript)
		)
		(super init:)
	)
)

(instance sheriffTeller of Teller
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(Face gEgo sheriff)
				(gMessager say: 14 1) ; "Schultz appears to be an affable old coot, content to smoke his pipe. There's a hardness behind his eyes, however, that gives you reason to believe that he's no pushover."
			)
			(4 ; Do
				(gMessager say: 14 4) ; "Unhand that sheriff!"
			)
			(2 ; Talk
				(SolvePuzzle 718 1)
				(super doVerb: theVerb)
			)
			(18 ; thiefKit
				(EgoDead 160 161) ; "They say that the cops don't catch any rocket scientists. Well, they sure didn't this time!"
			)
			(17 ; lockPick
				(EgoDead 160 161) ; "They say that the cops don't catch any rocket scientists. Well, they sure didn't this time!"
			)
			(19 ; thiefLicense
				(EgoDead 160 161) ; "They say that the cops don't catch any rocket scientists. Well, they sure didn't this time!"
			)
			(43 ; musicBox
				(EgoDead 160 161) ; "They say that the cops don't catch any rocket scientists. Well, they sure didn't this time!"
			)
			(44 ; candleSticks
				(EgoDead 160 161) ; "They say that the cops don't catch any rocket scientists. Well, they sure didn't this time!"
			)
			(41 ; vase
				(EgoDead 160 161) ; "They say that the cops don't catch any rocket scientists. Well, they sure didn't this time!"
			)
			(42 ; candelabra
				(EgoDead 160 161) ; "They say that the cops don't catch any rocket scientists. Well, they sure didn't this time!"
			)
			(45 ; pearls
				(EgoDead 160 161) ; "They say that the cops don't catch any rocket scientists. Well, they sure didn't this time!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance otto of Actor
	(properties
		x 211
		y 105
		noun 11
		view 606
		loop 1
		cycleSpeed 5
	)

	(method (init)
		(self setScript: yoyoLow)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 14 4) ; "Unhand that sheriff!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance yoyo of Actor
	(properties
		x 187
		y 103
		noun 18
		view 606
		loop 3
		priority 9
		signal 26640
		cycleSpeed 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(82 ; fetchSpell
				(gMessager say: 18 20) ; "Are you crazy? That goon would rend your spleen asunder if you did anything to his yoyo!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sheriffsDoor of Feature
	(properties
		x 169
		y 99
		z 29
		noun 13
		nsTop 48
		nsLeft 154
		nsBottom 93
		nsRight 184
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (< gTimeOfDay 4)
					(gMessager say: 13 4 2) ; "The door appears to be locked, and breaking into the Sheriff's office might evoke the wrath of Otto von Goon."
				else
					(gMessager say: 13 4 1) ; "You'd better not. The Goon would probably clobber you with his yo-yo if he thought you were going into the Sheriff's office without permission."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance innWindow of Feature
	(properties
		x 61
		y 75
		noun 3
		nsTop 62
		nsLeft 48
		nsBottom 89
		nsRight 74
		sightAngle 40
	)
)

(instance jailCell of Feature
	(properties
		x 92
		y 25
		noun 4
		nsTop 8
		nsLeft 83
		nsBottom 43
		nsRight 101
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(Face gEgo self)
				(gMessager say: 4 1) ; "It's an empty jail cell. Fortunately, you're on the outside (at the moment)."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance jailWindow of Feature
	(properties
		x 208
		y 61
		noun 5
		nsTop 45
		nsLeft 196
		nsBottom 77
		nsRight 220
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(Face gEgo self)
				(gMessager say: 5 1) ; "This must be some tough town when they put bars on the jailhouse window."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance statue1 of Feature
	(properties
		x 129
		y 143
		z 47
		noun 15
		nsTop 79
		nsLeft 118
		nsBottom 114
		nsRight 141
		sightAngle 40
	)
)

(instance statue2 of Feature
	(properties
		x 238
		y 121
		z 38
		noun 16
		nsTop 72
		nsLeft 229
		nsBottom 94
		nsRight 247
		sightAngle 40
	)
)

(instance onBarberNote of Feature
	(properties
		x 255
		y 70
		noun 6
		nsTop 45
		nsLeft 240
		nsBottom 95
		nsRight 270
		approachX 269
		approachY 90
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(Face gEgo self)
				(gMessager say: 6 1 2) ; "There's a sign on the door of the barber shop. It says "Out to lunch.""
				(if (> gTimeOfDay 4)
					(gMessager say: 6 1 1) ; "The sign says "Out to lunch." The barber must keep odd lunch hours."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance onJailSign of Feature
	(properties
		x 207
		y 15
		noun 8
		nsTop 4
		nsLeft 196
		nsBottom 26
		nsRight 218
	)
)

(instance onScissors of Feature
	(properties
		x 261
		y 26
		noun 9
		nsTop 17
		nsLeft 248
		nsBottom 34
		nsRight 275
	)
)

(instance onInnSign of Feature
	(properties
		x 18
		y 32
		noun 7
		nsTop 16
		nsLeft 1
		nsBottom 48
		nsRight 36
	)
)

(instance tubOSuds of Feature
	(properties
		x 102
		y 133
		noun 17
		nsTop 122
		nsLeft 83
		nsBottom 143
		nsRight 121
	)
)

(instance doorSlam of Sound
	(properties
		number 84
	)
)

(instance doorSound of Sound
	(properties
		number 89
	)
)

(instance yoyoSound of Sound
	(properties
		number 119
		loop -1
	)
)

(instance innDoor of Prop
	(properties
		x 36
		y 125
		noun 2
		approachX 36
		approachY 135
		view 300
		priority 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(Face gEgo self)
				(gMessager say: 2 1 2) ; "The windows glow from the light inside. The sign reads "Hero's Tale Inn"."
			)
			(4 ; Do
				(gCurRoom setScript: enter301)
			)
			(17 ; lockPick
				(if (== local9 1)
					(EgoDead 160 161) ; "They say that the cops don't catch any rocket scientists. Well, they sure didn't this time!"
				else
					(gCurRoom setScript: enter301)
				)
			)
			(18 ; thiefKit
				(if (== local9 1)
					(EgoDead 160 161) ; "They say that the cops don't catch any rocket scientists. Well, they sure didn't this time!"
				else
					(gCurRoom setScript: enter301)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance smoke of Prop
	(properties
		x 170
		y 96
		view 300
		loop 5
		priority 9
		signal 16400
		cycleSpeed 9
	)
)

(instance puff of Prop
	(properties
		x 158
		y 85
		view 300
		loop 7
		priority 9
		signal 16400
		cycleSpeed 12
	)
)

(instance egoWakes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setCycle: Beg self)
			)
			(1
				(NormalEgo)
				(gMessager say: 12 0 5 1 self) ; "However, this was not a good place to sleep. You're stiff and sore all over, and your wallet feels very light."
				((gInventory at: 38) amount: 0) ; gold
				((gInventory at: 0) amount: 0) ; silver
				(HandsOn)
			)
			(2
				(gMessager say: 12 0 5 2 self) ; "As safe as our streets are, you still should not sleep on them. It is a good way to get robbed."
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and gNight (not (IsFlag 293)))
					(gCurRoom setScript: climbIn)
				else
					(self cue:)
				)
			)
			(1
				(SolvePuzzle 717 1)
				(gEgo setMotion: MoveTo 237 181 self)
			)
			(2
				(gEgo setHeading: 45)
				(= ticks 90)
			)
			(3
				(gEgo setHeading: 270)
				(= ticks 90)
			)
			(4
				(gEgo setHeading: 315)
				(= ticks 30)
			)
			(5
				(if (== gPrevRoomNum 65)
					(HandsOn)
					(self dispose:)
				else
					(localproc_0)
					(= ticks 5)
				)
			)
			(6
				(gEgo setMotion: MoveTo 187 167 self)
			)
			(7
				(gEgo setHeading: 0 self)
			)
			(8
				(gMessager say: 12 0 4 0 self) ; "The man with the pipe greets you."
			)
			(9
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sExitTown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 252 240 self)
			)
			(1
				(HandsOn)
				(gCurRoom newRoom: 65)
			)
		)
	)
)

(instance closeInnDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(doorSound play:)
				(innDoor setCycle: End self)
			)
			(1
				(gEgo loop: 2 posn: 22 127 setMotion: MoveTo 25 135 self)
			)
			(2
				(innDoor setCycle: Beg self)
			)
			(3
				(doorSlam play:)
				(HandsOn)
				(innDoor stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance enter301 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 22 127 self)
			)
			(1
				(doorSound play:)
				(innDoor setCycle: End self)
			)
			(2
				(doorSound stop:)
				(gEgo setMotion: MoveTo 22 121 self)
			)
			(3
				(gCurRoom newRoom: 301)
			)
		)
	)
)

(instance sheriffScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local6)
					(smoke show: startUpd:)
					(= local6 1)
				)
				(= seconds (Random 3 12))
			)
			(1
				(smoke hide: stopUpd:)
				(sheriff startUpd: cycleSpeed: 6 cel: 1 setCycle: CT 5 1 self)
			)
			(2
				(sheriff setCycle: CT 9 1)
				(puff show: startUpd: cycleSpeed: 9 setCycle: End self)
			)
			(3
				(sheriff setCycle: End self)
			)
			(4
				(sheriff setCel: 0)
				(smoke show: setCycle: Fwd startUpd:)
				(puff hide: stopUpd:)
				(self changeState: 0)
			)
		)
	)
)

(instance yoyoLow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(yoyoSound number: 119 loop: -1 init: play:)
				(self cue:)
			)
			(1
				(++ local2)
				(otto setLoop: 0 cycleSpeed: 12 setCycle: Fwd)
				(yoyo setLoop: 4 posn: 187 103 cycleSpeed: 6 setCycle: Fwd)
				(= ticks 90)
			)
			(2
				(otto setCycle: Beg self)
			)
			(3
				(if (== (mod local2 5) 0)
					(client setScript: yoyoMiddle)
				else
					(self changeState: 1)
				)
			)
		)
	)
)

(instance yoyoMiddle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (/ local2 5))
				(++ local2)
				(otto loop: 1 cel: 0 cycleSpeed: 8 setCycle: Fwd)
				(yoyo setLoop: 4 posn: 191 82 setStep: 1 1 cycleSpeed: 4)
				(= ticks 90)
			)
			(1
				(otto setCycle: CT 1 1 self)
			)
			(2
				(if register
					(-- register)
					(self cue:)
				else
					(self changeState: 5)
				)
			)
			(3
				(yoyoSound pause: 1)
				(yoyo setLoop: 3 setMotion: MoveTo 191 70 self)
			)
			(4
				(yoyo setMotion: MoveTo 191 82 self)
			)
			(5
				(yoyoSound pause: 0)
				(if (<= register 0)
					(self cue:)
				else
					(self changeState: 2)
				)
			)
			(6
				(yoyo setLoop: 4)
				(otto setCycle: Fwd)
				(= ticks 120)
			)
			(7
				(if
					(or
						(< local2 16)
						(== (gCurRoom script:) sExitTown)
						(== (gCurRoom script:) enter310)
						(== (gCurRoom script:) enter301)
						(== (gCurRoom script:) enter320)
					)
					(client setScript: yoyoLow)
				else
					(client setScript: yoyoHigh)
				)
			)
		)
	)
)

(instance yoyoHigh of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2 1)
				(yoyo
					posn: 191 82
					setLoop: 4
					cycleSpeed: 2
					setStep: 12 12
					setCycle: Fwd
				)
				(otto setLoop: 1 cycleSpeed: 2 setCycle: Fwd)
				(= ticks 120)
			)
			(1
				(otto setLoop: 2 cel: 0)
				(yoyoSound number: 124 loop: 1 play:)
				(yoyo setLoop: 3 setMotion: MoveTo 196 88 self)
			)
			(2
				(otto cel: 1)
				(yoyo setStep: 8 8 posn: 196 77)
				(= ticks 1)
			)
			(3
				(otto setCycle: CT 3 1 self)
			)
			(4
				(yoyo setPri: 15 cycleSpeed: 1 setMotion: MoveTo 196 20 self)
			)
			(5
				(if
					(or
						(== (gCurRoom script:) sExitTown)
						(== (gCurRoom script:) enter310)
						(== (gCurRoom script:) enter301)
						(== (gCurRoom script:) enter320)
					)
					(self changeState: 10)
				else
					(HandsOff)
					(gEgo setMotion: 0)
					(yoyo setStep: 36 24)
					(= ticks 20)
				)
			)
			(6
				(otto setLoop: 1 setCel: 1)
				(if (<= (gEgo x:) 190)
					(yoyo
						setMotion: MoveTo (gEgo x:) (- (gEgo y:) 47) self
					)
				else
					(yoyo
						setMotion:
							MoveTo
							(- (gEgo x:) 6)
							(- (gEgo y:) 47)
							self
					)
				)
			)
			(7
				(yoyoSound number: 125 play:)
				(self cue:)
			)
			(8
				(HandsOn)
				(otto cycleSpeed: 6 setLoop: 2 setCel: 3)
				(if (<= (gEgo x:) 190)
					(yoyo setMotion: MoveTo (gEgo x:) 20 self)
				else
					(yoyo setMotion: MoveTo (- (gEgo x:) 6) 20 self)
				)
			)
			(9
				(yoyo setMotion: MoveTo 197 20 self)
			)
			(10
				(yoyo setStep: 8 8 setPri: 9 setMotion: MoveTo 197 88 self)
			)
			(11
				(otto setCycle: End)
				(yoyo setStep: 1 1 setPri: 9 setMotion: MoveTo 197 91 self)
			)
			(12
				(= ticks 30)
			)
			(13
				(client setScript: yoyoLow)
			)
		)
	)
)

(instance climbOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(HandsOff)
				(gEgo setPri: 12 setMotion: PolyPath 300 165 self)
			)
			(1
				1
				(if gEgoGait
					(gEgo ignoreActors: 1 setMotion: MoveTo 315 189 self)
				else
					(gEgo ignoreActors: 1 setMotion: MoveTo 300 202 self)
				)
			)
			(2
				2
				(if gEgoGait
					(self cue:)
				else
					(gEgo
						posn: (gEgo x:) (+ (gEgo y:) 3)
						setMotion: MoveTo 300 208 self
					)
				)
			)
			(3
				3
				(gEgo hide:)
				(= ticks 60)
			)
			(4
				4
				(gEgo
					view: 517
					setLoop: 8
					cel: 0
					setPri: 15
					show:
					posn: 261 179
					setCycle: End self
				)
			)
			(5
				5
				(= ticks 20)
			)
			(6
				6
				(gEgo
					setLoop: 1
					cel: 6
					priority: 15
					ignoreActors: 0
					setCycle: Beg self
				)
			)
			(7
				7
				(= ticks 5)
			)
			(8
				8
				(HandsOn)
				(gCurRoom newRoom: 65)
			)
		)
	)
)

(instance climbIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 517
					setLoop: 1
					cel: 0
					posn: 261 179
					setPri: 15
					show:
					setCycle: End self
				)
			)
			(1
				(= ticks 30)
			)
			(2
				(gEgo setLoop: 8 cel: 8 priority: 15 setCycle: Beg self)
			)
			(3
				(gEgo hide:)
				(self cue:)
			)
			(4
				(gEgo
					view: 0
					loop: 3
					cel: 0
					posn: 300 225
					priority: 12
					show:
					setCycle: Walk
					setMotion: MoveTo 300 165 self
				)
			)
			(5
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance enter310 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo -30 142 self)
			)
			(1
				(gCurRoom newRoom: 310)
			)
		)
	)
)

(instance enterFrom310 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo posn: -30 142 setMotion: MoveTo 32 148 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enter320 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (not (IsFlag 88)) (< gTimeOfDay 4))
					(gMessager say: 12 0 3 1 self) ; "Just a friendly suggestion, but whatever you do, don't drink the Dragon's Breath. Not even Otto can drink Dragon's Breath!"
				else
					(self cue:)
				)
			)
			(1
				(gCurRoom newRoom: 320)
			)
		)
	)
)

(instance sheriffTalker of Talker
	(properties
		x 15
		y 8
		view 1300
		talkWidth 260
		textX 13
		textY 110
	)

	(method (init)
		(= global451 2300)
		(PalVary pvCHANGE_TARGET 2300)
		(AssertPalette 1300)
		(= font gUserFont)
		(super init: sheriffBust sheriffEyes sheriffMouth &rest)
	)

	(method (show)
		(super show:)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance sheriffBust of Prop
	(properties
		view 1300
	)
)

(instance sheriffMouth of Prop
	(properties
		nsTop 42
		nsLeft 43
		view 1300
		loop 1
	)
)

(instance sheriffEyes of Prop
	(properties
		nsTop 35
		nsLeft 45
		view 1300
		loop 2
	)
)

