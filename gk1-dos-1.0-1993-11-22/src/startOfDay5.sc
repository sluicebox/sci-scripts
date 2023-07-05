;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 212)
(include sci.sh)
(use Main)
(use n013)
(use GKEgo)
(use GKNarrator)
(use Inset)
(use ROsc)
(use Osc)
(use RandCycle)
(use PolyPath)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	startOfDay5 1
	getNote 2
	startOfDay3 3
	endOfDay3 4
	getTheGermanBook 5
	getNumFromGrace 6
	getScale 7
	lookAtScale 8
	graceGetsScale 9
	getSnakeBook 10
)

(local
	local0
)

(instance startOfDay3 of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event &rest)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_SPACE) (SkipSceneDialog))
			(gMessager caller: 0)
			(gMessager killed: 1)
			(if (gTalkers size:)
				(gMessager cue: 1)
			)
			(if (gEgo cycler:)
				(gEgo setCycle: 0)
			)
			(if ((ScriptID 210 1) cycler:) ; graceProp
				((ScriptID 210 1) setCycle: 0) ; graceProp
			)
			(self changeState: 99)
			(return 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 10)
				(gKeyDownHandler add: self)
				(gGame handsOff:)
				((ScriptID 210 1) ; graceProp
					init:
					view: 208
					setCel: 0
					setLoop: 1
					cycleSpeed: 8
					setCycle: End
				)
				(gEgo
					view: 212
					setCel: 0
					setLoop: 0
					posn: 291 123
					setSpeed: 11
					setCycle: CT 2 1 self
				)
			)
			(1
				(gEgo view: 212 setCel: 3 setLoop: 0 setCycle: End self)
				(gGkSound1 number: 215 play:)
			)
			(2
				((ScriptID 210 1) setCel: 4 setLoop: 0 setCycle: Beg self) ; graceProp
			)
			(3
				(gMessager say: 11 0 38 1 self) ; "(ARCC)I'm so glad you could join us today. I've got messages when you want them."
			)
			(4
				(gEgo setCel: 0 setLoop: 1 posn: 271 151 setCycle: End self)
			)
			(5
				(gMessager say: 11 0 38 2 self) ; "(IRRITATED)Mmmm."
			)
			(6
				(gMessager say: 11 0 38 3 self) ; "I also checked out Cazaunoux. There are multiple listings in the white pages. I got the page, but you'll have to figure out the right one."
				(gEgo normalize: 1 901)
			)
			(7
				(gEgo setCycle: StopWalk -1 setMotion: MoveTo 187 125 self)
			)
			(8
				(Face gEgo (ScriptID 210 1) self) ; graceProp
			)
			(9
				((ScriptID 210 1) ; graceProp
					view: 2131
					setCel: 0
					setLoop: 4
					setCycle: CT 3 1 self
				)
				(gEgo view: 2131 setCel: 0 setLoop: 1 setCycle: CT 3 1 self)
			)
			(10)
			(11
				((ScriptID 210 1) view: 2131 setCel: 4 setLoop: 4 setCycle: End) ; graceProp
				(gEgo view: 2131 setCel: 4 setLoop: 1 setCycle: End self)
			)
			(12
				(gEgo normalize: 0 901 get: 7 getPoints: 471 1) ; phonePage
				(gMessager say: 11 0 38 4 self) ; "Great. Thanks."
			)
			(13
				(gEgo
					setSpeed: 6
					setCycle: StopWalk -1
					setMotion: MoveTo 137 138 self
				)
			)
			(14
				(gEgo
					view: 215
					setCel: 0
					setLoop: 0
					posn: 81 139
					setSpeed: 10
					setCycle: CT 1 1 self
				)
			)
			(15
				((ScriptID 210 2) dispose:) ; gabsMug
				(gEgo setCel: 2 setLoop: 0 setCycle: End self)
			)
			(16
				(gEgo setCel: 0 setLoop: 1 setCycle: CT 4 1 self)
			)
			(17
				((ScriptID 210 3) hide:) ; coffeePot
				(gEgo setCel: 5 setLoop: 1 setCycle: End self)
				(gGkSound1 number: 214 play:)
			)
			(18
				(gEgo setCel: 0 setLoop: 2 setCycle: CT 4 1 self)
			)
			(19
				((ScriptID 210 3) show:) ; coffeePot
				(gEgo setCel: 5 setLoop: 2 setCycle: End self)
			)
			(20
				(gEgo posn: 81 141 setCel: 0 setLoop: 5 setCycle: End self)
			)
			(21
				(SetFlag 311)
				(gEgo view: 215 setCel: 6 setLoop: 6 posn: 150 123)
				(gMessager sayRange: 11 0 38 5 8 self) ; "(RRCC. FISHING FOR INFO)Now. Are you going to tell me what happened yesterday with Malia Gedde, or is it just too embarrassing?"
			)
			(22
				(gEgo view: 2151 setCel: 0 setLoop: 0 setCycle: Osc 1 self)
			)
			(23
				(gEgo view: 215 setCel: 6 setLoop: 6 posn: 150 123)
				(gMessager sayRange: 11 0 38 9 17 self) ; "Gabriel! You don't SERIOUSLY think she's interested. She can have any man in the city! You know, men with bank accounts!"
			)
			(24
				(gEgo view: 2151 setCel: 0 setLoop: 1 setCycle: End self)
			)
			(25
				(gEgo setCel: 0 setLoop: 2)
				((ScriptID 210 2) init:) ; gabsMug
				(= cycles 1)
			)
			(26
				((ScriptID 210 1) setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
				(gEgo setCel: 1 setLoop: 2 setCycle: CT 3 1 self)
			)
			(27
				(gKeyDownHandler delete: self)
				(ClearFlag 311)
				(gEgo
					normalize: 0 901
					posn: 127 137
					ignoreActors: 1
					setMotion: MoveTo 131 137
				)
				(gGame handsOn:)
				(self dispose:)
			)
			(99
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(for ((= local0 100)) (>= local0 0) ((-= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 15)
			)
			(100
				(gEgo
					normalize: 0 901
					get: 7 ; phonePage
					ignoreActors: 1
					getPoints: 471 1
					posn: 131 137
				)
				((ScriptID 210 1) posn: 251 115 setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
				(if (not (gCast contains: (ScriptID 210 2))) ; gabsMug
					((ScriptID 210 2) init:) ; gabsMug
				)
				(if (not ((ScriptID 210 3) isNotHidden:)) ; coffeePot
					((ScriptID 210 3) show:) ; coffeePot
				)
				(= cycles 1)
			)
			(101
				(for ((= local0 0)) (<= local0 100) ((+= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(ClearFlag 311)
				(SetFlag 10)
				(gKeyDownHandler delete: self)
				(= cycles 2)
			)
			(102
				(gGame handsOn:)
				(self dispose:)
				(DisposeScript 212)
			)
		)
	)
)

(instance endOfDay3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					posn: 110 102
					setCycle: 0
					view: 218
					setCel: 0
					setLoop: 0 1
					setPri: 100
				)
				(egoHead init:)
				(maliaHead init:)
				(= cycles 2)
			)
			(1
				(egoHead setCycle: RandCycle)
				(gMessager say: 11 0 37 1 self) ; "(THROATY. TURNED ON)You came. I didn't think you would."
			)
			(2
				(egoHead setCel: 0 setCycle: 0)
				(maliaHead setCycle: RandCycle)
				(gMessager say: 11 0 37 2 self) ; "(SOFT)I didn't think I would either."
			)
			(3
				(maliaHead setCel: 0 setCycle: 0)
				(egoHead setCycle: RandCycle)
				(gMessager say: 11 0 37 3 self) ; "(SEXY, NERVOUS)Your eyes.... Mmmm.... Uh, I could show you around a little. It's not much, but...."
			)
			(4
				(egoHead setCel: 0 setCycle: 0)
				(maliaHead setCycle: RandCycle)
				(gMessager say: 11 0 37 4 self) ; "(INTERRUPTING. FOCUSED ON GABRIEL)Please, don't. I couldn't focus on much of anything right now."
			)
			(5
				(maliaHead setCel: 0 setCycle: 0)
				(egoHead setCycle: RandCycle)
				(gMessager say: 11 0 37 5 self) ; "(HONEST, AMAZED)Yeah, I know. God, what IS it about you?"
			)
			(6
				(egoHead setCel: 0 setCycle: 0)
				(maliaHead setCycle: RandCycle)
				(gMessager say: 11 0 37 6 self) ; "(IN HEAT)Just shut up and kiss me."
			)
			(7
				(egoHead dispose:)
				(maliaHead dispose:)
				(gEgo setCel: 0 setLoop: 1 setCycle: End self)
			)
			(8
				(gEgo setCel: 0 setLoop: 2 setCycle: End self)
			)
			(9
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance startOfDay5 of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event &rest)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_SPACE) (SkipSceneDialog))
			(gMessager caller: 0)
			(gMessager killed: 1)
			(if (gTalkers size:)
				(gMessager cue: 1)
			)
			(if (gEgo cycler:)
				(gEgo setCycle: 0)
			)
			(if ((ScriptID 210 1) cycler:) ; graceProp
				((ScriptID 210 1) setCycle: 0) ; graceProp
			)
			(self changeState: 99)
			(return 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKeyDownHandler add: self)
				((ScriptID 210 5) hide:) ; gabsCoat
				(gGame handsOff:)
				((ScriptID 210 1) init: setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
				(package init:)
				((ScriptID 210 21) hide:) ; shopDoor
				(gEgo
					view: 219
					setCel: 0
					setLoop: 2
					posn: 101 93
					setCycle: End self
				)
				(gGkSound1 number: 373 setLoop: 1 play: self)
			)
			(1)
			(2
				((ScriptID 210 21) show:) ; shopDoor
				(gGkSound2 number: 374 setLoop: 1 play:)
				(gEgo posn: 88 97 setCel: 0 setLoop: 3 setCycle: End self)
			)
			(3
				((ScriptID 210 4) dispose:) ; graceDoStuff
				((ScriptID 210 1) ; graceProp
					view: 2111
					setCel: 8
					setLoop: 0
					cycleSpeed: 8
					setCycle: CT 5 -1
				)
				((ScriptID 210 5) show:) ; gabsCoat
				(gEgo
					normalize: 0 901
					ignoreActors: 1
					setMotion: MoveTo 98 97 self
				)
			)
			(4
				(gEgo
					view: 901
					setSpeed: 6
					setCycle: StopWalk -1
					setMotion: MoveTo 137 138 self
				)
			)
			(5
				(gEgo
					view: 215
					setCel: 0
					setLoop: 0
					posn: 81 139
					setSpeed: 10
					setCycle: CT 1 1 self
				)
			)
			(6
				((ScriptID 210 2) dispose:) ; gabsMug
				(gEgo view: 215 setCel: 2 setLoop: 0 setCycle: End self)
			)
			(7
				(gEgo view: 215 setCel: 0 setLoop: 1 setCycle: CT 4 1 self)
			)
			(8
				((ScriptID 210 3) hide:) ; coffeePot
				(gEgo view: 215 setCel: 5 setLoop: 1 setCycle: End self)
				(gGkSound1 number: 214 setLoop: 1 play:)
			)
			(9
				(gEgo setCel: 0 setLoop: 2 setCycle: CT 4 1 self)
			)
			(10
				((ScriptID 210 3) show:) ; coffeePot
				(gEgo setCel: 5 setLoop: 2 setCycle: End self)
			)
			(11
				(gEgo setCel: 0 setLoop: 3 setCycle: Osc 1 self)
			)
			(12
				(gMessager say: 11 0 41 1 self) ; "Are you OK, Gabriel?"
				((ScriptID 210 1) ; graceProp
					view: 2111
					setCel: 0
					setLoop: 0
					setCycle: ROsc -1 0 4
				)
			)
			(13
				((ScriptID 210 1) setCel: 0 setCycle: 0) ; graceProp
				(gMessager say: 11 0 41 2 self) ; "<yawn> Sure. Great. Why?"
				(gEgo view: 2150 setCel: 0 setLoop: 0 setCycle: RandCycle)
			)
			(14
				(gMessager say: 11 0 41 3 self) ; "I'm worried about you."
				((ScriptID 210 1) setCel: 0 setLoop: 0 setCycle: ROsc -1 0 4) ; graceProp
				(gEgo view: 215 setCel: 0 setLoop: 3 setCycle: Osc 1 self)
			)
			(15)
			(16
				((ScriptID 210 1) setCel: 0 setCycle: 0) ; graceProp
				(gMessager say: 11 0 41 4 self) ; "If I were any better, Grace, I'd be dead. Now what's up?"
				(gEgo view: 2150 setCel: 0 setLoop: 0 setCycle: RandCycle)
			)
			(17
				(if
					(or
						(IsFlag 73)
						(and (IsFlag 36) (not (gEgo has: 9))) ; news1810
					)
					(gKeyDownHandler delete: self)
					(gEgo setScript: getTheVeve)
					(self dispose:)
				else
					(gEgo setCel: 0 setCycle: 0)
					(gMessager say: 11 0 42 1 self) ; "You got another package this morning. Fed. Ex. from Germany."
					((ScriptID 210 1) ; graceProp
						view: 2111
						setCel: 0
						setLoop: 0
						setCycle: ROsc -1 0 4
					)
				)
			)
			(18
				((ScriptID 210 1) setCel: 0 setCycle: 0) ; graceProp
				(gEgo view: 215 setCel: 0 setLoop: 4 setCycle: CT 3 1 self)
			)
			(19
				((ScriptID 210 2) init: setPri: 14 posn: 86 120) ; gabsMug
				(gEgo setCel: 4 setLoop: 4 setCycle: End self)
			)
			(20
				(gEgo
					view: 901
					setSpeed: 6
					setCycle: StopWalk -1
					setMotion: MoveTo 109 127 self
				)
			)
			(21
				(gEgo
					view: 901
					setCycle: StopWalk -1
					setMotion: MoveTo 187 125 self
				)
			)
			(22
				(= cycles 4)
			)
			(23
				(gMessager say: 11 0 42 2 self) ; "I was expecting that. Where is it?"
			)
			(24
				((ScriptID 210 1) ; graceProp
					view: 213
					setCel: 0
					setLoop: 0
					setCycle: CT 2 1 self
				)
			)
			(25
				(package dispose:)
				((ScriptID 210 1) ; graceProp
					view: 213
					setCel: 3
					setLoop: 0
					setCycle: End self
				)
			)
			(26
				(gEgo hide:)
				(UpdateScreenItem (ScriptID 210 1)) ; graceProp
				(self cue:)
			)
			(27
				((ScriptID 210 1) ; graceProp
					setCel: 0
					setLoop: 1
					posn: 222 118
					setCycle: End self
				)
			)
			(28
				((ScriptID 210 1) view: 2111 setCel: 0 setLoop: 0 posn: 251 115) ; graceProp
				(UpdateScreenItem (ScriptID 210 1)) ; graceProp
				(gEgo show:)
				(gMessager say: 11 0 42 3 self) ; "Well...it kind of came open, but I salvaged the contents. There was a letter from your great uncle Wolfgang and a journal."
			)
			(29
				(gEgo
					normalize: 0 901
					ignoreActors: 1
					get: 10 11 ; guntJournal
					getPoints: 457 1
				)
				(gMessager sayRange: 11 0 42 4 6 self) ; "The package just 'came open,' huh? How'd you like the journal?"
			)
			(30
				(gMessager say: 11 0 42 7 self) ; "Just read the journal carefully, Gabriel. PLEASE."
				((ScriptID 210 1) ; graceProp
					view: 2111
					setCel: 0
					setLoop: 0
					setCycle: ROsc -1 0 4
				)
			)
			(31
				((ScriptID 210 1) setCel: 0 setCycle: 0) ; graceProp
				(gGkSound1 number: 2217 setLoop: 1 play: self)
			)
			(32
				(gEgo setMotion: PolyPath 277 106 self)
				(= cycles 3)
			)
			(33
				(gMessager say: 11 0 42 8) ; "(ENTHUSIASTIC GETTING PHONE--THINKS IT'S MALIA CALLING)I got it!"
			)
			(34
				(gEgo view: 2191 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(35
				(gMessager say: 11 0 42 9 self) ; "(OVERLY SEXY VOICE)St. George's Books."
			)
			(36
				(gEgo setCel: 0 setLoop: 1 setCycle: End self)
			)
			(37
				(gMessager say: 11 0 42 10 self) ; "(DISAPPOINTED)Oh. Professor Hartridge. I'm glad you called. Did you...."
			)
			(38
				(gEgo setCel: 0 setLoop: 2 setCycle: End self)
			)
			(39
				(gMessager sayRange: 11 0 42 11 16 self) ; "You did. Wait, slow down.... The Agris? Really? You think that's them?"
			)
			(40
				(gEgo setCel: 0 setLoop: 3 setCycle: End self)
			)
			(41
				(gEgo
					normalize: 1 901
					ignoreActors: 1
					setMotion: PolyPath 235 127 self
				)
			)
			(42
				(Face gEgo (ScriptID 210 1) self) ; graceProp
			)
			(43
				(gMessager sayRange: 11 0 42 17 20 self) ; "(VERY WORRIED)I wish you'd tell me what's going on. I swear, you're going to step into a hole you may never get out of."
			)
			(44
				(SetFlag 47)
				(SetFlag 48)
				(SetFlag 10)
				(gGame handsOn:)
				(gEgo ignoreActors: 1)
				((ScriptID 210 1) setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
				(gKeyDownHandler delete: self)
				(self dispose:)
			)
			(99
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(for ((= local0 100)) (>= local0 0) ((-= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 15)
			)
			(100
				(gEgo normalize: 1 901 ignoreActors: 1 posn: 277 106)
				(if (and (IsFlag 73) (not (gEgo has: 14))) ; drumBook
					(gEgo get: 14 getPoints: 456 1 0) ; drumBook
				)
				(if
					(or
						(IsFlag 73)
						(and (IsFlag 36) (not (gEgo has: 9))) ; news1810
					)
					(gEgo get: 9 10 11) ; news1810
					(gEgo getPoints: 455 1)
					(gEgo getPoints: 457 1 0)
				else
					(gEgo get: 10 11) ; guntJournal
					(gEgo getPoints: 457 1)
				)
				((ScriptID 210 1) posn: 251 115) ; graceProp
				(if (not ((ScriptID 210 1) script:)) ; graceProp
					((ScriptID 210 1) setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
				)
				(if (gCast contains: package)
					(package dispose:)
				)
				(if (not ((ScriptID 210 21) isNotHidden:)) ; shopDoor
					((ScriptID 210 21) show:) ; shopDoor
				)
				(if (not (gCast contains: (ScriptID 210 5))) ; gabsCoat
					((ScriptID 210 5) init:) ; gabsCoat
				)
				(if (not (gCast contains: (ScriptID 210 2))) ; gabsMug
					((ScriptID 210 2) init:) ; gabsMug
				)
				(if (not ((ScriptID 210 3) isNotHidden:)) ; coffeePot
					((ScriptID 210 3) show:) ; coffeePot
				)
				(= cycles 1)
			)
			(101
				(for ((= local0 0)) (<= local0 100) ((+= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(SetFlag 47)
				(SetFlag 48)
				(ClearFlag 311)
				(SetFlag 10)
				(gKeyDownHandler delete: self)
				(= cycles 2)
			)
			(102
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getTheVeve of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event &rest)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_SPACE) (SkipSceneDialog))
			(gMessager caller: 0)
			(gMessager killed: 1)
			(if (gTalkers size:)
				(gMessager cue: 1)
			)
			(if (gEgo cycler:)
				(gEgo setCycle: 0)
			)
			(if ((ScriptID 210 1) cycler:) ; graceProp
				((ScriptID 210 1) setCycle: 0) ; graceProp
			)
			(self changeState: 99)
			(return 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (not (gEgo has: 14)) (gEgo has: 9)) ; drumBook, news1810
					(self setScript: getTheDrumBook self)
				else
					(gMessager say: 11 0 45 1 self) ; "Did you find out anything about that pattern I gave you?"
					(gEgo
						view: 2150
						setCel: 0
						setLoop: 0
						setCycle: RandCycle
					)
				)
			)
			(1
				(gKeyDownHandler add: self)
				(if (IsFlag 73)
					(gEgo get: 14) ; drumBook
				)
				(if (and (not (gEgo has: 14)) (gEgo has: 9)) ; drumBook, news1810
					(self changeState: 12)
					(gEgo get: 14) ; drumBook
				else
					(gEgo setCel: 0 setCycle: 0)
					(gMessager say: 11 0 45 2 self) ; "(ARCC)Yeah. I did find something."
					((ScriptID 210 1) ; graceProp
						view: 2111
						setCel: 0
						setLoop: 0
						setCycle: ROsc -1 0 4
					)
				)
			)
			(2
				((ScriptID 210 1) ; graceProp
					view: 213
					setCel: 3
					setLoop: 0
					setCycle: End self
				)
			)
			(3
				(gEgo view: 215 setCel: 0 setLoop: 4 setCycle: CT 3 1 self)
			)
			(4
				((ScriptID 210 2) setPri: 14 init: posn: 86 120) ; gabsMug
				(gEgo setCel: 4 setLoop: 4 setCycle: End self)
			)
			(5
				(gEgo
					view: 901
					setSpeed: 6
					setCycle: StopWalk -1
					setMotion: MoveTo 187 125 self
				)
			)
			(6
				(gEgo hide:)
				((ScriptID 210 1) setLoop: 1 posn: 222 118 setCycle: End self) ; graceProp
				(UpdateScreenItem (ScriptID 210 1)) ; graceProp
			)
			(7
				((ScriptID 210 1) ; graceProp
					setCel: 0
					setLoop: 2
					posn: 251 115
					setCycle: End self
				)
				(UpdateScreenItem (ScriptID 210 1)) ; graceProp
				(gEgo show:)
			)
			(8
				(gEgo getPoints: 455 1)
				(gEgo normalize: 0 901)
				(UpdateScreenItem gEgo)
				(gMessager say: 11 0 45 3 self) ; "I checked the micro-fiche at the public library. I found an article about a murder in 1810. The newspaper published part of a pattern found around the body. It looks damn close."
				((ScriptID 210 1) setCel: 0 setLoop: 2 setCycle: RandCycle) ; graceProp
			)
			(9
				((ScriptID 210 1) setCycle: 0) ; graceProp
				(gMessager say: 11 0 45 4 self) ; "You're incredible. All that work..."
			)
			(10
				(gMessager say: 11 0 45 5 self) ; "(MIFFED BECAUSE HE'S DATING MALIA AND SHE FEELS MARTYRED)Forget it."
				((ScriptID 210 1) ; graceProp
					view: 213
					setCel: 0
					setLoop: 3
					posn: 251 115
					setCycle: RandCycle
				)
			)
			(11
				(if (IsFlag 73)
					((ScriptID 210 1) cel: 0 setCycle: 0) ; graceProp
					(self setScript: getTheDrumBook self)
				else
					(self cue:)
				)
			)
			(12
				(if (not (gEgo has: 9)) ; news1810
					(gEgo get: 9) ; news1810
				)
				(gMessager say: 11 0 42 1 self) ; "You got another package this morning. Fed. Ex. from Germany."
				((ScriptID 210 1) ; graceProp
					view: 2111
					setCel: 0
					setLoop: 0
					setCycle: ROsc -1 0 4
				)
			)
			(13
				((ScriptID 210 1) setCel: 0 setCycle: 0) ; graceProp
				(gMessager say: 11 0 42 2 self) ; "I was expecting that. Where is it?"
			)
			(14
				((ScriptID 210 1) ; graceProp
					view: 213
					setCel: 0
					setLoop: 0
					setCycle: CT 2 1 self
				)
			)
			(15
				(package dispose:)
				((ScriptID 210 1) ; graceProp
					view: 213
					setCel: 3
					setLoop: 0
					setCycle: End self
				)
			)
			(16
				(gEgo hide:)
				(UpdateScreenItem (ScriptID 210 1)) ; graceProp
				(self cue:)
			)
			(17
				((ScriptID 210 1) ; graceProp
					setCel: 0
					setLoop: 1
					posn: 222 118
					setCycle: End self
				)
			)
			(18
				((ScriptID 210 1) view: 2111 setCel: 0 setLoop: 0 posn: 251 115) ; graceProp
				(UpdateScreenItem (ScriptID 210 1)) ; graceProp
				(gEgo show:)
				(gMessager say: 11 0 42 3 self) ; "Well...it kind of came open, but I salvaged the contents. There was a letter from your great uncle Wolfgang and a journal."
			)
			(19
				(gEgo
					normalize: 0 901
					ignoreActors: 1
					get: 10 11 ; guntJournal
					getPoints: 457 1
				)
				(gMessager say: 11 0 42 4 self) ; "The package just 'came open,' huh? How'd you like the journal?"
			)
			(20
				(gMessager say: 11 0 42 5 self) ; "SOMEONE has to look after you. You're in trouble, in case you don't know it."
			)
			(21
				(gMessager say: 11 0 42 6 self) ; "Yeah, you've been reading my horoscope again, haven't you, Grace?"
			)
			(22
				(gMessager say: 11 0 42 7 self) ; "Just read the journal carefully, Gabriel. PLEASE."
				((ScriptID 210 1) ; graceProp
					view: 2111
					setCel: 0
					setLoop: 0
					setCycle: ROsc -1 0 4
				)
			)
			(23
				((ScriptID 210 1) setCel: 0 setCycle: 0) ; graceProp
				(gGkSound1 number: 2217 setLoop: 1 play: self)
			)
			(24
				(gEgo setMotion: PolyPath 277 106 self)
				(= cycles 3)
			)
			(25
				(gMessager say: 11 0 42 8) ; "(ENTHUSIASTIC GETTING PHONE--THINKS IT'S MALIA CALLING)I got it!"
			)
			(26
				(gEgo view: 2191 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(27
				(gMessager say: 11 0 42 9 self) ; "(OVERLY SEXY VOICE)St. George's Books."
			)
			(28
				(gEgo setCel: 0 setLoop: 1 setCycle: End self)
			)
			(29
				(gMessager say: 11 0 42 10 self) ; "(DISAPPOINTED)Oh. Professor Hartridge. I'm glad you called. Did you...."
			)
			(30
				(gEgo setCel: 0 setLoop: 2 setCycle: End self)
			)
			(31
				(gMessager sayRange: 11 0 42 11 16 self) ; "You did. Wait, slow down.... The Agris? Really? You think that's them?"
			)
			(32
				(gEgo setCel: 0 setLoop: 3 setCycle: End self)
			)
			(33
				(gEgo
					normalize: 1 901
					ignoreActors: 1
					setMotion: PolyPath 235 127 self
				)
			)
			(34
				(Face gEgo (ScriptID 210 1) self) ; graceProp
			)
			(35
				(gMessager sayRange: 11 0 42 17 20 self) ; "(VERY WORRIED)I wish you'd tell me what's going on. I swear, you're going to step into a hole you may never get out of."
			)
			(36
				(gKeyDownHandler delete: self)
				(SetFlag 47)
				(SetFlag 48)
				(SetFlag 10)
				(gGame handsOn:)
				(gEgo ignoreActors: 1)
				((ScriptID 210 1) setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
				(self dispose:)
			)
			(99
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(for ((= local0 100)) (>= local0 0) ((-= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 15)
			)
			(100
				(gEgo normalize: 1 901 ignoreActors: 1 posn: 277 106)
				(if (and (IsFlag 73) (not (gEgo has: 14))) ; drumBook
					(gEgo get: 14 getPoints: 456 1 0) ; drumBook
				)
				(if
					(or
						(IsFlag 73)
						(and (IsFlag 36) (not (gEgo has: 9))) ; news1810
					)
					(gEgo get: 9 10 11) ; news1810
					(gEgo getPoints: 455 1)
					(gEgo getPoints: 457 1 0)
				else
					(gEgo get: 10 11) ; guntJournal
					(gEgo getPoints: 457 1)
				)
				((ScriptID 210 1) posn: 251 115) ; graceProp
				(if (not ((ScriptID 210 1) script:)) ; graceProp
					((ScriptID 210 1) setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
				)
				(if (gCast contains: package)
					(package dispose:)
				)
				(if (not ((ScriptID 210 21) isNotHidden:)) ; shopDoor
					((ScriptID 210 21) show:) ; shopDoor
				)
				(if (not (gCast contains: (ScriptID 210 5))) ; gabsCoat
					((ScriptID 210 5) init:) ; gabsCoat
				)
				(if (not (gCast contains: (ScriptID 210 2))) ; gabsMug
					((ScriptID 210 2) init:) ; gabsMug
				)
				(if (not ((ScriptID 210 3) isNotHidden:)) ; coffeePot
					((ScriptID 210 3) show:) ; coffeePot
				)
				(= cycles 1)
			)
			(101
				(for ((= local0 0)) (<= local0 100) ((+= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(SetFlag 47)
				(SetFlag 48)
				(ClearFlag 311)
				(SetFlag 10)
				(gKeyDownHandler delete: self)
				(= cycles 2)
			)
			(102
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getTheDrumBook of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event &rest)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_SPACE) (SkipSceneDialog))
			(gMessager caller: 0)
			(gMessager killed: 1)
			(if (gTalkers size:)
				(gMessager cue: 1)
			)
			(if (gEgo cycler:)
				(gEgo setCycle: 0)
			)
			(if ((ScriptID 210 1) cycler:) ; graceProp
				((ScriptID 210 1) setCycle: 0) ; graceProp
			)
			(self changeState: 99)
			(return 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKeyDownHandler add: self)
				(gEgo setCel: 0 setCycle: 0)
				(gMessager say: 11 0 68 1 self 210) ; "We got that book you ordered in this morning--the one on Rada drums."
			)
			(1
				(if (and (not (gEgo has: 14)) (gEgo has: 9)) ; drumBook, news1810
					(gEgo
						view: 215
						setCel: 0
						setLoop: 4
						setCycle: CT 3 1 self
					)
				else
					(self changeState: 4)
				)
			)
			(2
				((ScriptID 210 2) posn: 86 120 setPri: 14 init:) ; gabsMug
				(gEgo setCel: 4 setLoop: 4 setCycle: End self)
			)
			(3
				(gEgo
					view: 901
					setSpeed: 6
					setCycle: StopWalk -1
					setMotion: MoveTo 187 125 self
				)
			)
			(4
				(gMessager say: 11 0 68 2 self 210) ; "Really? Great!"
			)
			(5
				(gEgo hide:)
				((ScriptID 210 1) ; graceProp
					view: 213
					setCel: 0
					setLoop: 1
					posn: 222 118
					setCycle: End self
				)
				(UpdateScreenItem (ScriptID 210 1)) ; graceProp
			)
			(6
				((ScriptID 210 1) view: 2111 setCel: 0 setLoop: 0 posn: 251 115) ; graceProp
				(UpdateScreenItem (ScriptID 210 1)) ; graceProp
				(gEgo show:)
				(= cycles 1)
			)
			(7
				(gKeyDownHandler delete: self)
				(gEgo getPoints: 456 1)
				(gEgo normalize: 0 901 ignoreActors: 1)
				(self dispose:)
			)
			(99
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(for ((= local0 100)) (>= local0 0) ((-= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 15)
			)
			(100
				(if (gKeyDownHandler contain: getTheVeve)
					(gKeyDownHandler delete: getTheVeve)
				)
				(gEgo normalize: 1 901 ignoreActors: 1 posn: 277 106)
				(if
					(or
						(IsFlag 73)
						(and (IsFlag 36) (not (gEgo has: 9))) ; news1810
					)
					(gEgo get: 9 14 10 11) ; news1810
					(gEgo getPoints: 455 1)
					(gEgo getPoints: 456 1 0)
					(gEgo getPoints: 457 1 0)
				else
					(gEgo get: 10 11) ; guntJournal
					(gEgo getPoints: 457 1)
				)
				((ScriptID 210 1) posn: 251 115) ; graceProp
				(if (not ((ScriptID 210 1) script:)) ; graceProp
					((ScriptID 210 1) setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
				)
				(if (gCast contains: package)
					(package dispose:)
				)
				(if (not ((ScriptID 210 21) isNotHidden:)) ; shopDoor
					((ScriptID 210 21) show:) ; shopDoor
				)
				(if (not (gCast contains: (ScriptID 210 5))) ; gabsCoat
					((ScriptID 210 5) init:) ; gabsCoat
				)
				(if (not (gCast contains: (ScriptID 210 2))) ; gabsMug
					((ScriptID 210 2) init:) ; gabsMug
				)
				(if (not ((ScriptID 210 3) isNotHidden:)) ; coffeePot
					((ScriptID 210 3) show:) ; coffeePot
				)
				(= cycles 1)
			)
			(101
				(for ((= local0 0)) (<= local0 100) ((+= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(SetFlag 47)
				(SetFlag 48)
				(ClearFlag 311)
				(SetFlag 10)
				(gKeyDownHandler delete: self)
				(= cycles 2)
			)
			(102
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getNote of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 241 122 self)
			)
			(1
				(if (IsFlag 409)
					(self changeState: 6)
				else
					(Face gEgo (ScriptID 210 14) self) ; maliasNote
				)
			)
			(2
				((ScriptID 210 14) hide:) ; maliasNote
				(gEgo view: 2161 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(3
				(gMessager say: 33 12 0 0 self 211) ; "The note is from Malia. It says:"
			)
			(4
				(gEgo getPoints: 158 1)
				(gEgo setCycle: Beg self)
			)
			(5
				((ScriptID 210 14) show:) ; maliasNote
				(if (IsFlag 389)
					(gEgo normalize: 1 901)
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(6
				(ClearFlag 409)
				(gEgo view: 2161 setCel: 0 setLoop: 1 setCycle: End self)
			)
			(7
				(gMessager say: 11 0 57 1 self) ; "(SCARED)Who.... Who's there?"
			)
			(8
				(gEgo view: 2161 setLoop: 2 setCel: 0 setCycle: End self)
				(gMessager say: 11 0 57 2 self) ; "(TRYING TO SOUND BRAVE)I have the talisman!"
			)
			(9)
			(10
				(Load rsVIEW 2162)
				(gEgo
					posn: 240 129
					setLoop: 3 1
					setCel: 0
					setCycle: Walk
					setMotion: MoveTo 225 142 self
				)
			)
			(11
				(mosley setCel: 0 setLoop: 0 init: setCycle: End self)
				(gMessager say: 11 0 57 3 self) ; "(GRUMPY)Yeah? Good for you. I've gotta headache."
			)
			(12)
			(13
				(mosley setCel: 0 setLoop: 1 setCycle: End self)
			)
			(14
				(mosley setLoop: 2 setCel: 0 setCycle: End)
				(gMessager say: 11 0 57 4 self) ; "You! Don't come near me! You're dead!"
			)
			(15
				(mosley setLoop: 3 setCel: 0 cycleSpeed: 8 setCycle: RandCycle)
				(gEgo setCel: 0 setLoop: 4 setCycle: End self)
				(gMessager say: 11 0 57 5 self) ; "Huh? Oh! Hah! That was you at the tomb? You shoulda said something!"
			)
			(16)
			(17
				(mosley setLoop: 2 setCel: 2 setCycle: Beg)
				(gMessager say: 11 0 57 6 self) ; "You mean you weren't dead, you son-of-a-bitch?"
				(gEgo setCel: 0 setLoop: 5 setCycle: End self)
			)
			(18)
			(19
				(gEgo normalize: 6 901)
				(= cycles 1)
			)
			(20
				(mosley setLoop: 3 setCel: 0 setCycle: RandCycle)
				(gMessager sayRange: 11 0 57 7 8 self) ; "Do I LOOK dead? No--don't answer that."
			)
			(21
				(mosley setLoop: 2 setCel: 2 setCycle: Beg self)
				(gMessager say: 11 0 57 9 self) ; "Christ! You about killed me!"
			)
			(22)
			(23
				(mosley setLoop: 3 setCel: 0 setCycle: RandCycle)
				(gMessager say: 11 0 57 10 self) ; "I said I was sorry. Besides, I owed you one for stealing my badge. If it makes you feel any better I lost my wallet that day."
			)
			(24
				(mosley setLoop: 2 setCel: 2 setCycle: Beg self)
				(gMessager say: 11 0 57 11 self) ; "(DAWNING REALIZATION. HE'S USED MOSELY'S CREDIT CARD)Your wallet. Ohhhh. I guess you're right. We are even."
			)
			(25)
			(26
				(mosley setLoop: 3 setCel: 0 setCycle: RandCycle)
				(gMessager say: 11 0 57 12 self) ; "Like I said. Anyway, we shouldn't stand out here and gab; someone on the street might see us. Let's go in back and talk."
			)
			(27
				(mosley view: 245 setCycle: StopWalk -1 setLoop: 5)
				(Face mosley (ScriptID 215 4) self) ; xcurtainDoor
				(gEgo
					normalize: 6 901
					ignoreActors: 1
					setSpeed: 6
					setPri: 129
					setMotion: MoveTo 288 105 self
				)
			)
			(28
				(mosley
					view: 2163
					setLoop: 0
					setCel: 0
					posn: 289 108
					setCycle: End
				)
				(gGkSound1 number: 215 setLoop: 1 play: self)
			)
			(29)
			(30
				(mosley dispose:)
				(gEgo
					view: 220
					setCel: 0
					setLoop: 0
					posn: 289 108
					setCycle: End self
				)
				(gGkSound1 number: 215 setLoop: 1 play: self)
			)
			(31)
			(32
				(gEgo setPri: -1)
				(self dispose:)
			)
		)
	)
)

(instance getTheGermanBook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (or (!= (gEgo x:) 136) (!= (gEgo y:) 93))
					(gEgo setMotion: PolyPath 136 93 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo view: 2152 setCel: 0 setLoop: 1 setCycle: End self)
			)
			(2
				(if (IsFlag 6)
					(gMessager say: 9 12 3 1 self 211) ; "Gabriel selects a volume of German poetry that he always found strangely compelling."
				else
					(gMessager say: 9 12 7 1 self 211) ; "Gabriel selects a volume of German poetry that he always found strangely compelling. For the first time he notices the author...Heinz Ritter!"
				)
			)
			(3
				(gEgo setCel: 0 setLoop: 2 setCycle: CT 3 1 self)
			)
			(4
				(gEgo setCel: 4 setLoop: 2 setCycle: End self)
				(gGkSound1 number: 218 play:)
			)
			(5
				(gMessager say: 9 12 4 0 self 211) ; "Drei Drachen. Drei Drachen kriechen in meinen Schlaf, die Seele woll'n sie lebendig zum Frass."
			)
			(6
				(cond
					((not (IsFlag 8))
						(= cycles 1)
					)
					((IsFlag 6)
						(gMessager say: 9 12 3 3 self 211) ; "That's nice. Kind of creepy, though. Who's the author?"
					)
					(else
						(= cycles 1)
					)
				)
			)
			(7
				(if (not (IsFlag 8))
					(= cycles 1)
				else
					(if (and (IsFlag 6) (IsFlag 7))
						(gMessager say: 9 12 5 2 self 211) ; "Let's see...Heinz Ritter. Heinz Ritter! No wonder it gives me chills."
					)
					(if (and (IsFlag 6) (not (IsFlag 7)))
						(gMessager say: 9 12 6 2 self 211) ; "Heinz Ritter. I'm not sure what it says, but I get the feeling the guy was one sick puppy."
					)
					(if (not (IsFlag 6))
						(gMessager say: 9 12 7 3 self 211) ; "I have the feeling old Grandad didn't sleep too well at night either."
					)
				)
			)
			(8
				(gEgo setCel: 10 setLoop: 2 setCycle: CT 7 -1 self)
			)
			(9
				(gGkSound1 number: 218 play:)
				(gEgo
					setCel: 6
					setLoop: 2
					getPoints: 120 1
					setCycle: Beg self
				)
			)
			(10
				(gGame handsOn:)
				(gEgo normalize: 0 901 ignoreActors: 1)
				(if (not ((ScriptID 210 1) script:)) ; graceProp
					((ScriptID 210 1) setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
				)
				(ClearFlag 8)
				(self dispose:)
				(DisposeScript 212)
			)
		)
	)
)

(instance getNumFromGrace of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 210 4) dispose:) ; graceDoStuff
				(gGame handsOff:)
				(gEgo hide:)
				(= cycles 1)
			)
			(1
				((ScriptID 210 1) ; graceProp
					view: 213
					setCel: 0
					setLoop: 1
					posn: 222 118
					setCycle: End self
				)
			)
			(2
				((ScriptID 210 1) ; graceProp
					setCel: 0
					setLoop: 2
					posn: 251 115
					setCycle: End self
				)
				(gEgo show: posn: 187 125 get: 8 getPoints: -999 1) ; wolfPhone
			)
			(3
				(gMessager say: 11 0 52 0 self) ; "Here's that phone number."
			)
			(4
				(ClearFlag 55)
				((ScriptID 210 1) setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
				(gGame handsOn:)
				(gEgo normalize: 0 901 ignoreActors: 1)
				(self dispose:)
				(DisposeScript 212)
			)
		)
	)
)

(instance getScale of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 220 107 self)
			)
			(1
				(gEgo view: 2082 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(2
				(gMessager say: 2 3 2 0 self 211) ; "(RRCC)Looks like the python left me a souvenir. Verrrry interesting."
			)
			(3
				(gEgo
					normalize: 0 901
					ignoreActors: 1
					get: 23 ; musScale
					getPoints: -999 1
				)
				(ClearFlag 321)
				(gGame handsOn:)
				(self dispose:)
				(DisposeScript 212)
			)
		)
	)
)

(instance lookAtScale of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 220 107 self)
			)
			(1
				(gEgo view: 2082 setCel: 0 setLoop: 0 setCycle: CT 2 1 self)
			)
			(2
				(ashTrayInset init: 0 (ScriptID 210) 1) ; bookstore
				(gMessager say: 2 4 2 0 self 211) ; "There's a snake scale in the ashtray."
			)
			(3
				(ashTrayInset dispose:)
				(= cycles 1)
			)
			(4
				(gEgo view: 2082 setCel: 2 setLoop: 0 setCycle: Beg self)
			)
			(5
				(gEgo normalize: 0 901 ignoreActors: 1)
				(gGame handsOn:)
				(self dispose:)
				(DisposeScript 212)
			)
		)
	)
)

(instance ashTrayInset of Inset
	(properties
		view 74
		x 145
		y 29
		priority 13
	)

	(method (init)
		(= picture -2)
		(super init: &rest)
		(myMagGlass init:)
		(plane setSize:)
		(UpdatePlane plane)
	)

	(method (dispose)
		(myMagGlass dispose:)
		(super dispose: &rest)
	)
)

(instance graceGetsScale of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= gNarrator GKNarrator)
				(ClearFlag 361)
				((ScriptID 210 1) init: view: 2081 setCel: 0 setLoop: 0) ; graceProp
				((ScriptID 210 21) dispose:) ; shopDoor
				((ScriptID 210 5) hide:) ; gabsCoat
				(gEgo
					posn: 101 93
					view: 219
					setLoop: 2
					setCel: 0
					setCycle: End self
				)
				(gGkSound1 number: 373 play:)
			)
			(1
				((ScriptID 210 21) init:) ; shopDoor
				(gGkSound1 number: 374 play:)
				(gEgo setCel: 0 setLoop: 3 posn: 88 97 setCycle: End self)
			)
			(2
				((ScriptID 210 5) show:) ; gabsCoat
				(gEgo
					normalize: 0 901
					ignoreActors: 1
					setMotion: MoveTo 98 97 self
				)
			)
			(3
				(gMessager sayRange: 11 0 53 1 3 self) ; "What happened to you?"
			)
			(4
				(gEgo ignoreActors: 1 setMotion: PolyPath 274 118 self)
			)
			(5
				(Face gEgo (ScriptID 210 1)) ; graceProp
				((ScriptID 210 1) setCycle: End self) ; graceProp
			)
			(6
				(gMessager sayRange: 11 0 53 4 6 self) ; "(RRCC. TO GRACE. DRY)Pale green, you say? Charming."
			)
			(7
				(gEgo hide:)
				((ScriptID 210 1) setCel: 0 setLoop: 1 setCycle: End self) ; graceProp
			)
			(8
				(gEgo show:)
				((ScriptID 210 1) setCel: 0 setLoop: 0 setCycle: End self) ; graceProp
			)
			(9
				(gMessager sayRange: 11 0 53 7 9 self) ; "Looks like a sparkly or something. Got it."
			)
			(10
				((ScriptID 210 1) setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
				(SetFlag 321)
				(gEgo normalize: 1 901 ignoreActors: 1)
				(= gNarrator (ScriptID 210 9)) ; bookStoreNarrator
				(SetFlag 361)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getSnakeBook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gEgo inRect: 211 144 235 165)
					(gEgo setMotion: PolyPath 209 129 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setMotion: PolyPath 187 101 self)
			)
			(2
				(gEgo view: 2152 setCel: 0 setLoop: 1 setCycle: End self)
			)
			(3
				(gMessager say: 11 12 0 1 self 211) ; "Gabriel pulls down a book on snakes."
			)
			(4
				(gEgo setCel: 0 setLoop: 2 setCycle: CT 3 1 self)
			)
			(5
				(gEgo setCel: 4 setLoop: 2 setCycle: End self)
				(gGkSound1 number: 218 play:)
			)
			(6
				(gMessager sayRange: 11 12 0 2 4 self 211) ; "Snakes are legless reptiles. Some snakes kill their prey with poison, some by constriction."
			)
			(7
				(if (and (IsFlag 6) (not (IsFlag 417)))
					(SetFlag 417)
					(gMessager sayRange: 11 12 8 2 3 self 211) ; "(RRCC. STUDIOUS/BRAINY)Hmmm. Did you know that medieval legends about dragons and giant worms are actually based on snakes? You know, dragons, devils, sea monsters--they've always been associated with snakes."
				else
					(= cycles 1)
				)
			)
			(8
				(gEgo setCel: 10 setLoop: 2 setCycle: CT 7 -1 self)
			)
			(9
				(gGkSound1 number: 218 play:)
				(gEgo
					setCel: 6
					setLoop: 2
					getPoints: 121 1
					setCycle: Beg self
				)
			)
			(10
				(gGame handsOn:)
				(GKEgo normalize: 0 901)
				(if (not ((ScriptID 210 1) script:)) ; graceProp
					((ScriptID 210 1) setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
				)
				(gEgo ignoreActors: 1)
				(self dispose:)
			)
		)
	)
)

(instance mosley of Actor
	(properties
		x 301
		y 107
		view 2162
	)
)

(instance package of View
	(properties
		x 233
		y 117
		view 211
		loop 6
	)
)

(instance myMagGlass of View
	(properties
		priority 14
		view 1
	)
)

(instance egoHead of Prop
	(properties
		x 91
		y 56
		view 218
		loop 3
	)

	(method (init)
		(super init:)
		(self setPri: 151)
	)
)

(instance maliaHead of Prop
	(properties
		x 110
		y 59
		view 218
		loop 4
	)

	(method (init)
		(super init:)
		(self setPri: 151)
	)
)

