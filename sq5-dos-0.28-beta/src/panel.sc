;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 202)
(include sci.sh)
(use Main)
(use rm201)
(use sStartEggTimer)
(use eureka)
(use Osc)
(use Feature)
(use ScaleTo)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	proc202_1 1
	panel 2
	sAfterAlien 4
	sAlienHere 5
	sPushButtons 6
	sSpikeHere 7
	sSquishMonkeys 8
	sDidntGetSpike 9
	sGenetixAlien 11
	sSpaceBarQuirk 12
	monitor1 13
	monitor2 14
	monitor3 15
	vid1Monitor 18
	vid2Monitor 19
	vid3Monitor 20
	capChair 21
	dConsole 22
	fConsole 23
	sSpikeComplaint 24
	sGarbageComplaint 25
)

(local
	[local0 3] = [3 4 5]
	[local3 4] = [0 159 192 91]
	[local7 4] = [0 169 200 100]
)

(procedure (proc202_1)
	(panel cel: (panel lastCel:) setCycle: Beg panel)
	(panelNoise number: 217 loop: 1 play:)
)

(instance monkeySound of Sound
	(properties)
)

(instance sSquishMonkeys of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 3)
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(= seconds 2)
			)
			(2
				(scraper init:)
				(monkey
					init:
					show:
					x: [local3 register]
					y: 65
					setScale: ScaleTo 128 10 self
				)
			)
			(3
				(monkeySound number: 519 setLoop: 1 play:)
				(monkey setCycle: End self)
			)
			(4
				(scraper
					moveSpeed: 2
					setStep: 5
					setMotion: MoveTo [local7 register] 49 self
				)
				(gSq5Music2 number: 423 loop: 1 play:)
			)
			(5
				(monkey hide:)
				(scraper
					setLoop: 1
					cel: 0
					cycleSpeed: 15
					setCycle: End
					setMotion: MoveTo 40 49 self
				)
				(monkeySound number: 228 loop: 1 play:)
			)
			(6
				(monkeySound stop:)
				(= ticks 20)
			)
			(7
				(scraper setLoop: 0 setCel: 0 setMotion: MoveTo 275 49 self)
				(gSq5Music2 number: 423 loop: 1 play:)
			)
			(8
				(gSq5Music2 stop:)
				(if (-- register)
					(-= state 8)
				)
				(= seconds 1)
			)
			(9
				(gSq5Music2 number: 206 setLoop: -1 play:)
				(self setScript: sStarConMessage self)
			)
			(10
				(scraper dispose:)
				(monkey dispose:)
				(monkeySound dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sStarConMessage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc201_6 self)
			)
			(1
				(gMessager say: 20 0 0 0 self 202) ; "I'm receiving a coded transmission from starcon, sir."
			)
			(2
				(self setScript: (ScriptID 201 4) self) ; sBusyFlo
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sSpikeHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 3)
				(= global126 1)
			)
			(1
				(proc201_6 self)
			)
			(2
				(gMessager say: 16 0 26 1 self) ; "Captain! I'm picking up a life form in the waste compartment."
			)
			(3
				(self setScript: (ScriptID 201 4) self) ; sBusyFlo
			)
			(4
				(= seconds 2)
			)
			(5
				(monitor1 init:)
				(= seconds 1)
			)
			(6
				(gMessager say: 16 0 26 2 self) ; "Captain, you better come down here. There are some strange scratching noises coming out of the trash bin."
			)
			(7
				(monitor1 dispose:)
				(= seconds 1)
			)
			(8
				(gGame handsOn:)
				(eureka state: 1)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance sGarbageComplaint of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(monitor1 init:)
				(= seconds 2)
				(eureka garbage: 0 gdoor: 0)
			)
			(1
				(gMessager say: 28 0 0 1 self 202) ; "Hey! Thanks for leaving this mess back here for me to clean up. Real Captain-like of you!"
			)
			(2
				(if
					(and
						(or (not (IsFlag 56)) (IsFlag 113) (IsFlag 114))
						(> global126 1)
					)
					(proc201_32 1)
					(= next sSpikeComplaint)
					(sSpikeComplaint state: 0)
				else
					(monitor1 dispose:)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sSpikeComplaint of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(monitor1 init:)
				(= seconds 2)
			)
			(1
				(if (or (IsFlag 113) (IsFlag 114))
					(ClearFlag 113)
					(ClearFlag 114)
					(if (IsFlag 56)
						(gMessager say: 14 0 90 1 self 202) ; "Thanks for taking care of your critter, Captain. I've finally managed to patch up the deck."
					else
						(gMessager say: 14 0 39 2 self 202) ; "Captain, ya gotta do something. That critter of yours is making Swiss cheese outta my deck back here! I'm gettin' might tired o' fixin' the floor."
					)
				else
					(gMessager say: 14 0 39 1 self 202) ; "That little acid piddling beastie you turned loose is roamin' around burning holes in everything. You better take care of him fast before he eats through the hull and kills us all!"
				)
			)
			(2
				(monitor1 dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDidntGetSpike of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				(monitor1 init:)
				(= ticks 35)
			)
			(2
				(gMessager say: 14 0 0 1 self 202) ; "Captain, we're losin' hull integrity. There's a big hole in the garbage compartment! The hatch is gonna blow any second! We're all gonna die!"
			)
			(3
				(client setScript: (ScriptID 210 3) 0 8) ; sBlowUpEureka
				(self dispose:)
			)
		)
	)
)

(instance buttonNoise of Sound
	(properties)
)

(instance panelNoise of Sound
	(properties)
)

(instance sPushButtons of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rogArm init:)
				(rogHand
					init:
					x: (if (== register 2) 202 else 200)
					y: (if (== register 2) 142 else 144)
					cel: 0
					setLoop: [local0 register]
					cycleSpeed: 4
				)
				(= cycles 1)
			)
			(1
				(= ticks 30)
			)
			(2
				(rogHand setCycle: End self)
			)
			(3
				(buttonNoise number: 124 loop: 1 play: self)
			)
			(4
				(rogArm dispose:)
				(rogHand dispose:)
				(switch register
					(0
						(if
							(and
								(< (eureka puke:) 1)
								(not (IsFlag 86))
								(> global130 0)
							)
							(= next sPushGreen)
						)
						(= cycles 1)
					)
					(1
						(cond
							((< global170 2)
								(gMessager say: 6 1 0 4 self 202) ; "The Eureka does not currently have a science officer."
							)
							((and (< (eureka puke:) 1) (not (IsFlag 86)))
								(= next sPushOrange)
								(= cycles 1)
							)
							(else
								(= cycles 1)
							)
						)
					)
					(2
						(= cycles 1)
						(= next sPushRed)
					)
				)
			)
			(5
				(gGame handsOn:)
				(buttonNoise dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sPushGreen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 1)
				(monitor1 init:)
			)
			(1
				(if (IsFlag 60)
					(gMessager say: 6 0 8 1 self) ; "You rang?"
				else
					(gMessager say: 6 0 8 2 self) ; "Yes, Cap'n."
				)
			)
			(2
				(self setScript: (ScriptID 218 0) self) ; sCommandCliffy
			)
			(3
				(monitor1 dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPushOrange of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 1)
				(monitor2 init:)
			)
			(1
				(gMessager say: 40 0 0 1 self) ; "What function may I assist you with captain?"
			)
			(2
				(self setScript: (ScriptID 219 0) self) ; sCommandWD40
			)
			(3
				(monitor2 dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPushRed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(panel init: cel: 0 setCycle: CT 5 1 self)
				(panelNoise number: 217 loop: 1 play:)
			)
			(1
				(gCast eachElementDo: #stopUpd)
				(if (gCast contains: (ScriptID 221 1)) ; asteroid1
					((ScriptID 221 1) setScript: 0) ; asteroid1
					((ScriptID 221 2) setScript: 0) ; asteroid2
					((ScriptID 221 3) setScript: 0) ; asteroid3
					((ScriptID 221 4) setScript: 0) ; asteroid4
				)
				(= cycles 1)
			)
			(2
				(panel setCycle: CT 9 1 self)
				(panelNoise number: 218 loop: 1 play:)
			)
			(3
				(proc204_1)
				(panel stopUpd:)
				(= cycles 1)
			)
			(4
				(gGame handsOn:)
				(panelNoise dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sGenetixAlien of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
				(gGame handsOff:)
			)
			(1
				(proc201_6 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gMessager say: 2 0 1 1 self 202) ; "We're being hailed captain. Putting it on screen."
			)
			(4
				(self setScript: (ScriptID 201 4) self) ; sBusyFlo
			)
			(5
				(self setScript: (ScriptID 209 0) self 208) ; sStartViewPort
			)
			(6
				(gMessager say: 2 0 0 0 self 202) ; "Unauthorized ship, you are trespassing in an Alpha One security zone."
			)
			(7
				(self setScript: (ScriptID 209 1) self) ; sStopViewPort
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSpaceBarQuirk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
				(gGame handsOff:)
			)
			(1
				(proc201_6 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gMessager say: 19 0 1 1 self 202) ; "I'm picking up a message from StarCon, sir."
			)
			(4
				(self setScript: (ScriptID 201 4) self) ; sBusyFlo
			)
			(5
				(self setScript: (ScriptID 209 0) self 209) ; sStartViewPort
			)
			(6
				(gMessager say: 19 0 18 0 self 202) ; "Wilco! You malingering moron! Get back to work!"
			)
			(7
				(self setScript: (ScriptID 209 1) self) ; sStopViewPort
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sAlienHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 3)
			)
			(1
				(proc201_6 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gMessager say: 15 0 0 1 self 202) ; "Captain, I'm intercepting a rather unusual message on StarCon priority frequency 2. I'm putting it on screen."
			)
			(4
				(self setScript: (ScriptID 201 4) self 0) ; sBusyFlo
			)
			(5
				(self setScript: (ScriptID 209 0) self 208) ; sStartViewPort
			)
			(6
				((ScriptID 209 2) setCycle: End self) ; viewPort
			)
			(7
				((ScriptID 209 2) setCel: 0) ; viewPort
				(= cycles 1)
			)
			(8
				(gMessager say: 15 0 0 2 self 202) ; "...Maggot to Dung Heep, come in Dung Heep."
			)
			(9
				(= cycles 1)
			)
			(10
				(gCurRoom newRoom: 206)
				(eureka state: 1)
				(self dispose:)
			)
		)
	)
)

(instance sAfterAlien of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 209 2) init: view: 218 setLoop: 0 cel: 0) ; viewPort
				(= seconds 2)
			)
			(1
				((ScriptID 209 2) setCycle: Fwd self) ; viewPort
				(= seconds 2)
			)
			(2
				(self setScript: (ScriptID 209 1) self) ; sStopViewPort
				(proc201_5 0)
			)
			(3
				(gMessager say: 15 0 0 3 self 202) ; "I'm sorry Captain, but I wasn't able to pin down the source of the transmission."
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 202)
	)
)

(instance sCycle of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 1 setCycle: Beg self)
			)
			(1
				(= seconds 1)
			)
			(2
				(client setCycle: End self)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance dConsole of Feature
	(properties
		x 257
		y 188
		z 30
		noun 9
		nsTop 135
		nsLeft 227
		nsBottom 182
		nsRight 287
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; Order
				(if (and (not (IsFlag 86)) (not (IsFlag 97)))
					(gGame handsOff:)
					(gCurRoom setScript: (ScriptID 217 0)) ; sCommandDroole
				else
					(super doVerb: theVerb &rest)
				)
			)
			(2 ; Talk
				(if (and (not (IsFlag 86)) (not (IsFlag 97)))
					(gGame handsOff:)
					(gCurRoom setScript: (ScriptID 217 1)) ; sTalkToDroole
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fConsole of Feature
	(properties
		x 48
		y 184
		z 30
		noun 14
		nsTop 138
		nsLeft 23
		nsBottom 170
		nsRight 74
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; Order
				(if (not (IsFlag 86))
					(gGame handsOff:)
					(gCurRoom setScript: (ScriptID 216 0)) ; sCommandFlo
				else
					(super doVerb: theVerb &rest)
				)
			)
			(2 ; Talk
				(if (not (IsFlag 86))
					(gGame handsOff:)
					(gCurRoom setScript: (ScriptID 216 1)) ; sTalkToFlo
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance capChair of Feature
	(properties
		x 162
		y 199
		z 30
		noun 5
		nsTop 149
		nsLeft 127
		nsBottom 189
		nsRight 197
	)
)

(instance vid1Monitor of Feature
	(properties
		x 100
		y 35
		noun 36
		nsTop 26
		nsLeft 89
		nsBottom 41
		nsRight 112
	)
)

(instance vid2Monitor of Feature
	(properties
		x 219
		y 34
		noun 37
		nsTop 26
		nsLeft 207
		nsBottom 41
		nsRight 232
	)
)

(instance vid3Monitor of Feature
	(properties
		x 160
		y 34
		noun 38
		nsTop 26
		nsLeft 143
		nsBottom 42
		nsRight 177
	)
)

(instance monitor1 of Prop
	(properties
		x 88
		y 46
		z 20
		view 201
		loop 6
		priority 10
		signal 16401
	)

	(method (init)
		(if (or (>= (eureka puke:) 4) (IsFlag 84))
			(self loop: 0 cel: 0 noun: 36 cycleSpeed: 16 setCycle: Osc)
		else
			(self loop: 6 cel: 0 noun: 6 setCycle: 0)
		)
		(super init: &rest)
	)
)

(instance monitor2 of Prop
	(properties
		x 208
		y 46
		z 20
		noun 37
		view 201
		loop 6
		cel 1
		priority 9
		signal 16401
	)

	(method (init)
		(cond
			((>= (eureka puke:) 4)
				(self loop: 2 cel: 0 cycleSpeed: 16 noun: 37 setCycle: Osc)
				(super init: &rest)
			)
			((not (IsFlag 84))
				(self loop: 6 cel: 1 noun: 40 setCycle: 0)
				(super init: &rest)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== view 201)
					(gMessager say: 40 1 0 1 self) ; "WD40's visage fills the small viewscreen."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance monitor3 of Prop
	(properties
		x 145
		y 45
		z 20
		noun 38
		view 201
		loop 1
		priority 9
		signal 16401
	)

	(method (init)
		(self cycleSpeed: 16 setCycle: Osc)
		(gSq5Music2 number: 105 loop: -1 play:)
		(super init: &rest)
	)
)

(instance rogArm of View
	(properties
		x 194
		y 142
		view 200
		loop 2
		priority 9
		signal 16
	)
)

(instance rogHand of Prop
	(properties
		x 200
		y 144
		view 200
		loop 3
		signal 1
	)
)

(instance panel of Prop
	(properties
		x 195
		y 144
		view 201
		loop 5
		priority 9
		signal 16
	)

	(method (init)
		(if (IsFlag 84)
			(self setLoop: 5 cel: (panel lastCel:) stopUpd:)
		else
			(self setLoop: 5 cel: 0 stopUpd:)
		)
		(super init: &rest)
	)

	(method (cue)
		(self dispose:)
	)

	(method (dispose)
		(panelNoise dispose:)
		(super dispose: &rest)
	)
)

(instance monkey of Prop
	(properties
		x 159
		y 65
		view 219
		loop 2
	)

	(method (init)
		(self
			scaleX: 20
			scaleY: 20
			maxScale: 20
			scaleSignal: 1
			setCel: 0
			setLoop: 2
		)
		(super init: &rest)
	)
)

(instance scraper of Actor
	(properties
		x 275
		y 49
		view 219
		priority 6
		signal 16
	)

	(method (init)
		(self x: 275 y: 49 setLoop: 0 setCel: 0)
		(super init: &rest)
	)
)

