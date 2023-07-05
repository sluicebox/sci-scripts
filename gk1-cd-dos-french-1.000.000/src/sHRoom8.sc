;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 808)
(include sci.sh)
(use Main)
(use n013)
(use GKNarrator)
(use Talker)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Rev)
(use Timer)
(use Grooper)
(use Motion)
(use Actor)
(use System)

(public
	sHRoom8 0
)

(local
	local0 = 1
	[local1 3]
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
)

(instance sHRoom8 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 800 0) ; Hounfour
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 249 137 204 112 168 112 168 119 70 119 38 137
							yourself:
						)
				)
				((ScriptID 800 2) doit: 850) ; xDrawThePic
				(= gNarrator hounfourNarrator)
				(bed init:)
				(light init:)
				(lightBar init:)
				(keypad init:)
				(keypad2 init:)
				(door2 init:)
				(wallPanel init:)
				(grace init:)
				(door1 init: setCel: 5)
				((ScriptID 800 0) timeForCeremony: 1) ; Hounfour
				(self setScript: sEnter)
				(GK currentSpeed: 6)
				(gEgo
					setScaler: Scaler 100 85 119 111
					normalize: 1
					posn: 230 126
					init:
					actions: gabeActions
					setMotion: MoveTo 215 126 script
				)
			)
			(1
				(= gNarrator GKNarrator)
				(gEgo actions: 0)
				(gGkMusic1 fade:)
				(self dispose:)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				0
			)
			(1
				(gGkSound1 number: 812 play:)
				(door1 setCycle: Beg self)
			)
			(2
				(gMessager say: 5 0 1 0 self 808) ; "(RRCC. EXCITED. FINDS ROOM WITH KIDNAPPED GRACE IN IT)Grace! I found her!"
				(gGkMusic1
					number: 480
					setLoop: -1
					stop:
					play:
					setVol: (/ (gGkMusic2 musicVolume:) 2)
				)
			)
			(3
				(gEgo setMotion: MoveTo 116 119 self)
			)
			(4
				(if (IsFlag 351)
					(client setScript: sMoselyShowsUp)
				else
					(djTimer setReal: djTimer 20)
					(gGame handsOn:)
					(SetFlag 200)
					(self dispose:)
				)
			)
		)
	)
)

(instance sTakeOffCoat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setSpeed: 6
					view: 856
					setCel: 0
					setLoop: 0
					setCycle: End self
				)
			)
			(1
				(coat init:)
				(gEgo normalize: 1 901)
				(= cycles 1)
			)
			(2
				(= local0 0)
				(self dispose:)
			)
		)
	)
)

(instance sDJThrowsKnife of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 800 1) ; xDJ
					view: (if (IsFlag 365) 8531 else 853)
					setCel: 0
					setLoop: 1
					setCycle: CT 5 1 self
				)
			)
			(1
				(mosely
					view: (if (IsFlag 365) 8531 else 853)
					setCel: 0
					setLoop: 0
					setCycle: End
				)
				((ScriptID 800 1) setCel: 6 setCycle: End self) ; xDJ
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sLayDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(grace view: 8500 setCel: 3 setLoop: 2 setCycle: Beg self)
			)
			(1
				(grace setCel: 9 setLoop: 1 setCycle: Beg self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sDJKills of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch register
					(1
						(gMessager say: 5 0 9 0 self 808) ; "You! What are you doing here? I do not recognize you!"
					)
					(2
						(gMessager say: 5 0 8 0 self 808) ; "Gabriel Knight! What are you doing here? And who is this with you?"
					)
					(3
						(gMessager say: 5 0 8 0 self 808) ; "Gabriel Knight! What are you doing here? And who is this with you?"
					)
					(else
						(gMessager say: 5 0 7 0 self 808) ; "Gabriel Knight! What are you doing here?"
					)
				)
			)
			(1
				(if (IsFlag 351)
					(self setScript: sDJThrowsKnife self)
				else
					(= cycles 1)
				)
			)
			(2
				((ScriptID 800 1) ; xDJ
					posn: 170 122
					view: 854
					setCel: 0
					setLoop: 0
					setCycle: End self
				)
				(UpdateScreenItem (ScriptID 800 1)) ; xDJ
				(gEgo hide:)
			)
			(3
				(gGkSound1 setLoop: 1 number: 891 play:)
				((ScriptID 800 1) setCel: 0 setLoop: 1 1 setCycle: CT 7 1 self) ; xDJ
			)
			(4
				((ScriptID 800 1) setCel: 8 setCycle: End self) ; xDJ
			)
			(5
				((ScriptID 800 1) ; xDJ
					view: 8541
					posn: 184 124
					setCel: 0
					setLoop: 2
					setCycle: End
				)
				(gGkSound1 setLoop: 1 number: 885 play:)
				(gEgo
					view: 8541
					posn: 170 122
					setCel: 0
					setLoop: 0
					show:
					setCycle: End self
				)
			)
			(6
				(gCurRoom newRoom: 770) ; deathRm
			)
		)
	)
)

(instance sDJEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gNarrator dispose:)
				(gGkSound1 number: 811 play:)
				(door1 setCycle: End)
				(if (not (IsFlag 366))
					(gEgo normalize: setMotion: MoveTo 166 122 self)
				else
					(gEgo view: 859 setCel: 0 setCycle: End self)
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(if (IsFlag 370)
					(gMessager say: 5 0 4 0 self 808) ; "(RRCC. HUSHED, URGENT)Someone's coming! Grace, get down!"
				else
					(= cycles 1)
				)
			)
			(3
				(if (IsFlag 370)
					(grace setScript: sLayDown self)
				else
					(= cycles 1)
				)
			)
			(4
				((ScriptID 800 1) ; xDJ
					view: 835
					posn: 261 126
					setCel: 0
					setLoop: -1
					ignoreActors: 1
					init:
					setCycle: StopWalk -1
					setMotion: MoveTo 241 126 self
				)
			)
			(5
				((ScriptID 800 1) ; xDJ
					view: 8521
					setCel: 0
					setLoop: 0
					setCycle: End self
				)
			)
			(6
				(cond
					((and (IsFlag 366) (not (IsFlag 365)) (IsFlag 351))
						(client setScript: sDJKills 0 1)
					)
					(
						(and
							(not (IsFlag 366))
							(not (IsFlag 365))
							(IsFlag 351)
						)
						(client setScript: sDJKills 0 2)
					)
					((and (not (IsFlag 366)) (IsFlag 365) (IsFlag 351))
						(client setScript: sDJKills 0 3)
					)
					((and (not (IsFlag 366)) (not (IsFlag 351)))
						(client setScript: sDJKills 0 4)
					)
					((and (IsFlag 366) (IsFlag 365) (IsFlag 351))
						(gMessager say: 5 0 6 0 self 808) ; "What are you doing here?"
					)
					((and (IsFlag 366) (not (IsFlag 351)))
						(gMessager say: 5 0 5 0 self 808) ; "What are you doing here?"
					)
				)
			)
			(7
				(sHRoom8 cue:)
			)
		)
	)
)

(instance sMakePlans of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 351)
					(gMessager say: 5 0 27 0 self 808) ; "(TAKING CHARGE)Right! Let's make a plan! What do you want us to do, Gabriel?"
				else
					(gMessager say: 5 0 28 0 self 808) ; "(RRCC. ENTHUSIASTIC, THEN NERVOUS)A plan. Right. What do you think we should do?"
				)
			)
			(1
				(djTimer setReal: djTimer 20)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPutOnRobe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(djTimer dispose:)
				(gEgo setSpeed: 6 setMotion: PolyPath 128 129 self)
			)
			(1
				(self setScript: sTakeOffCoat self)
			)
			(2
				(gEgo view: 8511 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(3
				(gEgo setCel: 0 setLoop: 1 setCycle: End self)
				(SetFlag 366)
			)
			(4
				(gMessager say: 6 120 39 0 self 808) ; "(MRCC. SPEAKING OF GABE DONNING WOLF DISGUISE)A wolf. How appropriate."
			)
			(5
				(gEgo getPoints: -999 1)
				(client setScript: sDJEnters)
			)
		)
	)
)

(instance sWakeGrace of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(djTimer dispose:)
				(gEgo setSpeed: 6 setMotion: PolyPath 116 119 self)
			)
			(1
				(Face gEgo 100 110 self)
			)
			(2
				(gMessager say: 3 124 10 1 self 808) ; "(SPEAKING TO HIMSELF)This talisman is supposed to have some sort of power."
			)
			(3
				(gEgo view: 8500 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(4
				(gMessager say: 3 124 10 2 self 808) ; "Grace! Wake up! Grace!"
			)
			(5
				(= seconds 3)
			)
			(6
				(gEgo setCel: 0 setLoop: 3 setCycle: End self)
			)
			(7
				(gEgo normalize: 7)
				(= cycles 1)
			)
			(8
				(gEgo
					setCel: 0
					setLoop: 7
					setCycle: Rev
					setMotion: MoveTo 125 125 self
				)
			)
			(9
				(gEgo normalize: 7)
				(= cycles 1)
			)
			(10
				(grace view: 8500 setCel: 0 setLoop: 1 setCycle: End self)
				(gMessager say: 3 124 10 3 self 808) ; "(WAKING UP FROM DEEP TRANCE)What...what's going on?"
			)
			(11 0)
			(12
				(grace setCel: 0 setLoop: 2 setCycle: End self)
			)
			(13
				(gEgo getPoints: -999 2)
				(SetFlag 370)
				(if (IsFlag 351)
					(gMessager say: 5 0 18 0 self 808) ; "Gabriel! Mosely! Where are we? What's going on?"
				else
					(gMessager say: 5 0 12 0 self 808) ; "Gabriel! Where are we? What's going on?"
				)
			)
			(14
				(DisposeScript 64969)
				(client setScript: sMakePlans)
			)
		)
	)
)

(instance sTryToWakeGrace of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(djTimer dispose:)
				(gGame handsOff:)
				(gEgo setSpeed: 6 setMotion: PolyPath 116 118 self)
			)
			(1
				(gEgo view: 850 setCel: 10 setLoop: 1 setCycle: Beg self)
				(UpdateScreenItem gEgo)
				(grace hide:)
				(gMessager say: 3 11 10 0 self 808) ; "Grace! Wake up! Talk to me!"
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(grace show:)
				(gEgo normalize: 1)
				(= cycles 1)
			)
			(4
				(gGame handsOn:)
				(djTimer setReal: djTimer 20)
				(self dispose:)
			)
		)
	)
)

(instance sMoselyPutOnRobe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(djTimer dispose:)
				(gGame handsOff:)
				(gEgo setSpeed: 6 setMotion: PolyPath 128 129 self)
				(mosely
					view: 245
					ignoreActors: 1
					loop: 0
					cel: 0
					setLoop: -1
					setLoop: Grooper
					setCycle: StopWalk -1
					setMotion: MoveTo 88 130 self
				)
			)
			(1 0)
			(2
				(Face gEgo mosely self)
			)
			(3
				(= cycles 2)
			)
			(4
				(mosely hide:)
				(gEgo view: 8512 setCel: 0 setLoop: 0 setCycle: 0)
				(= cycles 1)
			)
			(5
				(= cycles 1)
			)
			(6
				(if local4
					(gMessager say: 4 121 36 1 self 808) ; "All right. Take your disguise now."
				else
					(gMessager say: 4 121 35 1 self 808) ; "Here. It's a disguise."
				)
			)
			(7
				(gMessager say: 4 121 35 2 self 808) ; "Gee, a boar. How thoughtful. And what are you, pray tell?"
				(gEgo view: 8512 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(8 0)
			(9
				(mosely
					show:
					view: 8512
					setCel: 0
					setLoop: 1
					ignoreActors: 0
					setCycle: End self
				)
				(gEgo normalize: 1 (if local0 900 else 901))
			)
			(10
				(= cycles 2)
			)
			(11
				(gMessager say: 7 0 37 2 self 808) ; "Uh...a wolf."
				(SetFlag 365)
			)
			(12
				(gMessager say: 7 0 37 3 self 808) ; "You goddamn wiener!"
			)
			(13
				(gEgo getPoints: -999 1)
				(djTimer setReal: djTimer 20)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sMoselyShowsUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGkSound1 number: 811 play:)
				(door1 setCycle: End self)
				(Face gEgo door1)
			)
			(1
				(mosely init: setCycle: End self)
			)
			(2
				(mosely
					view: 245
					posn: 270 127
					ignoreActors: 1
					setLoop: -1
					setPri: 5
					setLoop: Grooper
					setCycle: StopWalk -1
					setMotion: MoveTo 231 127 self
				)
				(gMessager say: 5 0 2 1 self 808) ; "Mostly! You made it!"
			)
			(3 0)
			(4
				(gMessager say: 5 0 2 2 self 808) ; "Thank God! I thought I saw you ducking in here!"
				(gGkSound1 number: 812 play:)
				(door1 setCycle: Beg self)
			)
			(5 0)
			(6
				(mosely setPri: -1 setMotion: PolyPath 85 125 self)
			)
			(7
				(Face gEgo mosely)
				(Face mosely 185 125 self)
			)
			(8
				(mosely view: 853 setCycle: 0 setCel: 0 setLoop: 0)
				(Face gEgo mosely self)
			)
			(9
				(= cycles 2)
			)
			(10
				(gMessager say: 5 0 2 3 self 808) ; "Those goddamn drums started as soon as I got off that elevator thing, and I heard voices from above. I have the feeling the mass Voodooees are about to invade."
			)
			(11
				(gMessager say: 5 0 2 4 self 808) ; "I found Grace."
			)
			(12
				(gMessager say: 5 0 2 5 self 808) ; "I see that. Check her out, then you and I need to find a way to blend into the woodwork, Bud."
			)
			(13
				(djTimer setReal: djTimer 40)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance mosely of Actor
	(properties
		noun 4
		modNum 808
		x 247
		y 93
		view 851
	)

	(method (doVerb theVerb)
		(switch theVerb
			(122 ; BoarRobe or WolfRobe
				(gMessager say: 4 122 0 0 0 808) ; "The robe by itself will not disguise Mosely--especially not with that glow-in-the-dark forehead."
				(return 1)
			)
			(114 ; WolfMask
				(gMessager say: 4 120 0 0 0 808) ; "Gabriel would prefer to keep the wolf disguise for himself."
				(return 1)
			)
			(116 ; BoarMask
				(gMessager say: 4 116 0 0 0 808) ; "The mask by itself will not disguise Mosely--not with that day-glo coat he wears."
				(return 1)
			)
			(120 ; WolfGuise
				(gMessager say: 4 120 0 0 0 808) ; "Gabriel would prefer to keep the wolf disguise for himself."
				(return 1)
			)
			(121 ; BoarGuise
				(cond
					((IsFlag 370)
						(gEgo put: 78) ; BoarGuise
						(sHRoom8 setScript: sMoselyPutOnRobe)
					)
					(local4
						(gMessager say: 4 theVerb 34 0 0 808) ; "Are you sure you don't want that disguise?"
					)
					(else
						(= local4 1)
						(gMessager say: 4 theVerb 33 0 0 808) ; "I got you a disguise."
					)
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance grace of Prop
	(properties
		noun 3
		modNum 808
		x 104
		y 121
		z 20
		priority 115
		fixPriority 1
		view 850
		signal 16417
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(switch theVerb
				(101 ; knife
					(if (IsFlag 370)
						(gMessager say: 3 theVerb 11 0 0 808) ; "Why don't you take this dagger, Grace. You might need it."
					else
						(gMessager say: 3 theVerb 10 0 0 808) ; "Sticking Grace with that dagger probably won't break her unconscious state, but it would sure piss her off when she DOES wake up."
					)
					(return 1)
				)
				(124 ; talisman
					(if (IsFlag 370)
						(gMessager say: 3 theVerb 11 0 0 808) ; "Grace doesn't need any more help from the talisman."
					else
						(sHRoom8 setScript: sWakeGrace)
					)
					(return 1)
				)
				(121 ; BoarGuise
					(if (IsFlag 370)
						(gMessager say: 3 theVerb 11 0 0 808) ; "(RRCC. CONCERNED.)Do you want to wear a disguise?"
					else
						(gMessager say: 3 theVerb 10 0 0 808) ; "(RRCC)Grace would be mortified if Gabriel tried to dress her while she was unconscious!"
					)
					(return 1)
				)
				(120 ; WolfGuise
					(if (IsFlag 370)
						(gMessager say: 3 theVerb 11 0 0 808) ; "(RRCC. CONCERNED.)Do you want to wear a disguise?"
					else
						(gMessager say: 3 theVerb 10 0 0 808) ; "(RRCC)Grace would be mortified if Gabriel tried to dress her while she was unconscious!"
					)
					(return 1)
				)
				(122 ; BoarRobe or WolfRobe
					(if (IsFlag 370)
						(gMessager say: 3 theVerb 11 0 0 808) ; "(RRCC. CONCERNED.)Do you want to wear a disguise?"
					else
						(gMessager say: 3 theVerb 10 0 0 808) ; "(RRCC)Grace would be mortified if Gabriel tried to dress her while she was unconscious!"
					)
					(return 1)
				)
				(114 ; WolfMask
					(if (IsFlag 370)
						(gMessager say: 3 theVerb 11 0 0 808) ; "(RRCC. CONCERNED.)Do you want to wear a disguise?"
					else
						(gMessager say: 3 theVerb 10 0 0 808) ; "(RRCC)Grace would be mortified if Gabriel tried to dress her while she was unconscious!"
					)
					(return 1)
				)
				(116 ; BoarMask
					(if (IsFlag 370)
						(gMessager say: 3 theVerb 11 0 0 808) ; "(RRCC. CONCERNED.)Do you want to wear a disguise?"
					else
						(gMessager say: 3 theVerb 10 0 0 808) ; "(RRCC)Grace would be mortified if Gabriel tried to dress her while she was unconscious!"
					)
					(return 1)
				)
				(else
					(if (IsFlag 370)
						(gMessager say: 3 0 11 0 0 808) ; "Grace would be better off not carrying anything for what's coming ahead."
					else
						(gMessager say: 3 0 10 0 0 808) ; "That won't help Grace."
					)
					(return 1)
				)
			)
		else
			(switch theVerb
				(10 ; Ask
					(if (IsFlag 370)
						(gMessager say: 3 theVerb 11 0 0 808) ; "Can I ask you some questions?"
					else
						(gMessager say: 3 theVerb 10 0 0 808) ; "Grace isn't up for answering questions at the moment."
					)
					(return 1)
				)
				(7 ; Look
					(if (IsFlag 370)
						(gMessager say: 3 theVerb 11 0 0 808) ; "Grace looks shaken, but okay."
					else
						(gMessager say: 3 theVerb 10 0 0 808) ; "Grace is lying still on the bed. She may be unconscious...or worse."
					)
					(return 1)
				)
				(9 ; Move
					(if (IsFlag 370)
						(gMessager say: 3 theVerb 11 0 0 808) ; "Grace can move on her own."
					else
						(gMessager say: 3 theVerb 10 0 0 808) ; "Gabriel wouldn't get far dragging an unconscious Grace."
					)
					(return 1)
				)
				(12 ; Pickup
					(if (IsFlag 370)
						(gMessager say: 3 theVerb 11 0 0 808) ; "Grace can move on her own."
					else
						(gMessager say: 3 theVerb 10 0 0 808) ; "Gabriel wouldn't get far dragging an unconscious Grace."
					)
					(return 1)
				)
				(11 ; Talk
					(if (IsFlag 370)
						(gMessager say: 3 theVerb 11 0 0 808) ; "How are you feeling, Grace?"
					else
						(sHRoom8 setScript: sTryToWakeGrace)
					)
					(return 1)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance door1 of Prop
	(properties
		noun 4
		modNum 800
		x 250
		y 128
		priority 1
		fixPriority 1
		view 855
		loop 1
		signal 16417
	)
)

(instance door2 of Prop
	(properties
		noun 2
		modNum 808
		x 169
		y 108
		priority 1
		fixPriority 1
		view 855
		signal 16417
	)
)

(instance coat of View
	(properties
		x 102
		y 125
		view 856
		loop 1
	)
)

(instance keypad of Feature
	(properties
		noun 20
		modNum 800
		nsLeft 228
		nsTop 80
		nsRight 237
		nsBottom 92
		sightAngle 40
		approachX 232
		approachY 86
		x 232
		y 129
		z 38
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(cond
					((and (IsFlag 366) (IsFlag 365) (IsFlag 351))
						(gMessager say: 20 8 35 0 0 800) ; "Just as Gabriel is about to open the door, he hears someone on the other side."
					)
					((and (IsFlag 366) (not (IsFlag 351)))
						(gMessager say: 20 8 35 0 0 800) ; "Just as Gabriel is about to open the door, he hears someone on the other side."
					)
					(else
						(gMessager say: 20 8 34 0 0 800) ; "Gabriel can hear people in the hall. It might not be wise to open the door without taking the proper precautions."
					)
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance keypad2 of Feature
	(properties
		noun 20
		nsLeft 200
		nsTop 77
		nsRight 207
		nsBottom 86
		sightAngle 40
		approachX 201
		approachY 113
		x 203
		y 111
		z 30
	)

	(method (doVerb theVerb)
		(switch theVerb
			(123 ; hounfourKey
				(gMessager say: noun theVerb 15 0 0 800) ; "This door isn't locked."
				(return 1)
			)
			(8 ; Operate
				(gMessager say: 2 8 0 0 0 808) ; "There's no time to mess with the bathroom."
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bed of Feature
	(properties
		noun 1
		modNum 809
		sightAngle 40
		x 70
		y 120
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 66 96 77 91 109 95 151 95 156 100 157 114 71 113
					yourself:
				)
		)
		(super init:)
	)
)

(instance wallPanel of Feature
	(properties
		noun 19
		nsLeft 80
		nsTop 69
		nsRight 123
		nsBottom 86
		sightAngle 40
		approachX 101
		approachY 77
		x 101
		y 110
		z 33
	)
)

(instance light of Feature
	(properties
		noun 16
		modNum 800
		sightAngle 40
		x 255
		y 120
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 251 75 244 65 263 65 255 75 255 135 251 135
					yourself:
				)
		)
		(super init:)
	)
)

(instance lightBar of Feature
	(properties
		noun 17
		modNum 800
		sightAngle 40
		x 70
		y 120
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 73 54 86 58 88 61 78 63 60 58 60 54
					yourself:
				)
		)
		(super init:)
	)
)

(instance gabeActions of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(122 ; BoarRobe or WolfRobe
				(gMessager say: 6 122 0 0 0 808) ; "The robe alone won't help disguise Gabriel. It doesn't cover his face."
				(return 1)
			)
			(114 ; WolfMask
				(gMessager say: 6 114 0 0 0 808) ; "(MRCC)The wolf's mask alone won't be enough to disguise Gabriel. His clothes will stick out like a sore thumb."
				(return 1)
			)
			(121 ; BoarGuise
				(gMessager say: 6 121 0 0 0 808) ; "Gabriel prefers the wolf disguise. It's more manly."
				(return 1)
			)
			(120 ; WolfGuise
				(if (IsFlag 370)
					(if (or (IsFlag 365) (not (IsFlag 351)))
						(gEgo put: 79) ; WolfGuise
						(sHRoom8 setScript: sPutOnRobe)
					else
						(gMessager say: 6 theVerb 38 0 0 808) ; "Gabriel doesn't want Mosely to feel left out."
					)
				else
					(gMessager say: 6 theVerb 10 0 0 808) ; "That thing looks hot. Gabriel doesn't want to put it on until he has to."
				)
				(return 1)
			)
			(else
				(return 0)
			)
		)
	)
)

(instance djTimer of Timer
	(properties)

	(method (cue)
		(if (gTalkers size:)
			(djTimer setReal: djTimer 5)
		else
			(sHRoom8 setScript: sDJEnters)
		)
	)
)

(instance hounfourNarrator of Narrator
	(properties
		x 0
		y 157
		talkWidth 314
		modeless 2
	)

	(method (init)
		(self fore: global220 back: global214 font: gUserFont)
		(super init: &rest)
	)

	(method (display param1 &tmp temp0 temp1)
		(= fore
			(switch global180
				(1 54)
				(2 21)
				(99 7)
				(8 30)
				(25 25)
				(else global220)
			)
		)
		(switch global180
			(1
				(if
					(and
						(gCast contains: gEgo)
						(OneOf (gEgo view:) 901 900 8511)
						(== (gEgo loop:) 8)
					)
					(if (or (== (gEgo cel:) 4) (== (gEgo cel:) 5))
						(= temp0 (+ (gEgo view:) 1000))
					else
						(if (== (gEgo view:) 900)
							(= temp0 (+ (gEgo view:) 1010 (gEgo cel:)))
						else
							(= temp0 (+ (gEgo view:) 1039 (gEgo cel:)))
						)
						(switch (Random 0 2)
							(0 1)
							(1
								(+= temp0 10)
							)
							(2
								(= temp0 (+ (gEgo view:) 1000))
							)
						)
					)
					(if (IsFlag 366)
						(gEgo
							oldView: (gEgo view:)
							oldLoop: (gEgo loop:)
							oldCel: (gEgo cel:)
							talking: 1
							oldSig: (gEgo signal:)
							view: 858
							setCel: 0
							setLoop: (if (== (gEgo oldView:) 859) 0 else 1)
							posn: (gEgo x:) (gEgo y:)
							ignoreActors:
							cycleSpeed: 14
							setCycle: RandCycle (* (param1 size:) 3) 0 1
						)
					else
						(= local16 (gEgo cycleSpeed:))
						(gEgo
							talking: 1
							oldView: (gEgo view:)
							oldLoop: (gEgo loop:)
							oldCel: (gEgo cel:)
							oldSig: (gEgo signal:)
							view: temp0
							loop: (gEgo cel:)
							cel: 0
							posn: (gEgo x:) (gEgo y:)
							ignoreActors:
							cycleSpeed: 14
						)
						(if (or (< 1919 temp0 1930) (< 1949 temp0 1960))
							(gEgo setCycle: ForRepeat)
						else
							(gEgo setCycle: Fwd)
						)
					)
				)
			)
			(2
				(if (not (grace cycler:))
					(= local17 1)
					(= local5 (grace view:))
					(= local6 (grace cel:))
					(= local7 (grace loop:))
					(grace
						view: 857
						setCel: 0
						setLoop: 2
						setCycle: RandCycle (* (param1 size:) 3) 0 1
					)
				)
			)
			(25
				(= local14 1)
				(= local11 ((ScriptID 800 1) view:)) ; xDJ
				(= local13 ((ScriptID 800 1) cel:)) ; xDJ
				(= local12 ((ScriptID 800 1) loop:)) ; xDJ
				(if (not local15)
					((ScriptID 800 1) ; xDJ
						view: 8521
						setCel: 0
						setLoop: 1
						setCycle: End
					)
					(= local15 1)
				else
					((ScriptID 800 1) ; xDJ
						view: 8521
						setCel: 0
						setLoop: 2
						setCycle: RandCycle (* (param1 size:) 3) 0 1
					)
				)
			)
			(8
				(if (OneOf (mosely view:) 853 8512)
					(= local18 1)
					(= local8 (mosely view:))
					(= local9 (mosely cel:))
					(= local10 (mosely loop:))
					(mosely
						view: (if (== local8 853) 857 else 858)
						setCel: 0
						setLoop: (if (== local8 853) 0 else 2)
						setCycle: RandCycle (* (param1 size:) 3) 0 1
					)
				)
			)
		)
		(if (& gMsgType $0001)
			(super display: param1)
		)
	)

	(method (dispose)
		(if local17
			(= local17 0)
			(grace view: local5 setCel: local6 setLoop: local7 setCycle: 0)
		)
		(if local18
			(= local18 0)
			(mosely view: local8 setCel: local9 setLoop: local10 setCycle: 0)
		)
		(if local14
			(= local14 0)
			((ScriptID 800 1) ; xDJ
				view: local11
				setCel: local13
				setLoop: local12
				setCycle: 0
			)
		)
		(if (gEgo talking:)
			(gEgo
				view: (gEgo oldView:)
				loop: (gEgo oldLoop:)
				cel: (gEgo oldCel:)
				signal: (gEgo oldSig:)
				cycleSpeed: local16
				setCycle: StopWalk -1
				talking: 0
			)
		)
		(super dispose:)
	)
)

(class ForRepeat of Fwd
	(properties)

	(method (cycleDone)
		(client cel: 8)
	)
)

