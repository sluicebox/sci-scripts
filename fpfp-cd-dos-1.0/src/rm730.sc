;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 730)
(include sci.sh)
(use Main)
(use eRS)
(use Scaler)
(use ROsc)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	rm730 0
)

(local
	local0
)

(instance rm730 of FPRoom
	(properties
		picture 730
	)

	(method (notify param1)
		(if param1
			(self setScript: sCutAndRun)
		else
			(self setScript: sFreddyTips)
		)
	)

	(method (init)
		(gEgo
			view: 730
			setLoop: 0
			x: 175
			y: 93
			init:
			setScale: Scaler 121 68 153 61
		)
		(Palette palSET_INTENSITY 0 256 0)
		(UnLoad 128 842)
		(super init:)
		(SetFlag 81)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 52 40 50 82 69 88 45 180 304 180 304 132 182 143 155 116 176 64 89 64 89 80 71 80 62 44 74 44 152 0 319 0 319 189 0 189 0 0 147 0 76 40
					yourself:
				)
		)
		(floor init:)
		(barrel init: setOnMeCheck: 1 2)
		(books init: setOnMeCheck: 1 4)
		(colBooks init: setOnMeCheck: 1 8)
		(colCrates init: setOnMeCheck: 1 16)
		(colMaps init: setOnMeCheck: 1 32)
		(crates init: setOnMeCheck: 1 64)
		(desks init: setOnMeCheck: 1 128)
		(jester init: setOnMeCheck: 1 512)
		(jug init: setOnMeCheck: 1 1024)
		(lamp init: setOnMeCheck: 1 2048)
		(map init: setOnMeCheck: 1 4096)
		(pitcher init: setOnMeCheck: 1 256)
		(oil init: setOnMeCheck: 1 8192)
		(toyChest init: setOnMeCheck: 1 16384)
		(drum init:)
		(jars init:)
		(piano init:)
		(smallShelf init:)
		(tallShelf init:)
		(pillar init:)
		(stairs init:)
		(penelope init: ignoreActors: stopUpd:)
		(lantern init: setPri: 10 stopUpd: ignoreActors:)
		(self setScript: sTauntFreddy)
	)
)

(instance sTauntFreddy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gGameMusic1 number: 733 loop: -1 play:)
				(proc0_15 0 2 self)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(gMessager say: 2 0 0 0 self) ; "Before I kill you, Mr. Gunslingin' Stranger Hero-type, let's find out who you REALLY are behind that silver ear!"
			)
			(4
				(penelope setMotion: PolyPath 136 95 self)
			)
			(5
				(gEgo view: 733 loop: 0 cel: 0 setCycle: End self)
				(penelope hide:)
				(gEgo put: 52) ; Silver_Ear
			)
			(6
				(UnLoad 128 733)
				(gEgo view: 730 loop: 2 cel: 0 setCycle: End self)
				(penelope posn: 136 100 show:)
				(ear
					init:
					setScale: -1 gEgo
					setLoop: 2
					setStep: 10 10
					scaleSignal: 5
					setCycle: Fwd
					setMotion: MoveTo 79 110 self
				)
				(localSound number: 2731 loop: 1 play:)
			)
			(7 0)
			(8
				(gEgo stopUpd:)
				(ear setCycle: 0 stopUpd:)
				(= cycles 3)
			)
			(9
				(gGameMusic1 pause: 1)
				(localSound number: 2701 loop: 1 play: self)
				(gMessager say: 1 0 0 1 5 self) ; "FREDDY! You?!"
			)
			(10
				(gGameMusic1 pause: 0)
			)
			(11
				(penelope setMotion: PolyPath 82 100 self)
			)
			(12
				(Face penelope gEgo)
				(= cycles 3)
			)
			(13
				(penelope stopUpd:)
				(= cycles 100)
			)
			(14
				(gMessager say: 1 0 0 6 self) ; "I wrote a letter of inquiry and was offered the position by the Coarsegold Board of Education. They even sent me stagecoach fare! Soon after my arrival (which you saw in the Prologue, I believe), I noticed the oily swamp behind the schoolhouse. Being a good Pennsylvania oil country girl, I grasped immediately that Coarsegold was literally oozing money!"
			)
			(15
				(penelope setMotion: PolyPath 64 88 self)
			)
			(16
				(Face penelope gEgo)
				(= cycles 3)
			)
			(17
				(penelope stopUpd:)
				(= cycles 100)
			)
			(18
				(gMessager say: 1 0 0 7 self) ; "But I could never afford to buy mineral rights on the meager pittance they pay a single unwed female teacher, so I made a little arrangement with Mr. Balance. He foreclosed whichever mortgages he could, and convinced Sheriff Shift to shut down everyone else. Balance would get the land and buildings for a song and give me the mineral rights |c2|I|c| wanted, as long as I gave him what |c2|he|c| wanted!"
			)
			(19
				(penelope setMotion: PolyPath 64 60 self)
			)
			(20
				(penelope stopUpd:)
				(= cycles 20)
			)
			(21
				(gMessager say: 1 0 0 8 self) ; "But Penelope! You seemed to be such a sweet, innocent young woman. How could you be such a SLEAZEBAG?"
			)
			(22
				(penelope setMotion: PolyPath 69 39 self)
			)
			(23
				(gMessager say: 3 0 0 1 4 self) ; "It HAD to be me, Freddy. Don't you see? It's ALWAYS the person you LEAST SUSPECT."
				(LoadMany rsVIEW 737)
			)
			(24
				(Face penelope gEgo)
				(= cycles 3)
			)
			(25
				(penelope stopUpd:)
				(= cycles 100)
			)
			(26
				(penelope view: 734 setCycle: 0 setLoop: 0 cel: 0 x: 72 y: 46)
				(= seconds 3)
			)
			(27
				(gMessager say: 3 0 0 5 7 self) ; "Well, if it's YOU, then I'm doing the town a favor by disposing of you, aren't I? (SNICKER)"
			)
			(28
				(= cycles 100)
			)
			(29
				(penelope setCycle: CT 4 1 self)
			)
			(30
				(penelope setCycle: End)
				(lantern setCycle: End self)
			)
			(31
				(glassSound play:)
				(lantern dispose:)
				(= cycles 3)
			)
			(32
				(gGameMusic1 number: 732 loop: -1 play:)
				(= cycles 3)
			)
			(33
				(fire1 init: setCycle: RandCycle)
				(= cycles 3)
			)
			(34
				(gMessager say: 4 0 0 1 self) ; "Oh, well. Coarsegold won't be needing a schoolhouse anyway!"
			)
			(35
				(fire2 init: hide:)
				(fireTimer setReal: fire1 13)
				(penelope
					ignoreHorizon:
					view: 802
					setCycle: StopWalk -1
					setMotion: MoveTo 149 -2 self
				)
			)
			(36
				(gMessager say: 4 0 0 2 self) ; "Wait! There were a lot of other people I didn't suspect!"
				(UnLoad 128 802)
				(UnLoad 128 734)
			)
			(37
				(gEgo setCycle: End self)
			)
			(38
				(UnLoad 128 730)
				(gEgo view: 731 setLoop: 0 cel: 3)
				(= seconds 1)
				(gEgo setSpeed: 6)
			)
			(39
				(gTheIconBar enable: 2 1)
				(gTheIconBar curIcon: (gTheIconBar at: 2))
				(gGame setCursor: 2)
				(gUser canControl: 0)
				(gUser input: 1)
				(self dispose:)
			)
		)
	)
)

(instance sFreddyTips of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(if (== ((gEgo cycler:) cycleDir:) 1)
					(gEgo setCycle: End self)
				else
					(gEgo setCycle: Beg self)
				)
			)
			(2
				(if (< (gEgo cel:) 3)
					(gEgo setCycle: CT 3 1 self)
				else
					(gEgo setCycle: CT 3 -1 self)
				)
			)
			(3
				(gEgo view: 731 loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(= local0 1)
				(gEgo signal: (| (gEgo signal:) $1000))
				(gTheIconBar enable: 2 1)
				(gGame setCursor: 2)
				(gTheIconBar curIcon: (gTheIconBar at: 2))
				(gUser canControl: 0)
				(gUser input: 1)
				(self dispose:)
			)
		)
	)
)

(instance sGetEar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(UnLoad 128 731)
				(gEgo
					view: 732
					loop: 0
					cel: 0
					posn: 137 94
					setCycle: Fwd
					moveSpeed: 10
					cycleSpeed: 10
					setMotion: MoveTo 87 112 self
				)
			)
			(1
				(gEgo loop: 1 cel: 0 setCycle: CT 4 1 self)
				(ear hide:)
				(gEgo get: -1 52) ; Silver_Ear
			)
			(2
				(gMessager say: 27 4 2 0 self) ; "You "scooch" the chair closer and closer to your precious silver ear... and just manage to snag it!"
			)
			(3
				(gTheIconBar enable: 2 1 6)
				(gTheIconBar curIcon: (gTheIconBar at: 2))
				(gGame setCursor: 2)
				(gUser canControl: 0)
				(gUser input: 1)
				(gGame points: 1)
				(self dispose:)
			)
		)
	)
)

(instance sSharpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 28 55 0 0 self) ; "Smart thinking! You frantically give the silver ear a few quick rubs on the stone floor."
				(gEgo get: -1 49) ; Sharp_Ear
				(gEgo put: 52) ; Silver_Ear
			)
			(1
				(localSound number: 2736 loop: -1 play:)
				(gEgo view: 732 loop: 1 cel: 0 setCycle: ROsc 4 5 6 self)
			)
			(2
				(gGame points: 10 147)
				(localSound stop:)
				(gTheIconBar disable: 0)
				(gUser canControl: 0)
				(gUser input: 1)
				(gInventory curIcon: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCutAndRun of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheIconBar disable:)
				(gTimers delete: fireTimer)
				(gMessager say: 29 60 0 0 self) ; "You manage to slice into the ropes with the sharpened silver ear!"
			)
			(1
				(gGame points: 10 148 self)
			)
			(2
				(UnLoad 128 732)
				(gEgo
					view: 735
					loop: 0
					cel: 0
					setSpeed: 12
					setCycle: End self
				)
				(localSound number: 2737 loop: 1 play:)
			)
			(3
				(UnLoad 128 735)
				(chair init: ignoreActors: stopUpd:)
				(gGameMusic1 pause: 1)
				(ClearFlag 81)
				(localSound number: 2701 loop: 1 play: self)
				(gEgo
					view: 736
					loop: 0
					cel: 0
					x: 86
					y: 111
					setScale: 0
					setCycle: CT 2 1 self
				)
			)
			(4)
			(5
				(gGameMusic1 pause: 0)
				(gEgo cel: 2 setSpeed: 0 setPri: 1 setCycle: End self)
			)
			(6
				(gEgo hide:)
				(= cycles 3)
			)
			(7
				(proc0_15 1 5 self)
			)
			(8
				(gTheIconBar enable:)
				(gCurRoom newRoom: 740)
				(self dispose:)
			)
		)
	)
)

(instance sTimeToDie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: ROsc 3 5 cycleSpeed: 0)
				(fire2 setCycle: End self)
			)
			(1
				(fire3 init: setCycle: RandCycle)
				(= seconds 3)
			)
			(2
				(= global122 10)
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance fire1 of Prop
	(properties
		x 122
		y 72
		view 737
		cycleSpeed 10
		detailLevel 2
	)

	(method (cue)
		(if (> (++ loop) 2)
			(= loop 2)
		)
		(fireTimer setReal: (if (== loop 2) fire2 else fire1) 10)
	)
)

(instance fire2 of Prop
	(properties
		x 267
		y 109
		view 738
		cycleSpeed 10
		detailLevel 2
	)

	(method (cue)
		(self show:)
		(if (> (++ loop) 4)
			(= loop 1)
		)
		(if (== loop 1)
			(self setCycle: ROsc -1 0 1)
		else
			(self setCycle: RandCycle)
		)
		(fireTimer setReal: (if (== loop 1) fire3 else fire2) 10)
	)
)

(instance fire3 of Prop
	(properties
		x 76
		y 144
		view 739
		loop 1
		cycleSpeed 10
		detailLevel 2
	)

	(method (cue)
		(gCurRoom setScript: sTimeToDie)
	)
)

(instance penelope of Actor
	(properties
		x 103
		y 100
		view 802
	)

	(method (init)
		(super init:)
		(self setCycle: StopWalk -1)
	)
)

(instance lantern of Prop
	(properties
		x 79
		y 17
		view 734
		loop 1
	)
)

(instance ear of Actor
	(properties
		x 123
		y 72
		noun 27
		view 732
		loop 2
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local0
					(self setScript: sGetEar)
				else
					(gMessager say: noun theVerb 1) ; "You can't reach it from the chair, Freddy!"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chair of View
	(properties
		x 87
		y 112
		view 736
		loop 1
	)
)

(instance floor of Feature
	(properties
		x 1
		y 1
		noun 28
	)

	(method (doVerb theVerb)
		(switch theVerb
			(55 ; Silver_Ear
				(gCurRoom setScript: sSharpen)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 180 81 180 109 176 116 193 129 193 139 152 139 159 135 147 130 116 129 119 126 100 121 102 119 87 118 86 121 45 123 46 119 33 118 34 110 45 110 54 105 55 90 51 88 51 82
					yourself:
				)
		)
		(super init:)
	)
)

(instance barrel of Feature
	(properties
		x 76
		y 156
		noun 10
	)
)

(instance books of Feature
	(properties
		x 47
		y 170
		noun 11
	)
)

(instance colBooks of Feature
	(properties
		x 207
		y 118
		noun 23
	)
)

(instance colCrates of Feature
	(properties
		x 231
		y 95
		noun 24
	)
)

(instance colMaps of Feature
	(properties
		x 243
		y 99
		noun 25
	)
)

(instance crates of Feature
	(properties
		x 43
		y 79
		noun 19
	)
)

(instance desks of Feature
	(properties
		x 246
		y 40
		noun 22
	)
)

(instance jester of Feature
	(properties
		x 312
		y 133
		noun 6
	)
)

(instance jug of Feature
	(properties
		x 238
		y 174
		noun 8
	)
)

(instance lamp of Feature
	(properties
		x 305
		y 44
		noun 5
	)
)

(instance map of Feature
	(properties
		x 29
		y 131
		noun 12
	)
)

(instance pitcher of Feature
	(properties
		x 281
		y 166
		noun 7
	)
)

(instance oil of Feature
	(properties
		x 147
		y 10
		noun 26
	)
)

(instance toyChest of Feature
	(properties
		x 159
		y 173
		noun 9
	)
)

(instance drum of Feature
	(properties
		x 17
		y 56
		noun 13
		nsTop 41
		nsLeft 3
		nsBottom 73
		nsRight 29
	)
)

(instance jars of Feature
	(properties
		x 14
		y 12
		noun 14
		nsTop 3
		nsLeft 4
		nsBottom 24
		nsRight 24
		sightAngle 40
	)
)

(instance piano of Feature
	(properties
		x 158
		y 39
		noun 20
		nsTop 17
		nsLeft 137
		nsBottom 61
		nsRight 179
	)
)

(instance smallShelf of Feature
	(properties
		x 36
		y 23
		noun 16
		nsTop 11
		nsLeft 31
		nsBottom 35
		nsRight 42
	)
)

(instance tallShelf of Feature
	(properties
		x 16
		y 4
		noun 15
		nsTop -1
		nsBottom 130
		nsRight 32
	)
)

(instance pillar of Feature
	(properties
		x 212
		y 58
		noun 21
		nsLeft 184
		nsBottom 116
		nsRight 241
	)
)

(instance stairs of Feature
	(properties
		x 66
		y 53
		noun 18
		nsTop 35
		nsLeft 47
		nsBottom 72
		nsRight 85
	)
)

(instance fireTimer of Timer
	(properties)
)

(instance localSound of FPSound
	(properties
		flags 1
	)
)

(instance glassSound of FPSound
	(properties
		flags 1
		number 2542
	)
)

