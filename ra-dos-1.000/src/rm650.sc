;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 650)
(include sci.sh)
(use Main)
(use eRS)
(use ExitFeature)
(use MuseumRgn)
(use Inset)
(use Scaler)
(use Osc)
(use PolyPath)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm650 0
)

(local
	local0
	local1
	local2
)

(instance rm650 of LBRoom
	(properties
		noun 41
		picture 650
		north 666
		south 600
		vanishingY -30
	)

	(method (init)
		(LoadMany rsVIEW 652 654)
		(gEgo init: normalize: 831 setScale: Scaler 140 0 190 -30)
		(self setRegions: 90) ; MuseumRgn
		(switch gPrevRoomNum
			(south
				(gEgo x: 160)
			)
			(else
				(gEgo wearingGown: 1 posn: 180 160)
				(gGame handsOn:)
			)
		)
		(super init:)
		(LoadMany rsSOUND 651 652 655 49 721)
		(gGameMusic2 number: 650 flags: 1 loop: -1 play:)
		(chair init:)
		(shelf init:)
		(mace init:)
		(maceChain init:)
		(leftWeapon init:)
		(medalsA init:)
		(medalsB init:)
		(desk init:)
		(light init:)
		(chairWolf init:)
		(lamp init:)
		(blotter init:)
		(intercom init:)
		(shelf1 init: approachVerbs: 1 4) ; Look, Do
		(shelf2 init: approachVerbs: 1 4) ; Look, Do
		(shelf3 init: approachVerbs: 1 4) ; Look, Do
		(shelf4 init: approachVerbs: 1 4) ; Look, Do
		(shelf5 init: approachVerbs: 1 4) ; Look, Do
		(shelf6a init: approachVerbs: 1 4) ; Look, Do
		(shelf6b init: approachVerbs: 1 4) ; Look, Do
		(shelf6c init: approachVerbs: 1 4) ; Look, Do
		(shelf6d init: approachVerbs: 1 4) ; Look, Do
		(shelf7 init: approachVerbs: 1 4) ; Look, Do
		(shelf8 init: approachVerbs: 1 4) ; Look, Do
		(weapons1 init:)
		(weapons2 init:)
		(weapons3 init:)
		(weapons4 init:)
		(weaponsB init:)
		(secretShelf init:)
		(if (IsFlag 117)
			(secretPanel approachVerbs: 4 setCel: (secretPanel lastCel:) init:) ; Do
		else
			(secretPanel init: approachVerbs: 4) ; Do
		)
		(trap addToPic:)
		(sword init:)
		(string1 init: approachVerbs: 22 21) ; daggerOfRa, wireCutters
		(string2 init: approachVerbs: 22 21) ; daggerOfRa, wireCutters
		(string3 init: approachVerbs: 22 21) ; daggerOfRa, wireCutters
		(if (IsFlag 11)
			(gun init:)
			(gunFire setCel: (gunFire lastCel:) init:)
			(string1 setCel: (string1 lastCel:))
			(string2 setCel: (string2 lastCel:))
			(string3 setCel: (string3 lastCel:))
		else
			(LoadMany rsSOUND 653 654)
		)
		(southExit init:)
		(eastExit init:)
		(cond
			((and (== gAct 3) (not (IsFlag 57)) (not (TimeCheck $2020))) ; has 2:00 am occurred?
				(if (== ((ScriptID 90 2) room:) gCurRoomNum) ; aOlympia
					((ScriptID 90 2) goTo: 520) ; aOlympia
				)
				(string1 setScript: sIntercom)
			)
			((and (== ((ScriptID 90 2) room:) gCurRoomNum) (not (gEgo has: 17))) ; aOlympia, garter
				((ScriptID 90 2) goTo: 520) ; aOlympia
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((StepOn gEgo 2)
				(self setScript: sExitToSouth)
			)
		)
	)

	(method (newRoom)
		(super newRoom: &rest)
		(if (== gNewRoomNum north)
			(ClearFlag 117)
		)
	)

	(method (dispose)
		(gGameMusic2 fade:)
		(super dispose:)
	)
)

(instance sExitToSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 330 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: (gCurRoom south:))
			)
		)
	)
)

(instance sIntercom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(= seconds 30)
			)
			(2
				(if (gCurRoom script:)
					(-- state)
					(= seconds 5)
				else
					(gMessager say: 40) ; "The intercom crackles and you hear:"
					(= cycles 1)
				)
			)
			(3
				(SetFlag 57)
				(self dispose:)
			)
		)
	)
)

(instance sTouchTrap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 179 157 self)
			)
			(1
				(gEgo
					view: 652
					setLoop: 2
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(2
				(gGameMusic2 stop:)
				(sFX number: 654 flags: 5 loop: 1 play:)
				(string1 setCycle: End self)
			)
			(3
				(string1 stopUpd:)
				(string2 setCycle: End self)
			)
			(4
				(string2 stopUpd:)
				(string3 setCycle: End self)
			)
			(5
				(string3 stopUpd:)
				(gun init:)
				(= ticks 60)
			)
			(6
				(gun setCycle: Fwd)
				(sFX number: 653 flags: 1 loop: -1 play:)
				(gunFire init: cycleSpeed: 10 setCycle: End)
				(gEgo
					setLoop: 3
					setCel: 0
					setMotion: MoveTo (+ (gEgo x:) 7) (+ (gEgo y:) 3)
					setCycle: End self
				)
			)
			(7
				(= ticks 60)
			)
			(8
				(sFX stop:)
				(gun setCycle: 0 setCel: 0)
				(= ticks 120)
			)
			(9
				(= global145 6) ; "Death from traumatic lead poisoning claims many lives every year."
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance sDisarmTrap of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== register 30)
					(= temp0 206)
					(= temp1 152)
				else
					(= temp0 203)
					(= temp1 150)
				)
				(gEgo setMotion: PolyPath temp0 temp1 self)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(gEgo
					view: 652
					setLoop: (if (== register 30) 0 else 1)
					setCel: 0
					setPri: 13
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(3
				(sFX number: 654 flags: 5 loop: 1 play:)
				(gEgo normalize: 831 loop: 1)
				(string1 setCycle: End self)
			)
			(4
				(string1 stopUpd:)
				(string2 setCycle: End self)
			)
			(5
				(string2 stopUpd:)
				(string3 setCycle: End self)
			)
			(6
				(string3 stopUpd:)
				(gun init:)
				(= ticks 60)
			)
			(7
				(gun setCycle: Fwd)
				(sFX number: 653 flags: 1 loop: -1 play:)
				(gunFire init: cycleSpeed: 10 setCycle: End)
				(= ticks 180)
			)
			(8
				(sFX stop:)
				(gun setCycle: 0 setCel: 0)
				(SetFlag 11)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetCheese of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 179 157 self)
			)
			(1
				(gEgo
					view: 652
					setLoop: 2
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(2
				(gEgo get: 16) ; cheese
				((ScriptID 21 0) doit: 785) ; addCluesCode, Cheese
				(gGame points: 1 152)
				(= cycles 1)
			)
			(3
				(gEgo view: 652 setLoop: 2 setCel: 0 setCycle: Beg self)
			)
			(4
				(gEgo normalize: 831 loop: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLookTrap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo x:) 169)
					(gEgo setMotion: PolyPath 153 163 self)
				else
					(gEgo setMotion: PolyPath 186 154 self)
				)
			)
			(1
				(Face gEgo trap self)
			)
			(2
				(gCurRoom setInset: inCheese)
				(self dispose:)
			)
		)
	)
)

(instance sSwordKill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 282 130 self)
			)
			(1
				(gEgo
					view: 652
					setLoop: 4
					setCel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(2
				(gGameMusic2 stop:)
				(sFX number: 655 flags: 1 loop: 1 play:)
				(gEgo setLoop: 5 setCel: 0 setCycle: CT 5 1 self)
				(sword dispose:)
			)
			(3
				(sFX number: 652 flags: 1 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(4
				(= ticks 150)
			)
			(5
				(= global145 13) ; "Take another stab at it."
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance sShocked of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch register
					(0
						(= temp0 200)
						(= temp1 109)
					)
					(1
						(= temp0 212)
						(= temp1 112)
					)
					(2
						(= temp0 227)
						(= temp1 122)
					)
					(3
						(= temp0 250)
						(= temp1 123)
					)
					(4
						(= temp0 298)
						(= temp1 134)
					)
				)
				(gEgo setMotion: PolyPath temp0 temp1 self)
			)
			(1
				(gEgo
					view: 654
					setLoop: 0
					setCel: 0
					cycleSpeed: 4
					setCycle: CT 4 1 self
				)
			)
			(2
				(sFX number: 651 flags: 1 loop: -1 play:)
				(gEgo setCycle: Osc 1 self)
			)
			(3
				(sFX stop:)
				(= ticks 30)
			)
			(4
				(gEgo setLoop: 1 setCel: 0 cycleSpeed: 10 setCycle: End self)
			)
			(5
				(= ticks 150)
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(gEgo normalize: 831 loop: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sShockedWire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 652
					setLoop: 2
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(gEgo
					view: 654
					setLoop: 0
					setCel: 4
					cycleSpeed: 4
					setCycle: End self
				)
				(sFX number: 651 flags: 1 loop: -1 play:)
			)
			(2
				(gEgo setCycle: CT 4 -1 self)
			)
			(3
				(sFX stop:)
				(gEgo
					view: 652
					setLoop: 2
					setCel: (gEgo lastCel:)
					cycleSpeed: 12
				)
				(= ticks 15)
			)
			(4
				(gMessager say: 35 21 0 0 self) ; "Maybe that wasn't such a good idea after all."
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(gEgo normalize: 831 loop: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sShockedWire3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 654
					setLoop: 0
					setCel: 0
					cycleSpeed: 4
					setCycle: Osc 1 self
				)
				(sFX number: 651 flags: 1 loop: -1 play:)
			)
			(1
				(sFX stop:)
				(= ticks 30)
			)
			(2
				(gEgo setLoop: 1 setCel: 0 cycleSpeed: 10 setCycle: End self)
			)
			(3
				(gMessager say: 35 21 0 0 self) ; "Maybe that wasn't such a good idea after all."
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo normalize: 831 loop: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterSecretPassage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 652 setLoop: 4 setCel: 0 setCycle: CT 3 1 self)
			)
			(1
				(sFX number: 49 flags: 5 loop: 1 play: self)
			)
			(2
				(gEgo normalize: 831 loop: 0)
				(secretShelf
					setLoop: 6
					setMotion: MoveTo 161 (secretShelf y:) self
				)
				(sFX number: 721 flags: 5 loop: -1 play:)
			)
			(3
				(sFX stop:)
				(secretShelf stopUpd:)
				(gEgo setMotion: PolyPath 132 107 self)
			)
			(4
				(gEgo setMotion: MoveTo 126 99 self)
			)
			(5
				(gCurRoom newRoom: (gCurRoom north:))
				(self dispose:)
			)
		)
	)
)

(instance sShortPause of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 60)
			)
			(1
				(gMessager say: 32 4) ; "The poetry book falls open to a poem, "She Walks in Beauty," written by Lord Byron. The page is marked by a black garter with a note pinned to it."
				(self dispose:)
			)
		)
	)
)

(instance secretShelf of Actor
	(properties
		x 137
		y 15
		z -89
		view 650
		loop 6
		signal 16385
	)
)

(instance secretPanel of Prop
	(properties
		x 199
		y 80
		approachX 196
		approachY 118
		view 650
		loop 7
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if cel
					(gMessager say: 43 1) ; "Opening the bookcase has revealed a secret passage."
				else
					(gMessager say: 6 1) ; "A variety of shiny medals. Two of them, with packs of dogs carrying birds in their mouths, are marked with the word: Reichsjagdgebrauchshundverband. Others appear to be merit badges for the German youth equivalent of the Boy Scouts."
				)
			)
			(4 ; Do
				(sFX number: 49 flags: 5 loop: 1 play:)
				(if cel
					(secretButton dispose:)
					(self setCycle: Beg self)
					(ClearFlag 117)
				else
					(secretButton init: approachVerbs: 4) ; Do
					(self setCycle: End self)
					(SetFlag 117)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(sFX stop:)
		(self stopUpd:)
	)
)

(instance gun of Prop
	(properties
		x 46
		y 91
		z 50
		noun 28
		view 651
		signal 1
	)
)

(instance string1 of Prop
	(properties
		x 149
		y 144
		noun 35
		approachX 161
		approachY 150
		view 650
		loop 4
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(22 ; daggerOfRa
				(if (MuseumRgn nobodyAround:)
					(gCurRoom setScript: sShockedWire)
				else
					(return 1)
				)
			)
			(21 ; wireCutters
				(if (MuseumRgn nobodyAround:)
					(gCurRoom setScript: sShockedWire)
				else
					(return 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance string2 of Prop
	(properties
		x 81
		y 111
		noun 35
		approachX 92
		approachY 114
		view 650
		loop 3
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(22 ; daggerOfRa
				(if (MuseumRgn nobodyAround:)
					(gCurRoom setScript: sShockedWire)
				else
					(return 1)
				)
			)
			(21 ; wireCutters
				(if (MuseumRgn nobodyAround:)
					(gCurRoom setScript: sShockedWire)
				else
					(return 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance string3 of Prop
	(properties
		x 60
		y 57
		noun 35
		approachX 55
		approachY 114
		view 650
		loop 3
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(22 ; daggerOfRa
				(if (MuseumRgn nobodyAround:)
					(gCurRoom setScript: sShockedWire3)
				else
					(return 1)
				)
			)
			(21 ; wireCutters
				(if (MuseumRgn nobodyAround:)
					(gCurRoom setScript: sShockedWire3)
				else
					(return 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gunFire of Prop
	(properties
		x 150
		y 143
		view 652
		loop 7
		signal 16384
	)
)

(instance trap of View
	(properties
		x 165
		y 157
		view 651
		loop 1
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (not (gEgo has: 16)) ; cheese
					(gCurRoom setScript: sLookTrap)
				else
					(gMessager say: 27 1 2) ; "The cheese-less trap has been disarmed."
				)
			)
			(8 ; magnifier
				(self doVerb: 1)
			)
			(4 ; Do
				(cond
					((gEgo has: 16) ; cheese
						(gMessager say: 27 4 2) ; "You have already disarmed the trap and taken the cheese, so quit fooling around with it."
					)
					((IsFlag 11)
						(if (MuseumRgn nobodyAround:)
							(gCurRoom setScript: sGetCheese)
						else
							(return 1)
						)
					)
					((MuseumRgn nobodyAround:)
						(gCurRoom setScript: sTouchTrap)
					)
					(else
						(return 1)
					)
				)
			)
			(29 ; dinoBone
				(cond
					((IsFlag 11)
						(if (gEgo has: 16) ; cheese
							(gMessager say: 27 4 2) ; "You have already disarmed the trap and taken the cheese, so quit fooling around with it."
						else
							(gMessager say: 27 4 7) ; "The trap is disarmed now, so it's perfectly safe. Quit fooling around with it."
						)
					)
					((MuseumRgn nobodyAround:)
						(gCurRoom setScript: sDisarmTrap 0 29)
					)
					(else
						(return 1)
					)
				)
			)
			(30 ; snakeLasso
				(cond
					((IsFlag 11)
						(gMessager say: 27 4 7) ; "The trap is disarmed now, so it's perfectly safe. Quit fooling around with it."
					)
					((MuseumRgn nobodyAround:)
						(gCurRoom setScript: sDisarmTrap 0 30)
					)
					(else
						(return 1)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sword of View
	(properties
		x 287
		y 40
		noun 25
		view 652
		loop 6
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sSwordKill)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inCheese of Inset
	(properties
		view 650
		loop 2
		x 147
		y 135
		disposeNotOnMe 1
		noun 33
	)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(1 ; Look
					(gMessager say: 33 1 5) ; "It's too far away for you to get a good look at it, but it's definitely cheese, and it definitely stinks."
				)
				(8 ; magnifier
					(gMessager say: 5 8 0 0 0 15) ; "A closer look reveals a bit of mold on the cheese."
				)
				(4 ; Do
					(cond
						((IsFlag 11)
							(if (MuseumRgn nobodyAround:)
								(gCurRoom setScript: sGetCheese)
							else
								(return 1)
							)
						)
						((MuseumRgn nobodyAround:)
							(gCurRoom setScript: sTouchTrap)
						)
						(else
							(return 1)
						)
					)
					(self dispose:)
				)
				(29 ; dinoBone
					(cond
						((IsFlag 11)
							(gMessager say: 27 4 2) ; "You have already disarmed the trap and taken the cheese, so quit fooling around with it."
						)
						((MuseumRgn nobodyAround:)
							(gCurRoom setScript: sDisarmTrap 0 29)
						)
						(else
							(return 1)
						)
					)
					(self dispose:)
				)
				(30 ; snakeLasso
					(cond
						((IsFlag 11)
							(gMessager say: 27 4 2) ; "You have already disarmed the trap and taken the cheese, so quit fooling around with it."
						)
						((MuseumRgn nobodyAround:)
							(gCurRoom setScript: sDisarmTrap 0 30)
						)
						(else
							(return 1)
						)
					)
					(self dispose:)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance inBooks of Inset
	(properties
		view 650
		loop 1
		disposeNotOnMe 1
		noun 29
	)

	(method (init)
		(= x (- local0 24))
		(= y (- local1 20))
		(if (== local2 6)
			(= loop 0)
		else
			(= loop 1)
		)
		(super init: &rest)
		(if (== local2 6)
			(poetryBook
				init:
				nsLeft: (+ x 7)
				nsTop: (+ y 10)
				nsBottom: (+ y 28)
				nsRight: (+ x 13)
			)
		)
		(if (== local2 7)
			(heimlichBook
				init:
				nsLeft: (+ x 19)
				nsTop: (+ y 10)
				nsBottom: (+ y 28)
				nsRight: (+ x 25)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: (+ 13 local2) 1)
			)
			(4 ; Do
				(gMessager say: 29 4) ; "While the topics of these books interest you, there are more important things you should be doing right now."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inClosedBook of Inset
	(properties
		view 650
		loop 5
		cel 1
		x 88
		y 65
		disposeNotOnMe 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 32 1) ; "This book is a collection of poetry by Lord Byron. Apparently Heimlich had it turned on the bookshelf so that the spine with the title faced the wall. Perhaps he was embarrassed to have a poetry book on his shelf?"
			)
			(4 ; Do
				(gCurRoom setInset: inOpenBook)
			)
			(8 ; magnifier
				(gMessager say: 32 8) ; "The title, in gold leaf print, says: "The Poetry of Lord Byron." The binding is of high-quality leather."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inOpenBook of Inset
	(properties
		view 650
		loop 5
		x 90
		y 67
		disposeNotOnMe 1
	)

	(method (init)
		(super init: &rest)
		(gCurRoom setScript: sShortPause)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setInset: inGarter)
			)
			(8 ; magnifier
				(gCurRoom setInset: inGarter)
			)
			(4 ; Do
				(self dispose: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose param1)
		(super dispose:)
		(if (and argc param1)
			(gEgo get: 17) ; garter
			((ScriptID 21 0) doit: 786) ; addCluesCode, Garter
			(gGame points: 1 153)
		)
	)
)

(instance inGarter of Inset
	(properties
		view 650
		loop 2
		cel 1
		x 92
		y 69
		disposeNotOnMe 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 12 1 0 0 0 15) ; "A lacy black garter with the name, YVETTE, stitched into it. There is also a note attached."
			)
			(8 ; magnifier
				(gMessager say: 12 8 0 0 0 15) ; "The note attached to the garter reads: "You can have the other garter, and much more, if you meet me at 3:00 a.m. in the Preservation Lab." The handwriting is female."
			)
			(4 ; Do
				(self dispose: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose param1)
		(super dispose:)
		(if (and argc param1)
			(gEgo get: 17) ; garter
			((ScriptID 21 0) doit: 786) ; addCluesCode, Garter
			(gGame points: 1 153)
		)
	)
)

(class MyFeature of Feature
	(properties)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(= local0 temp0)
		(= local1 temp1)
		(return
			(cond
				((IsObject onMeCheck)
					(AvoidPath temp0 temp1 onMeCheck)
				)
				(
					(or
						(not (or nsLeft nsRight nsTop nsBottom))
						(and
							(<= nsLeft temp0 nsRight)
							(<= nsTop temp1 nsBottom)
						)
					)
					(if (!= onMeCheck 26505)
						(& onMeCheck (OnControl CONTROL temp0 temp1))
					else
						1
					)
				)
			)
		)
	)
)

(instance secretButton of Feature
	(properties
		x 193
		y 81
		z 10
		noun 44
		nsTop 66
		nsLeft 189
		nsBottom 77
		nsRight 198
		approachX 188
		approachY 110
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (MuseumRgn nobodyAround:)
					(gGame handsOff:)
					(gCurRoom setScript: sEnterSecretPassage)
				else
					(return 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poetryBook of Feature
	(properties
		y 200
	)

	(method (initialize))

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (gEgo has: 17) ; garter
					(gMessager say: 32 1 3) ; "You see nothing else of interest hidden in the poetry book."
					(inBooks dispose:)
				else
					(gMessager say: 32 1 6) ; "For some reason, the spine on this book has been turned around to face the wall, hiding the title."
				)
			)
			(4 ; Do
				(cond
					((gEgo has: 17) ; garter
						(gMessager say: 32 4 3) ; "You already have the garter and you don't have time to read the book."
						(inBooks dispose:)
					)
					((MuseumRgn nobodyAround:)
						(gCurRoom setInset: inClosedBook)
					)
					(else
						(return 1)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance heimlichBook of Feature
	(properties
		y 200
		noun 31
	)
)

(instance chair of Feature
	(properties
		x 216
		y 161
		noun 1
		nsTop 146
		nsLeft 201
		nsBottom 176
		nsRight 232
		sightAngle 40
	)
)

(instance shelf of Feature
	(properties
		x 24
		y 139
		noun 2
		nsTop 90
		nsBottom 189
		nsRight 49
		sightAngle 40
	)
)

(instance mace of Feature
	(properties
		x 12
		y 68
		noun 3
		nsTop 52
		nsBottom 84
		nsRight 24
		sightAngle 40
	)
)

(instance maceChain of Feature
	(properties
		x 4
		y 26
		noun 3
		nsTop -1
		nsBottom 53
		nsRight 9
		sightAngle 40
	)
)

(instance leftWeapon of Feature
	(properties
		x 21
		y 28
		noun 4
		nsLeft 9
		nsBottom 56
		nsRight 33
		sightAngle 40
	)
)

(instance medalsA of Feature
	(properties
		x 51
		y 54
		noun 5
		nsTop 36
		nsLeft 43
		nsBottom 73
		nsRight 60
		sightAngle 40
	)
)

(instance medalsB of Feature
	(properties
		x 187
		y 65
		noun 6
		nsTop 51
		nsLeft 177
		nsBottom 75
		nsRight 197
		sightAngle 40
	)
)

(instance desk of Feature
	(properties
		x 140
		y 127
		noun 7
		nsTop 106
		nsLeft 83
		nsBottom 148
		nsRight 198
		sightAngle 40
		onMeCheck 4
	)
)

(instance light of Feature
	(properties
		x 160
		y 25
		noun 8
		nsTop -1
		nsLeft 144
		nsBottom 51
		nsRight 179
		sightAngle 40
		onMeCheck 16
	)
)

(instance chairWolf of Feature
	(properties
		x 122
		y 120
		z 27
		noun 9
		nsTop 87
		nsLeft 111
		nsBottom 100
		nsRight 134
		sightAngle 40
		onMeCheck 8
	)
)

(instance lamp of Feature
	(properties
		x 114
		y 120
		z 18
		noun 10
		nsTop 95
		nsLeft 108
		nsBottom 109
		nsRight 121
		sightAngle 40
	)
)

(instance intercom of Feature
	(properties
		x 168
		y 120
		z 22
		noun 11
		nsTop 94
		nsLeft 160
		nsBottom 102
		nsRight 176
		sightAngle 40
	)
)

(instance blotter of Feature
	(properties
		x 142
		y 120
		z 18
		noun 12
		nsTop 96
		nsLeft 121
		nsBottom 109
		nsRight 163
		sightAngle 40
		onMeCheck 32
	)
)

(instance shelf1 of MyFeature
	(properties
		x 112
		y 27
		noun 13
		nsTop 20
		nsLeft 69
		nsBottom 35
		nsRight 156
		sightAngle 40
		onMeCheck 64
		approachX 123
		approachY 115
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(= local2 0)
				(gCurRoom setInset: inBooks)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shelf2 of MyFeature
	(properties
		x 112
		y 37
		noun 14
		nsTop 31
		nsLeft 69
		nsBottom 44
		nsRight 156
		sightAngle 40
		onMeCheck 128
		approachX 123
		approachY 115
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(= local2 1)
				(gCurRoom setInset: inBooks)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shelf3 of MyFeature
	(properties
		x 106
		y 47
		noun 15
		nsTop 42
		nsLeft 69
		nsBottom 52
		nsRight 144
		sightAngle 40
		approachX 123
		approachY 115
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(= local2 2)
				(gCurRoom setInset: inBooks)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shelf4 of MyFeature
	(properties
		x 112
		y 57
		noun 16
		nsTop 52
		nsLeft 69
		nsBottom 63
		nsRight 156
		sightAngle 40
		approachX 123
		approachY 115
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(= local2 3)
				(gCurRoom setInset: inBooks)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shelf5 of MyFeature
	(properties
		x 112
		y 68
		noun 17
		nsTop 64
		nsLeft 69
		nsBottom 72
		nsRight 156
		sightAngle 40
		approachX 123
		approachY 115
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(= local2 4)
				(gCurRoom setInset: inBooks)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shelf6a of MyFeature
	(properties
		x 84
		y 81
		noun 18
		nsTop 76
		nsLeft 70
		nsBottom 86
		nsRight 98
		sightAngle 40
		approachX 123
		approachY 115
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(= local2 5)
				(gCurRoom setInset: inBooks)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shelf6b of MyFeature
	(properties
		x 107
		y 80
		noun 19
		nsTop 76
		nsLeft 98
		nsBottom 85
		nsRight 117
		sightAngle 40
		approachX 123
		approachY 115
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(= local2 6)
				(gCurRoom setInset: inBooks)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shelf6c of MyFeature
	(properties
		x 127
		y 78
		noun 20
		nsTop 74
		nsLeft 119
		nsBottom 83
		nsRight 135
		sightAngle 40
		approachX 123
		approachY 115
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(= local2 7)
				(gCurRoom setInset: inBooks)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shelf6d of MyFeature
	(properties
		x 145
		y 78
		noun 21
		nsTop 74
		nsLeft 136
		nsBottom 83
		nsRight 154
		sightAngle 40
		approachX 123
		approachY 115
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(= local2 8)
				(gCurRoom setInset: inBooks)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shelf7 of MyFeature
	(properties
		x 111
		y 89
		noun 22
		nsTop 82
		nsLeft 68
		nsBottom 96
		nsRight 155
		sightAngle 40
		onMeCheck 512
		approachX 123
		approachY 115
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(= local2 9)
				(gCurRoom setInset: inBooks)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shelf8 of MyFeature
	(properties
		x 111
		y 99
		noun 23
		nsTop 89
		nsLeft 68
		nsBottom 110
		nsRight 155
		sightAngle 40
		onMeCheck 256
		approachX 123
		approachY 115
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(= local2 10)
				(gCurRoom setInset: inBooks)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance weapons1 of Feature
	(properties
		x 241
		y 60
		noun 24
		nsTop 43
		nsLeft 200
		nsBottom 69
		nsRight 217
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (MuseumRgn nobodyAround:)
					(gCurRoom setScript: sShocked 0 0)
				else
					(return 1)
				)
			)
			(8 ; magnifier
				(gMessager say: 39 8) ; "Was that a spark you just saw on this weapon, or was it just a trick of the light?"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance weapons2 of Feature
	(properties
		x 21
		y 28
		noun 36
		nsTop 40
		nsLeft 215
		nsBottom 62
		nsRight 230
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (MuseumRgn nobodyAround:)
					(gCurRoom setScript: sShocked 0 1)
				else
					(return 1)
				)
			)
			(8 ; magnifier
				(gMessager say: 39 8) ; "Was that a spark you just saw on this weapon, or was it just a trick of the light?"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance weapons3 of Feature
	(properties
		x 21
		y 28
		noun 37
		nsTop 37
		nsLeft 231
		nsBottom 83
		nsRight 245
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (MuseumRgn nobodyAround:)
					(gCurRoom setScript: sShocked 0 2)
				else
					(return 1)
				)
			)
			(8 ; magnifier
				(gMessager say: 39 8) ; "Was that a spark you just saw on this weapon, or was it just a trick of the light?"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance weapons4 of Feature
	(properties
		x 21
		y 28
		noun 38
		nsTop 36
		nsLeft 246
		nsBottom 73
		nsRight 278
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (MuseumRgn nobodyAround:)
					(gCurRoom setScript: sShocked 0 3)
				else
					(return 1)
				)
			)
			(8 ; magnifier
				(gMessager say: 39 8) ; "Was that a spark you just saw on this weapon, or was it just a trick of the light?"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance weaponsB of Feature
	(properties
		x 305
		y 53
		noun 26
		nsTop 27
		nsLeft 297
		nsBottom 115
		nsRight 314
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (MuseumRgn nobodyAround:)
					(gCurRoom setScript: sShocked 0 4)
				else
					(return 1)
				)
			)
			(8 ; magnifier
				(gMessager say: 39 8) ; "Was that a spark you just saw on this weapon, or was it just a trick of the light?"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsTop 185
		nsLeft 46
		nsBottom 189
		nsRight 319
		cursor 11
		exitDir 3
		noun 42
	)
)

(instance eastExit of ExitFeature
	(properties
		nsTop 132
		nsLeft 315
		nsBottom 179
		nsRight 319
		cursor 14
		exitDir 2
		noun 42
	)
)

(instance sFX of Sound
	(properties
		flags 1
	)
)

