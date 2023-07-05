;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 710)
(include sci.sh)
(use Main)
(use eRS)
(use Inset)
(use Scaler)
(use Osc)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm710 0
)

(local
	local0
)

(instance rm710 of FPRoom
	(properties
		noun 26
		picture 710
		style 10
		west 250
	)

	(method (init)
		(gEgo init: setScale: Scaler 125 89 164 124 normalize:)
		(switch gPrevRoomNum
			(west
				(gCurRoom setScript: sEnterFrom250)
			)
			(680
				(gGame handsOn:)
			)
			(else
				(gEgo x: 263 y: 150 setHeading: 270)
				(gGame handsOn:)
			)
		)
		(super init:)
		(LoadMany rsVIEW 253)
		(inWantedSign1 loop: (Random 1 2))
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 0 189 0 154 291 154 291 125 240 125 232 135 217 135 215 144 162 144 162 135 137 135 119 132 89 132 68 147 0 147 0 0 319 0
					yourself:
				)
		)
		(sheriff init: approachVerbs: 2 49 setCycle: Fwd) ; Talk, Coffee
		(clockPen init:)
		(chairLegs init:)
		(desk init: setOnMeCheck: 1 2)
		(bars init: setOnMeCheck: 1 4)
		(jail init: setOnMeCheck: 1 8)
		(border init: setOnMeCheck: 1 16)
		(guns init: setOnMeCheck: 1 32)
		(table init: setOnMeCheck: 1 64)
		(lamp init: setOnMeCheck: 1 128)
		(clothes init: setOnMeCheck: 1 256)
		(books init: setOnMeCheck: 1 512)
		(bookShelf init: setOnMeCheck: 1 1024)
		(wantedSign init: setOnMeCheck: 1 2048)
		(clock init: setOnMeCheck: 1 4096)
		(spitoon init: setOnMeCheck: 1 8192)
		(trunk init: setOnMeCheck: 1 16384)
		(wantedSign2 init: setOnMeCheck: 1 -32768)
		(bucket init: setOnMeCheck: 1 2)
		(if (IsFlag 39)
			(coffee init: setCycle: Fwd)
		)
		(if (IsFlag 38)
			(pie init: setCycle: Fwd)
		)
		(cond
			((== gCurPuzzle 14) 0)
			((== gPrevRoomNum 250) 0)
			(else
				(gGameMusic1 number: 710 flags: 1 loop: -1 play:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(gGameMusic2 fade: 80 10 16 0)
	)
)

(instance sEnterFrom250 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo x: 5 y: 154 setMotion: MoveTo 55 154 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSwingIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(clockPen setCycle: End self)
			)
			(1
				(clockPen setCycle: Beg self)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance sGiveSheriffCoffee of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 (gEgo moveSpeed:))
				(gEgo setHeading: 90)
				(gGame points: 4 139 self)
			)
			(1
				(if (IsFlag 38)
					(gEgo get: -1 9) ; Cleaning_Kit
					(gMessager say: 36 0 2 1 self) ; "Here's what you wanted, Sheriff. A nice hot cup of Mom's coffee."
				else
					(gEgo get: -1 3) ; Bullets
					(gMessager say: 36 0 1 1 self) ; "Say, Sheriff! I know how much a law enforcement person like yourself enjoys a good hot cup of coffee every now and then."
					(if (gEgo has: 44) ; Pistols
						(= gCurPuzzle 17)
					)
				)
				(gEgo put: 11) ; Coffee
			)
			(2
				(sheriff loop: 1 setCycle: End self)
			)
			(3
				(sheriff loop: 3 cel: 0 setCycle: End self)
			)
			(4
				(sheriff loop: 2 cel: 0 setCycle: Osc 1 self)
				(gEgo view: 606 loop: 1 setSpeed: 10 setCycle: Osc 1 self)
			)
			(5)
			(6
				(coffee init: setCycle: Fwd)
				(if (IsFlag 38)
					(gMessager say: 36 0 2 2 3 self) ; "Thanks, pardner! This'll shore go good wit' dat apple pie you gave me!"
				else
					(gMessager say: 36 0 1 2 3 self) ; "Thanks, pardner! But 'cha know what? Sumptin sweet would shore taste good right now!"
				)
			)
			(7
				(sheriff loop: 4 cel: 0 setCycle: CT 12 1 self)
			)
			(8
				(gEgo setCycle: End self)
			)
			(9
				(if (IsFlag 38)
					(gMessager say: 36 0 2 4 self) ; "Okay, son. But this gun cleanin' kit'll be the last thing I give ya. Now git chur pistols cleaned, git chur horse packed up and git chur ass outta town!"
				else
					(gMessager say: 36 0 1 4 self) ; "Whey, shore, son. Here. Have a box o' these Remingtons! No charge; they're on the County."
				)
			)
			(10
				(gEgo setCycle: Beg self)
				(sheriff setCycle: End)
			)
			(11
				(sheriff loop: 1 cel: 5 setCycle: Beg self)
			)
			(12
				(sheriff loop: 0 cel: 0 setCycle: Fwd)
				(gEgo normalize: cel: 0 setSpeed: local0)
				(UnLoad 128 606)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGiveSheriffPie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 (gEgo moveSpeed:))
				(gEgo setHeading: 90)
				(gGame points: 4 140 self)
			)
			(1
				(if (IsFlag 39)
					(gEgo get: -1 9) ; Cleaning_Kit
					(gMessager say: 36 0 4 1 self) ; "Here you go, Sheriff Shift. I found some of Mom's nice hot apple pie for ya. I know how much a law-enforcing person like yourself enjoys sweet, fatty breakfasts."
				else
					(gEgo get: -1 3) ; Bullets
					(if (gEgo has: 44) ; Pistols
						(= gCurPuzzle 17)
					)
					(gMessager say: 36 0 3 1 self) ; "Here, Sheriff Shift. I know how much a law-enforcing person like yourself appreciates a good fatty dessert-like foodstuff for breakfast."
				)
				(gEgo put: 43) ; Pie
			)
			(2
				(sheriff loop: 1 setCycle: End self)
			)
			(3
				(sheriff loop: 3 cel: 0 setCycle: End self)
			)
			(4
				(sheriff loop: 2 cel: 0 setCycle: Osc 1 self)
				(gEgo view: 606 loop: 1 setSpeed: 10 setCycle: Osc 1 self)
			)
			(5)
			(6
				(pie init: setCycle: Fwd)
				(if (IsFlag 39)
					(gMessager say: 36 0 4 2 3 self) ; "Whey, thank cue! I bin so hongrey I coulda et a bear! This'll shore go good with that cuppa coffee ya brung me earlier!"
				else
					(gMessager say: 36 0 3 2 3 self) ; "Whey, thank cue! I bin so hongrey I coulda et a bear! But, do ya think I could git a cuppa coffee to go with this?"
				)
			)
			(7
				(sheriff loop: 4 cel: 0 setCycle: CT 12 1 self)
			)
			(8
				(gEgo setCycle: End self)
			)
			(9
				(if (IsFlag 39)
					(gMessager say: 36 0 4 4 self) ; "Okay, son. But this gun cleanin' kit'll be the last thing I give ya. Now git chur guns cleaned, git chur horse packed and git chur ass outta ma town!"
				else
					(gMessager say: 36 0 3 4 self) ; "Whey, shore, son. Here. Have a box o' these Remingtons! No charge; they're on the County."
				)
			)
			(10
				(gEgo setCycle: Beg self)
				(sheriff setCycle: End)
			)
			(11
				(sheriff loop: 1 cel: 5 setCycle: Beg self)
			)
			(12
				(sheriff loop: 0 cel: 0 setCycle: Fwd)
				(gEgo normalize: cel: 0 setSpeed: local0)
				(UnLoad 128 606)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sheriff of Prop
	(properties
		x 191
		y 124
		noun 13
		approachX 147
		approachY 135
		view 711
		signal 4096
		cycleSpeed 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(49 ; Coffee
				(if (IsFlag 39)
					(super doVerb: theVerb &rest)
				else
					(SetFlag 39)
					(sheriff setScript: sGiveSheriffCoffee)
				)
			)
			(48 ; Pie
				(SetFlag 38)
				(sheriff setScript: sGiveSheriffPie)
			)
			(2 ; Talk
				(cond
					((<= gAct 1)
						(switch global138
							(0
								(gMessager say: noun theVerb 6) ; "Sheriff!"
								(++ global138)
							)
							(1
								(gMessager say: noun theVerb 7) ; "Sheriff, I don't understand how the Opera House was making Coarsegold unsafe. Why'd you close it down?"
								(++ global138)
							)
							(2
								(gMessager say: noun theVerb 8) ; "And furthermore..."
							)
						)
					)
					((or (== gCurPuzzle 9) (== gCurPuzzle 8))
						(switch global138
							(0
								(gMessager say: noun theVerb 9) ; "Sheriff, do YOU aim to do anything about the flatulent horses out there?"
								(++ global138)
							)
							(1
								(gMessager say: noun theVerb 10) ; "Sheriff, if you're not going to help these people, then I am."
							)
						)
					)
					((== gCurPuzzle 10)
						(switch global138
							(0
								(++ global138)
								(gMessager say: noun theVerb 11) ; "Sheriff! Are you going to help me stop that stampede before it runs over the whole town?"
							)
							(1
								(gMessager say: noun theVerb 12) ; "Sheriff, I'm not jokin'. Get a posse together! We can round 'em up, I KNOW we can!"
							)
						)
					)
					((== gCurPuzzle 12)
						(switch global138
							(0
								(gMessager say: noun theVerb 13) ; "Welp, Sheriff, I stopped that stampede, no thanks to you."
								(++ global138)
							)
							(1
								(gMessager say: noun theVerb 14) ; "I don't suppose you could help me rescue an Indian from an anthill?"
							)
						)
					)
					((== gCurPuzzle 13)
						(switch global138
							(0
								(gMessager say: noun theVerb 15) ; "Sheriff, I know you couldn't care less, but folks around town are having some sort of mysterious stomach ailment."
								(++ global138)
							)
							(1
								(gMessager say: noun theVerb 16) ; "I'm going to cure the poor folks of this town if it's the last thing I do!"
							)
						)
					)
					((or (== gCurPuzzle 16) (== gCurPuzzle 17))
						(gMessager say: noun theVerb 17) ; "Sheriff, I'm going to be saying my goodbyes soon, and I just wanted to thank you for all your help."
					)
					((== gCurPuzzle 19)
						(gMessager say: noun theVerb 18) ; "Sheriff, I'll be leaving shortly. Thanks for the ammo and cleaning supplies."
					)
					((== gCurPuzzle 20)
						(switch global138
							(0
								(gMessager say: noun theVerb 19) ; "Sheriff!"
								(++ global138)
							)
							(1
								(gMessager say: noun theVerb 20) ; "I'm going to have to bring that gambler to justice!"
							)
						)
					)
					((== gCurPuzzle 22)
						(switch global138
							(0
								(gMessager say: noun theVerb 21) ; "Hey, Sheriff Shift!"
								(++ global138)
							)
							(1
								(gMessager say: noun theVerb 22) ; "Well? Are you going to stop those rowdy cowhands?"
							)
						)
					)
				)
			)
			(19 ; ???
				(gMessager say: noun 71) ; "Tryin' to POISON me, bwoy? Do I LOOK sick? I don't THANK I look sick! Wuz I sick wiffout mah KNOWIN' it?"
			)
			(46 ; Deposit_Key
				(gMessager say: noun 35) ; "Sheriff Shift eyes you suspiciously."
			)
			(45 ; Desk_Key
				(gMessager say: noun 35) ; "Sheriff Shift eyes you suspiciously."
			)
			(9 ; Door_Key
				(gMessager say: noun 35) ; "Sheriff Shift eyes you suspiciously."
			)
			(69 ; Empty_Mold
				(gMessager say: noun 52) ; "You toss the clay at the Sheriff."
			)
			(11 ; Med_1
				(gMessager say: noun 71) ; "Tryin' to POISON me, bwoy? Do I LOOK sick? I don't THANK I look sick! Wuz I sick wiffout mah KNOWIN' it?"
			)
			(13 ; Med_2
				(gMessager say: noun 71) ; "Tryin' to POISON me, bwoy? Do I LOOK sick? I don't THANK I look sick! Wuz I sick wiffout mah KNOWIN' it?"
			)
			(18 ; Med_3
				(gMessager say: noun 71) ; "Tryin' to POISON me, bwoy? Do I LOOK sick? I don't THANK I look sick! Wuz I sick wiffout mah KNOWIN' it?"
			)
			(10 ; Penelope_s_Rx
				(gMessager say: noun 17) ; "I cain't read thet, Pharphetcht. Yew know ain't nobody 'round here kin read that ol' drunk's chicken scratchin'. And say, that reminds me. Ah'm gonna be stopping 'round at the Pharmacy a little later. Hope yew don't mind. Thet's fine, bwoy, jus' fine. Ah'll be seeing you later, then."
			)
			(12 ; Helen_s_Rx
				(gMessager say: noun 17) ; "I cain't read thet, Pharphetcht. Yew know ain't nobody 'round here kin read that ol' drunk's chicken scratchin'. And say, that reminds me. Ah'm gonna be stopping 'round at the Pharmacy a little later. Hope yew don't mind. Thet's fine, bwoy, jus' fine. Ah'll be seeing you later, then."
			)
			(14 ; Madame_s_Rx
				(gMessager say: noun 17) ; "I cain't read thet, Pharphetcht. Yew know ain't nobody 'round here kin read that ol' drunk's chicken scratchin'. And say, that reminds me. Ah'm gonna be stopping 'round at the Pharmacy a little later. Hope yew don't mind. Thet's fine, bwoy, jus' fine. Ah'll be seeing you later, then."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance clockPen of Prop
	(properties
		x 203
		y 73
		view 711
		loop 6
		signal 4112
		cycleSpeed 10
	)

	(method (init)
		(super init:)
		(self setScript: sSwingIt)
	)
)

(instance pie of Prop
	(properties
		x 191
		y 98
		noun 38
		view 710
		loop 1
		signal 4096
	)
)

(instance coffee of Prop
	(properties
		x 206
		y 101
		noun 39
		view 710
		signal 4096
	)
)

(instance chairLegs of View
	(properties
		x 190
		y 127
		noun 37
		view 711
		loop 5
		priority 7
		signal 4112
	)
)

(instance desk of Feature
	(properties
		x 178
		y 86
		noun 14
	)
)

(instance bars of Feature
	(properties
		x 160
		y 200
		noun 15
	)
)

(instance jail of Feature
	(properties
		x 50
		y 86
		noun 16
	)
)

(instance border of Feature
	(properties
		x 160
		y 200
		noun 17
	)
)

(instance guns of Feature
	(properties
		x 252
		y 86
		noun 18
	)
)

(instance table of Feature
	(properties
		x 271
		y 86
		noun 19
	)
)

(instance lamp of Feature
	(properties
		x 200
		y 86
		noun 20
	)
)

(instance clothes of Feature
	(properties
		x 123
		y 86
		noun 21
	)
)

(instance books of Feature
	(properties
		x 182
		y 86
		noun 22
	)
)

(instance bookShelf of Feature
	(properties
		x 138
		y 86
		noun 23
	)
)

(instance clock of Feature
	(properties
		x 209
		y 86
		noun 25
	)
)

(instance spitoon of Feature
	(properties
		x 137
		y 86
		noun 28
	)
)

(instance trunk of Feature
	(properties
		x 267
		y 200
		noun 27
	)
)

(instance wantedSign of Feature
	(properties
		x 105
		y 86
		noun 24
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setInset: inWantedSign1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wantedSign2 of Feature
	(properties
		x 218
		y 86
		noun 29
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setInset: inWantedSign2)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bucket of Feature
	(properties
		x 109
		y 87
		noun 30
		nsTop 111
		nsLeft 99
		nsBottom 128
		nsRight 120
	)
)

(instance inWantedSign1 of Inset
	(properties
		view 253
		x 160
		y 88
		priority 15
		disposeNotOnMe 1
	)

	(method (doVerb)
		(self dispose:)
	)
)

(instance inWantedSign2 of Inset
	(properties
		view 253
		x 160
		y 88
		priority 15
		disposeNotOnMe 1
	)

	(method (doVerb)
		(self dispose:)
	)
)

