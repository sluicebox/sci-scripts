;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 600)
(include sci.sh)
(use Main)
(use n814)
(use LoadMany)
(use Timer)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	EndGame 0
)

(local
	local0
	local1
	local2
)

(instance EndGame of Rm
	(properties
		picture 141
		style 1
	)

	(method (dispose)
		(= global451 0)
		(= gUseSortedFeatures local1)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 139 138)
		(super init: &rest)
		(SolvePuzzle 734 25)
		(= local1 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(gLongSong stop:)
		(DoSound sndSET_SOUND 1)
		(gGame setSpeed: 6)
		(HandsOff)
		(gTheIconBar enable: 2)
		(gUser canInput: 1)
		(proc814_32 2)
		(arturo init: stopUpd:)
		(rogerHardy init: stopUpd:)
		(bobMallory init: stopUpd:)
		(tom init: stopUpd:)
		(oliver init: stopUpd:)
		(carlos init: stopUpd:)
		(loriCole init: stopUpd:)
		(coreyCole init: stopUpd:)
		(bobFischbach init: stopUpd:)
		(richardA init: stopUpd:)
		(jonBock init: stopUpd:)
		(jerryMoore init: stopUpd:)
		(gloria init: stopUpd:)
		(vana init: stopUpd:)
		(wilWong init: stopUpd:)
		(diana init: stopUpd:)
		(jeffCrowe init: stopUpd:)
		(ericKasner init: stopUpd:)
		(richardP init: stopUpd:)
		(ourHero init: stopUpd:)
		(baron init: stopUpd:)
		(yoric init: stopUpd:)
		(if (IsFlag 273)
			((gInventory at: 0) amount: (+ ((gInventory at: 0) amount:) 1100)) ; silver, silver
		)
		(gNarrator keepWindow: 0)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
		(self setScript: awardScript)
	)
)

(class lookView of View
	(properties)

	(method (cue)
		(cond
			((== loop 3)
				(= loop 2)
			)
			((== loop 1)
				(= loop 0)
			)
		)
		(Display 600 0 dsRESTOREPIXELS local0)
		(gUser canInput: 1)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gUser canInput: 0)
			(cond
				((== loop 2)
					(= loop 3)
				)
				((== loop 0)
					(= loop 1)
				)
			)
			(nextRoomCue setReal: nextRoomCue 15)
			(flashBack setReal: self 3)
		)
	)
)

(instance flashBack of Timer
	(properties)
)

(instance nextRoomCue of Timer
	(properties)

	(method (cue)
		(nextRoomCue dispose: delete:)
		(flashBack dispose: delete:)
		(gCurRoom newRoom: 602) ; EndGame2
	)
)

(instance ourHero of Actor
	(properties
		x 87
		y 137
		noun 19
		view 139
		loop 4
		signal 2048
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if local2
				(nextRoomCue dispose: delete:)
				(flashBack dispose: delete:)
				(gCurRoom newRoom: 602) ; EndGame2
			else
				(= local2 0)
				(gMessager say: 19 1) ; "You're the real Hero of this game! Congratulations!"
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance baron of Prop
	(properties
		x 67
		y 130
		noun 2
		view 139
		loop 6
	)

	(method (init)
		(= global451 1138)
		(PalVary pvCHANGE_TARGET 1138)
		(AssertPalette 138)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gNarrator x: -1 y: -1)
			(gMessager say: 2 1) ; "The Baron."
		)
	)
)

(instance centaurs of View
	(properties
		x 265
		y 161
		noun 9
		view 139
		loop 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gNarrator x: -1 y: -1)
			(gMessager say: 9 1) ; "The Centaurs."
		)
	)
)

(instance kattaAndAbdul of View
	(properties
		x 167
		y 143
		noun 8
		view 139
		loop 2
		cel 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gNarrator x: -1 y: -1)
			(gMessager say: 8 1) ; "Shema, Shameen, and Abdulla Doo."
		)
	)
)

(instance elsa of View
	(properties
		x 78
		y 118
		noun 13
		view 139
		loop 1
		cel 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gNarrator x: -1 y: -1)
			(gMessager say: 13 1) ; "Elsa von Spielburg."
		)
	)
)

(instance baronette of View
	(properties
		x 24
		y 136
		noun 4
		view 139
		loop 1
		cel 3
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gNarrator x: -1 y: -1)
			(gMessager say: 4 1) ; "The Baronet Barnard von Spielburg."
		)
	)
)

(instance sheriffAndOtto of View
	(properties
		x 16
		y 170
		noun 29
		view 139
		loop 2
		cel 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gNarrator x: -1 y: -1)
			(gMessager say: 29 1) ; "The sheriff and Otto."
		)
	)
)

(instance erasmusAndFenrus of View
	(properties
		x 183
		y 158
		noun 15
		view 139
		loop 2
		cel 1
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gNarrator x: -1 y: -1)
			(gMessager say: 15 1) ; "Erasmus and Fenrus."
		)
	)
)

(instance hermitAndHealer of View
	(properties
		x 227
		y 153
		noun 18
		view 139
		loop 2
		cel 3
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gNarrator x: -1 y: -1)
			(gMessager say: 18 1) ; "The hermit and the healer."
		)
	)
)

(instance thiefAndCrusher of View
	(properties
		x 294
		y 134
		noun 11
		view 139
		loop 2
		cel 5
		priority 14
		signal 16
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gNarrator x: -1 y: -1)
			(gMessager say: 11 1) ; "The Chief Thief and Crusher."
		)
	)
)

(instance minotaur of View
	(properties
		x 123
		y 109
		noun 27
		view 139
		loop 1
		cel 1
		priority 4
		signal 16
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gNarrator x: -1 y: -1)
			(gMessager say: 27 1) ; "The minotaur."
		)
	)
)

(instance shopkeeperAndZara of View
	(properties
		x 193
		y 163
		noun 38
		view 139
		loop 2
		cel 9
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gNarrator x: -1 y: -1)
			(gMessager say: 38 1) ; "Zara and the shopkeeper."
		)
	)
)

(instance swordmaster of View
	(properties
		x 197
		y 184
		noun 33
		view 139
		loop 2
		cel 6
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gNarrator x: -1 y: -1)
			(gMessager say: 33 1) ; "The swordmaster."
		)
	)
)

(instance guildmaster of View
	(properties
		x 167
		y 135
		noun 17
		view 139
		loop 2
		cel 7
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gNarrator x: -1 y: -1)
			(gMessager say: 17 1) ; "The guildmaster."
		)
	)
)

(instance grannyAndCat of View
	(properties
		x 196
		y 133
		noun 24
		view 139
		loop 2
		cel 8
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gNarrator x: -1 y: -1)
			(gMessager say: 24 1) ; "Granny and her kitty."
		)
	)
)

(instance karl of View
	(properties
		x 60
		y 91
		noun 23
		view 139
		loop 2
		cel 10
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gNarrator x: -1 y: -1)
			(gMessager say: 23 1) ; "Karl the gatekeeper."
		)
	)
)

(instance yoric of Actor
	(properties
		x 2
		y 147
		noun 37
		view 139
		loop 5
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gNarrator x: -1 y: -1)
			(gMessager say: 37 1) ; "Yorick"
		)
	)
)

(instance bartender of View
	(properties
		x 142
		y 139
		noun 3
		view 139
		loop 2
		cel 11
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gNarrator x: -1 y: -1)
			(gMessager say: 3 1) ; "The bartender."
		)
	)
)

(instance carlos of Prop
	(properties
		x 273
		y 189
		noun 7
		view 138
		loop 2
		cel 1
		signal 16384
	)

	(method (doVerb theVerb &tmp [temp0 20])
		(if (== theVerb 1) ; Look
			(clickOnPeople start: 73)
			(gNarrator x: 168 y: 131)
			(self setScript: clickOnPeople)
		)
		(super doVerb: theVerb)
	)
)

(instance loriCole of Prop
	(properties
		x 243
		y 150
		noun 25
		view 138
		cel 8
		priority 14
		signal 16
	)

	(method (doVerb theVerb &tmp [temp0 20])
		(if (== theVerb 1) ; Look
			(clickOnPeople start: 69)
			(gNarrator x: 175 y: 114)
			(self setScript: clickOnPeople)
		)
		(super doVerb: theVerb)
	)
)

(instance coreyCole of Prop
	(properties
		x 226
		y 140
		noun 10
		view 138
		cel 9
		priority 12
		signal 16
	)

	(method (doVerb theVerb &tmp [temp0 20])
		(if (== theVerb 1) ; Look
			(clickOnPeople start: 65)
			(gNarrator x: 150 y: 110)
			(self setScript: clickOnPeople)
		)
		(super doVerb: theVerb)
	)
)

(instance oliver of Prop
	(properties
		x 216
		y 189
		noun 28
		view 138
		loop 2
		cel 2
		priority 15
		signal 16
	)

	(method (doVerb theVerb &tmp [temp0 20])
		(if (== theVerb 1) ; Look
			(clickOnPeople start: 61)
			(gNarrator x: 100 y: 125)
			(self setScript: clickOnPeople)
		)
		(super doVerb: theVerb)
	)
)

(instance tom of Prop
	(properties
		x 134
		y 183
		noun 34
		view 138
		cel 13
		signal 16384
	)

	(method (doVerb theVerb &tmp [temp0 20])
		(if (== theVerb 1) ; Look
			(clickOnPeople start: 57)
			(gNarrator x: 40 y: 112)
			(self setScript: clickOnPeople)
		)
		(super doVerb: theVerb)
	)
)

(instance bobMallory of Prop
	(properties
		x 109
		y 181
		noun 6
		view 138
		loop 2
		signal 16384
	)

	(method (doVerb theVerb &tmp [temp0 20])
		(if (== theVerb 1) ; Look
			(clickOnPeople start: 53)
			(gNarrator x: 20 y: 104)
			(self setScript: clickOnPeople)
		)
		(super doVerb: theVerb)
	)
)

(instance bobFischbach of Prop
	(properties
		x 252
		y 158
		noun 5
		view 138
		cel 15
		priority 10
		signal 16
	)

	(method (doVerb theVerb &tmp [temp0 20])
		(if (== theVerb 1) ; Look
			(clickOnPeople start: 49)
			(gNarrator x: 140 y: 83)
			(self setScript: clickOnPeople)
		)
		(super doVerb: theVerb)
	)
)

(instance jonBock of Prop
	(properties
		x 270
		y 139
		noun 22
		view 138
		cel 3
		signal 16384
	)

	(method (doVerb theVerb &tmp [temp0 20])
		(if (== theVerb 1) ; Look
			(clickOnPeople start: 45)
			(gNarrator x: 190 y: 64)
			(self setScript: clickOnPeople)
		)
		(super doVerb: theVerb)
	)
)

(instance jerryMoore of Prop
	(properties
		x 304
		y 137
		noun 21
		view 138
		cel 2
		signal 16384
	)

	(method (doVerb theVerb &tmp [temp0 20])
		(if (== theVerb 1) ; Look
			(clickOnPeople start: 41)
			(gNarrator x: 215 y: 59)
			(self setScript: clickOnPeople)
		)
		(super doVerb: theVerb)
	)
)

(instance gloria of Prop
	(properties
		x 284
		y 123
		noun 16
		view 138
		cel 5
		signal 16384
	)

	(method (doVerb theVerb &tmp [temp0 20])
		(if (== theVerb 1) ; Look
			(clickOnPeople start: 37)
			(gNarrator x: 177 y: 50)
			(self setScript: clickOnPeople)
		)
		(super doVerb: theVerb)
	)
)

(instance vana of Prop
	(properties
		x 299
		y 119
		noun 35
		view 138
		cel 14
		signal 16384
	)

	(method (doVerb theVerb &tmp [temp0 20])
		(if (== theVerb 1) ; Look
			(clickOnPeople start: 33)
			(gNarrator x: 216 y: 47)
			(self setScript: clickOnPeople)
		)
		(super doVerb: theVerb)
	)
)

(instance wilWong of Prop
	(properties
		x 269
		y 46
		noun 36
		view 138
		cel 1
		priority 4
		signal 16
	)

	(method (doVerb theVerb &tmp [temp0 20])
		(if (== theVerb 1) ; Look
			(clickOnPeople start: 29)
			(gNarrator x: 153 y: 30)
			(self setScript: clickOnPeople)
		)
		(super doVerb: theVerb)
	)
)

(instance diana of Prop
	(properties
		x 295
		y 54
		noun 12
		view 138
		cel 7
		signal 16384
	)

	(method (doVerb theVerb &tmp [temp0 20])
		(if (== theVerb 1) ; Look
			(clickOnPeople start: 25)
			(gNarrator x: 169 y: 0)
			(self setScript: clickOnPeople)
		)
		(super doVerb: theVerb)
	)
)

(instance jeffCrowe of Prop
	(properties
		x 241
		y 77
		noun 20
		view 138
		cel 4
		signal 16384
	)

	(method (doVerb theVerb &tmp [temp0 20])
		(if (== theVerb 1) ; Look
			(clickOnPeople start: 21)
			(gNarrator x: 137 y: 0)
			(self setScript: clickOnPeople)
		)
		(super doVerb: theVerb)
	)
)

(instance ericKasner of Prop
	(properties
		x 190
		y 39
		noun 14
		view 138
		cel 6
		signal 16384
	)

	(method (doVerb theVerb &tmp [temp0 20])
		(if (== theVerb 1) ; Look
			(clickOnPeople start: 17)
			(gNarrator x: 75 y: 0)
			(self setScript: clickOnPeople)
		)
		(super doVerb: theVerb)
	)
)

(instance arturo of Prop
	(properties
		x 102
		y 104
		noun 1
		view 138
		priority 4
		signal 16
	)

	(method (doVerb theVerb &tmp [temp0 20])
		(if (== theVerb 1) ; Look
			(clickOnPeople start: 1)
			(gNarrator x: 22 y: 26)
			(self setScript: clickOnPeople)
		)
		(super doVerb: theVerb)
	)
)

(instance richardP of Prop
	(properties
		x 24
		y 51
		noun 31
		view 138
		cel 11
		signal 16384
	)

	(method (doVerb theVerb &tmp [temp0 20])
		(if (== theVerb 1) ; Look
			(clickOnPeople start: 13)
			(gNarrator x: 22 y: 10)
			(self setScript: clickOnPeople)
		)
		(super doVerb: theVerb)
	)
)

(instance rogerHardy of Prop
	(properties
		x 158
		y 129
		noun 32
		view 138
		cel 10
		priority 4
		signal 16
	)

	(method (doVerb theVerb &tmp [temp0 20])
		(if (== theVerb 1) ; Look
			(clickOnPeople start: 9)
			(gNarrator x: 63 y: 57)
			(self setScript: clickOnPeople)
		)
		(super doVerb: theVerb)
	)
)

(instance richardA of Prop
	(properties
		x 288
		y 157
		noun 30
		view 138
		cel 12
		signal 16384
	)

	(method (doVerb theVerb &tmp [temp0 20])
		(if (== theVerb 1) ; Look
			(clickOnPeople start: 5)
			(gNarrator x: 158 y: 79)
			(self setScript: clickOnPeople)
		)
		(super doVerb: theVerb)
	)
)

(instance awardScript of Script
	(properties)

	(method (init)
		(if (IsFlag 170)
			(baronette addToPic:)
		)
		(elsa addToPic:)
		(minotaur cel: (if (IsFlag 237) 0 else 1))
		(sheriffAndOtto addToPic:)
		(karl addToPic:)
		(kattaAndAbdul addToPic:)
		(thiefAndCrusher addToPic:)
		(centaurs addToPic:)
		(swordmaster addToPic:)
		(erasmusAndFenrus addToPic:)
		(shopkeeperAndZara addToPic:)
		(hermitAndHealer addToPic:)
		(grannyAndCat addToPic:)
		(guildmaster addToPic:)
		(bartender addToPic:)
		(minotaur addToPic:)
		(super init: &rest)
	)

	(method (handleEvent event)
		(cond
			((and (== state 0) (or (== (event type:) evMOUSEBUTTON) (== (event type:) evKEYBOARD)))
				(= seconds 10)
			)
			((and (== state 0) (== seconds 0))
				(HandsOff)
				(self cue:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(yoric hide:)
				(= seconds 10)
			)
			(1
				(= seconds 3)
			)
			(2
				(gGame setCursor: gWaitCursor 1)
				(User canInput: 0)
				(HandsOff)
				(yoric
					show:
					illegalBits: 0
					setLoop: 5
					setCycle: Fwd
					cycleSpeed: 9
					setMotion: MoveTo 130 153 self
				)
			)
			(3
				(yoric setLoop: 5 setCel: 0)
				(= cycles 3)
			)
			(4
				(yoric setCel: 0 stopUpd:)
				(baron cycleSpeed: 11 setCycle: End self)
				(gNarrator x: 60 y: 137)
			)
			(5
				(ourHero cycleSpeed: 9 setCycle: End self)
				(baron addToPic:)
				(gMessager say: 26 57) ; "You have defeated the brigands And become a true Hero of Spielburg."
			)
			(6
				(gNarrator x: -1 y: -1)
				(gCurRoom newRoom: 602) ; EndGame2
				(self dispose:)
			)
		)
	)
)

(instance clickOnPeople of Script
	(properties)

	(method (init)
		(User canInput: 0)
		(gGame setCursor: gWaitCursor 1)
		(super init: &rest)
	)

	(method (dispose)
		(User canInput: 1)
		(gGame setCursor: 941 1)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				1
				(gMessager say: 1 1) ; "Arturo Sinclair"
				(= seconds 1)
			)
			(1
				2
				(arturo forceUpd: loop: 1 cel: 0)
				(= seconds 2)
			)
			(2
				3
				(arturo forceUpd: loop: 0 cel: 0)
				(= cycles 1)
			)
			(3
				4
				(self dispose:)
			)
			(4
				5
				(gMessager say: 30 1) ; "Richard Aronson"
				(= seconds 1)
			)
			(5
				6
				(richardA forceUpd: loop: 1 cel: 12)
				(= seconds 2)
			)
			(6
				7
				(richardA forceUpd: loop: 0 cel: 12)
				(= cycles 1)
			)
			(7
				8
				(self dispose:)
			)
			(8
				9
				(gMessager say: 32 1) ; "Roger Hardy"
				(= seconds 1)
			)
			(9
				10
				(rogerHardy forceUpd: loop: 1 cel: 10)
				(= seconds 2)
			)
			(10
				11
				(rogerHardy forceUpd: loop: 0 cel: 10)
				(= cycles 1)
			)
			(11
				12
				(self dispose:)
			)
			(12
				13
				(gMessager say: 31 1) ; "Richard Powell"
				(= seconds 1)
			)
			(13
				14
				(richardP forceUpd: loop: 1 cel: 11)
				(= seconds 2)
			)
			(14
				15
				(richardP forceUpd: loop: 0 cel: 11)
				(= cycles 1)
			)
			(15
				16
				(self dispose:)
			)
			(16
				17
				(gMessager say: 14 1) ; "Eric Kasner"
				(= seconds 1)
			)
			(17
				18
				(ericKasner forceUpd: loop: 1 cel: 6)
				(= seconds 2)
			)
			(18
				19
				(ericKasner forceUpd: loop: 0 cel: 6)
				(= cycles 1)
			)
			(19
				20
				(self dispose:)
			)
			(20
				21
				(gMessager say: 20 1) ; "Jeff Crowe"
				(= seconds 1)
			)
			(21
				22
				(jeffCrowe forceUpd: loop: 1 cel: 4)
				(= seconds 2)
			)
			(22
				23
				(jeffCrowe forceUpd: loop: 0 cel: 4)
				(= cycles 1)
			)
			(23
				24
				(self dispose:)
			)
			(24
				25
				(gMessager say: 12 1) ; "Diana Wilson"
				(= seconds 1)
			)
			(25
				26
				(diana forceUpd: loop: 1 cel: 7)
				(= seconds 2)
			)
			(26
				27
				(diana forceUpd: loop: 0 cel: 7)
				(= cycles 1)
			)
			(27
				28
				(self dispose:)
			)
			(28
				29
				(gMessager say: 36 1) ; "Willis Wong"
				(= seconds 1)
			)
			(29
				30
				(wilWong forceUpd: loop: 1 cel: 1)
				(= seconds 2)
			)
			(30
				31
				(wilWong forceUpd: loop: 0 cel: 1)
				(= cycles 1)
			)
			(31
				32
				(self dispose:)
			)
			(32
				33
				(gMessager say: 35 1) ; "Vana Baker"
				(= seconds 1)
			)
			(33
				34
				(vana forceUpd: loop: 1 cel: 14)
				(= seconds 2)
			)
			(34
				35
				(vana forceUpd: loop: 0 cel: 14)
				(= cycles 1)
			)
			(35
				36
				(self dispose:)
			)
			(36
				37
				(gMessager say: 16 1) ; "Gloria Garland"
				(= seconds 1)
			)
			(37
				38
				(gloria forceUpd: loop: 1 cel: 5)
				(= seconds 2)
			)
			(38
				39
				(gloria forceUpd: loop: 0 cel: 5)
				(= cycles 1)
			)
			(39
				40
				(self dispose:)
			)
			(40
				41
				(gMessager say: 21 1) ; "Jerry Moore"
				(= seconds 1)
			)
			(41
				42
				(jerryMoore forceUpd: loop: 1 cel: 2)
				(= seconds 2)
			)
			(42
				43
				(jerryMoore forceUpd: loop: 0 cel: 2)
				(= cycles 1)
			)
			(43
				44
				(self dispose:)
			)
			(44
				45
				(gMessager say: 22 1) ; "Jon Bock"
				(= seconds 1)
			)
			(45
				46
				(jonBock forceUpd: loop: 1 cel: 3)
				(= seconds 2)
			)
			(46
				47
				(jonBock forceUpd: loop: 0 cel: 3)
				(= cycles 1)
			)
			(47
				48
				(self dispose:)
			)
			(48
				49
				(gMessager say: 5 1) ; "Bob Fischbach"
				(= seconds 1)
			)
			(49
				50
				(bobFischbach forceUpd: loop: 1 cel: 15)
				(= seconds 2)
			)
			(50
				51
				(bobFischbach forceUpd: loop: 0 cel: 15)
				(= cycles 1)
			)
			(51
				52
				(self dispose:)
			)
			(52
				53
				(gMessager say: 6 1) ; "Bob Mallory"
				(= seconds 1)
			)
			(53
				54
				(bobMallory forceUpd: loop: 3 cel: 15)
				(= seconds 2)
			)
			(54
				55
				(bobMallory forceUpd: loop: 2 cel: 15)
				(= cycles 1)
			)
			(55
				56
				(self dispose:)
			)
			(56
				57
				(gMessager say: 34 1) ; "Tom DeSalvo"
				(= seconds 1)
			)
			(57
				58
				(tom forceUpd: loop: 1 cel: 13)
				(= seconds 2)
			)
			(58
				59
				(tom forceUpd: loop: 0 cel: 13)
				(= cycles 1)
			)
			(59
				60
				(self dispose:)
			)
			(60
				61
				(gMessager say: 28 1) ; "Oliver Brelsford"
				(= seconds 1)
			)
			(61
				62
				(oliver forceUpd: loop: 3 cel: 2)
				(= seconds 2)
			)
			(62
				63
				(oliver forceUpd: loop: 2 cel: 2)
				(= cycles 1)
			)
			(63
				64
				(self dispose:)
			)
			(64
				65
				(gMessager say: 10 1) ; "Corey Cole"
				(= seconds 1)
			)
			(65
				66
				(coreyCole forceUpd: loop: 1 cel: 9)
				(= seconds 2)
			)
			(66
				67
				(coreyCole forceUpd: loop: 0 cel: 9)
				(= cycles 1)
			)
			(67
				68
				(self dispose:)
			)
			(68
				69
				(gMessager say: 25 1) ; "Lori Ann Cole"
				(= seconds 1)
			)
			(69
				70
				(loriCole forceUpd: loop: 1 cel: 8)
				(= seconds 2)
			)
			(70
				71
				(loriCole forceUpd: loop: 0 cel: 8)
				(= cycles 1)
			)
			(71
				72
				(self dispose:)
			)
			(72
				73
				(gMessager say: 7 1) ; "Carlos Escobar"
				(= seconds 1)
			)
			(73
				74
				(carlos forceUpd: loop: 3 cel: 1)
				(= seconds 2)
			)
			(74
				75
				(carlos forceUpd: loop: 2 cel: 1)
				(= cycles 1)
			)
			(75
				76
				(self dispose:)
			)
		)
	)
)

