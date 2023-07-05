;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use eRS)
(use n819)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use Path)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	RM500 0
)

(local
	[local0 15] = [140 170 209 146 276 140 40 135 153 60 253 146 241 153 -32768]
)

(instance RM500 of EcoRoom
	(properties
		picture 500
		style -32759
		horizon 20
		north 343
		east 520
		west 480
		picAngle 70
		vanishingX 180
		vanishingY -44
		walkOffTop 1
	)

	(method (doit)
		(super doit: &rest)
		(if (> gHowFast 0)
			(Palette palANIMATE 33 42 7)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(cond
					((IsFlag 73)
						(Narrator init: 2 0 0 (Random 74 76) 0 4)
					)
					((< ((User curEvent:) y:) 65)
						(Narrator init: 4 0 0 6) ; "Little healthy coral remains in this part of the reef. The cause is clear - an abandoned drilling rig has spread waste and silt through the area."
					)
					((not (IsFlag 73))
						((ScriptID 2 0) init: 1 0 0 3 1) ; Delphineus, "There's a lot of silt gook in this sand."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(3 ; Do
				((ScriptID 2 0) init: 1 0 0 12 1) ; Delphineus, "The sand here is nasty, Adam. You don't need any."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(= global250 4)
		(= global251 1)
		(gFeatures
			add:
				deadBrainCoral
				rigPiling
				drillShaft
				subBody
				submersibleHatch
				toilet
				toiletSeat
				subFin
				subSeat
				drillHole
				sickPlant
				subLight
				deadStarfish
			eachElementDo: #init
		)
		(if (not (IsFlag 334))
			(deadFish1 init: stopUpd:)
			(deadFish2 init: stopUpd:)
			(deadFish3 init: stopUpd:)
			(deadFish4 init: stopUpd:)
			(deadFish5 init: stopUpd:)
			(deadFish6 init: stopUpd:)
		)
		(if (not (IsFlag 307))
			(lure init: setScript: lureScript)
		)
		(if (IsFlag 56)
			(lid posn: 106 141 cel: 1)
			(if (not (IsFlag 57))
				(ball init: stopUpd:)
			)
		else
			(lid posn: 98 136 cel: 2)
		)
		(lid init: stopUpd:)
		(subPanel init: stopUpd:)
		(NormalEgo)
		(gEgo init: ignoreHorizon: 1 z: 30)
		(if (not (IsFlag 73))
			(NormalDelph)
			(gDelph
				init:
				posn: (if (== gPrevRoomNum west) 35 else 330) 56
				ignoreActors: 1
				ignoreHorizon: 1
				setScript: delScript
			)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 168 100 171 122 119 122 122 100
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 86 319 126 263 105 263 86
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 192 182 184 152 184 135 226 100 269 116 269 124 294 131 296 152 238 184
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 164 33 186 319 187 319 389 0 389
					yourself:
				)
			setRegions: 51 ; bubblesRegion
		)
		(if (IsFlag 73)
			(= north 345)
		)
		(switch gPrevRoomNum
			(east
				(= style 11)
				(gEgo y: (+ (gEgo y:) (gEgo z:)))
				(if (== global124 gCurRoomNum)
					(redFish
						posn: 150 85
						loop: 1
						cycleSpeed: 4
						init:
						setMotion: PolyPath -50 84
					)
					(= global124 480)
				)
			)
			(west
				(= style 12)
				(if (IsFlag 104)
					(gEgo setScript: swimOutOfBrainCoral)
				else
					(gEgo y: (+ (gEgo y:) (gEgo z:)))
				)
				(if (== global124 gCurRoomNum)
					(redFish
						posn: 180 55
						loop: 0
						cycleSpeed: 4
						init:
						setMotion: PolyPath 340 45
					)
					(= global124 520)
				)
			)
			(north
				(gEgo x: 10)
			)
		)
		(super init:)
		(if (!= (gLongSong number:) 440)
			(gLongSong number: 440 loop: -1 play:)
		)
		(if (!= (gLongSong2 number:) 445)
			(gLongSong2 number: 445 loop: -1 flags: 1 play:)
		)
	)
)

(instance lureScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lure setCycle: End self)
			)
			(1
				(lureSound play:)
				(lure cel: 0 stopUpd:)
				(= state -1)
				(= cycles 10)
			)
		)
	)
)

(instance lureSound of Sound
	(properties
		number 504
	)
)

(instance delScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gDelph setMotion: 0)
				(= seconds (Random 3 6))
			)
			(1
				(delsPath value: 0)
				(gDelph setMotion: delsPath)
				(= seconds (Random 8 14))
			)
			(2
				(if (< 112 (gDelph x:) 180)
					(-- state)
					(gDelph setMotion: MoveTo 40 205 self)
				else
					(self init:)
				)
			)
		)
	)
)

(instance swimOutOfBrainCoral of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setCycle: 0
					view: 502
					loop: 2
					cel: 0
					posn: 63 180 0
					setPri: 15
					cycleSpeed: 4
				)
				(= seconds 1)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(NormalEgo)
				(gEgo view: 805 loop: 4 posn: 94 158 z: 30)
			)
			(3
				(ClearFlag 104)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance pryOffLid of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(lid hide:)
				(gEgo
					setCycle: 0
					posn: 124 156
					view: 501
					setLoop: 0
					cel: 0
					cycleSpeed: 20
					setCycle: End self
				)
			)
			(2
				(NormalEgo)
				(gEgo posn: 173 157 30 loop: 1 heading: 270)
				(lid posn: 106 141 loop: 3 cel: 1 show:)
				(SetScore 5 318)
				(Narrator init: 4 0 0 42 self) ; "Adam places the trident under one corner of the tank lid and yanks. The lid pops off and falls to the sand."
			)
			(3
				(ball init: stopUpd:)
				(SetFlag 56)
				(self dispose:)
			)
		)
	)
)

(instance getFloat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setCycle: 0
					view: 501
					posn: 141 134 0
					setPri: 11
					cycleSpeed: 25
					setLoop: 1
					cel: 0
					setCycle: CT 4 1 self
				)
			)
			(1
				(ball dispose:)
				(gSoundEffects number: 500 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(2
				(Narrator init: 4 0 0 25 self) ; "Adam pulls the toilet float from inside the tank."
			)
			(3
				((ScriptID 2 1) init: 2 0 0 6 1 self) ; Adam, "What's this round thing? Oh, I know, it's called a float."
			)
			(4
				((ScriptID 2 0) init: 1 0 0 10 1 self) ; Delphineus, "Round... Let's see what does that remind me of..."
			)
			(5
				((ScriptID 2 1) init: 2 0 0 7 1 self) ; Adam, "It's the prophecy again! A floating orb! Not what I expected at all."
			)
			(6
				((ScriptID 2 0) init: 1 0 0 11 1 self) ; Delphineus, "Even the Oracle has a sense of humor, I suppose."
			)
			(7
				(NormalEgo)
				(gEgo z: 30 y: 164)
				(SetFlag 57)
				(SetScore 2 319)
				(gEgo get: 27) ; float
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance openSubPanel of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetScore 5 316)
				(gEgo
					posn: 271 93 0
					setCycle: 0
					ignoreActors:
					illegalBits: 0
					view: 501
					setLoop: 2
					cel: 0
					setPri: 8
					cycleSpeed: 16
					setCycle: CT 10 1 self
				)
			)
			(1
				(gSoundEffects number: 502 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(2
				(subPanel setPri: 5)
				(gEgo
					posn: 254 88
					view: 805
					loop: 6
					setCycle: 0
					heading: 50
					setMotion: MoveTo 276 91 self
				)
			)
			(3
				(NormalEgo)
				(gEgo z: 30 y: 121)
				(gCurRoom setScript: showPanel)
			)
		)
	)
)

(instance showPanel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gDelph setPri: 9 setScript: 0 setMotion: 0)
				(gCast eachElementDo: #stopUpd)
				(= ticks 3)
			)
			(1
				(if (subPanel priority:)
					(if (not (IsFlag 59))
						(hammer
							init:
							cel: (if (IsFlag 59) 6 else 0)
							stopUpd:
						)
					)
					(if (not (gEgo has: 30)) ; hackSaw
						(saw init: stopUpd:)
					)
					(if (not (IsFlag 84))
						(fishes init:)
						(= seconds 3)
					else
						(= ticks 3)
					)
					(openPanel init: stopUpd:)
				)
				(panelInset init: show: stopUpd:)
			)
			(2
				(if (not (IsFlag 84))
					(fishes cel: 0 cycleSpeed: 20 setCycle: End self)
				else
					(= ticks 2)
				)
			)
			(3
				(if (not (IsFlag 84))
					(SetFlag 84)
					(fishes dispose:)
					(FishNarrator init: 3 0 0 1 self) ; "There's just no privacy on this reef. We're going back to the city!"
				else
					(= ticks 2)
				)
			)
			(4
				(if (or (IsFlag 73) (IsFlag 59))
					(= ticks 2)
				else
					((ScriptID 2 0) init: 1 0 0 6 1 self) ; Delphineus, "Gross me out! It's a mess in there."
				)
			)
			(5
				(HandsOn)
				(gTheIconBar disable: 0)
			)
			(6
				(subPanel setPri: 0 stopUpd:)
				(= cycles 6)
			)
			(7
				(panelInset hide:)
				(hammer hide:)
				(saw hide:)
				(openPanel hide:)
				(= cycles 3)
			)
			(8
				(panelInset dispose:)
				(hammer dispose:)
				(saw dispose:)
				(openPanel dispose:)
				(= ticks 3)
			)
			(9
				(gCast eachElementDo: #startUpd)
				(= ticks 3)
			)
			(10
				(if (not (IsFlag 73))
					(gDelph setPri: -1 setScript: delScript)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance tryToGetHammer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gSoundEffects number: 503 loop: 1 play:)
				(hammer cel: 1 setCycle: End self)
			)
			(1
				(Narrator init: 4 0 0 18 self) ; "Adam picks up the hammer, but it crumbles into rust."
			)
			(2
				(hammer stopUpd:)
				(SetFlag 59)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance toiletTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 1 0 0 7 1 self) ; Delphineus, "Hey, somebody got rid of a statue."
			)
			(1
				((ScriptID 2 1) init: 2 0 0 1 1 self) ; Adam, "Not exactly, Delphineus. It's a useful object."
			)
			(2
				((ScriptID 2 0) init: 1 0 0 8 1 self) ; Delphineus, "Yeah? What's it used for?"
			)
			(3
				((ScriptID 2 1) init: 2 0 0 2 1 self) ; Adam, "Never mind. Anyhow, it looks like they could have fixed it."
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance lureTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 1 0 0 4 1 self) ; Delphineus, "Oh, dear, some fish fell for a line, so to speak. You might say it was lured into difficulties."
			)
			(1
				((ScriptID 2 1) init: 2 0 0 4 1 self) ; Adam, "Why not just say it's a fishing lure?"
			)
			(2
				((ScriptID 2 0) init: 1 0 0 9 1 self) ; Delphineus, "What and miss the chance for a witty riposte?"
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance redFish of Actor
	(properties
		yStep 5
		view 443
		signal 24576
		xStep 9
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(cond
					((IsFlag 73)
						(Narrator init: 2 0 0 (Random 74 76) 0 4)
					)
					((== gPrevRoomNum 520)
						(Narrator init: 1 0 0 49) ; "Yech, soggy seats. I wouldn't sit on them if I were you."
					)
					(else
						(Narrator init: 1 0 0 50) ; "That drill bit reminds me of all the noise and shaking when they were drilling. Makes me nervous just to think of it."
					)
				)
			)
			(3 ; Do
				((ScriptID 2 1) init: 2 0 0 1 1 0 50) ; Adam, "Hey, give us that key back!"
			)
			(10 ; Recycle
				(Narrator init: 1 0 0 79 0 50) ; "Adam can't bag the fish - it's too fast."
			)
			(4 ; Inventory
				(switch invItem
					(29 ; fishLure
						(Narrator init: 1 0 0 75 0 50) ; "The red fish eyes the fishing lure but decides it's the wrong flavor."
					)
					(12 ; trident
						(Narrator init: 1 0 0 74 0 50) ; "Spearfishing is out of the question."
					)
					(30 ; hackSaw
						(Narrator init: 1 0 0 76 0 50) ; "Bloodthirsty, aren't you?"
					)
					(13 ; sharpShell
						(Narrator init: 1 0 0 77 0 50) ; "Fileting the red fish is not a good idea."
					)
					(else
						(Narrator init: 1 0 0 78 0 50) ; "That won't stop the red fish."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance panelInset of View
	(properties
		x 198
		y 266
		z 199
		sightAngle 360
		view 500
		priority 12
		signal 18448
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (not (InRect nsLeft nsTop nsRight 95 event))
			(event claimed: 1)
			((gCurRoom script:) cue:)
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance openPanel of View
	(properties
		x 205
		y 267
		z 200
		sightAngle 360
		view 500
		loop 1
		priority 13
		signal 18448
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (and (IsFlag 317) (IsFlag 59))
					(Narrator init: 4 0 0 24) ; "Nothing of importance remains inside the panel."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(3 ; Do
				(if (and (IsFlag 317) (IsFlag 59))
					(Narrator init: 4 0 0 39) ; "Adam has taken everything of use."
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

(instance saw of Prop
	(properties
		x 205
		y 267
		z 201
		sightAngle 360
		view 500
		loop 2
		priority 14
		signal 18448
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 59)
					((ScriptID 2 1) init: 2 0 0 3 1) ; Adam, "It's some kind of steel saw!"
				else
					(Narrator init: 4 0 0 19) ; "An old hammer covers another tool."
				)
			)
			(3 ; Do
				(if (IsFlag 59)
					(Narrator init: 4 0 0 21) ; "Adam picks up the steel saw."
					(gEgo get: 30) ; hackSaw
					(SetScore 2 317)
					(self dispose:)
				else
					(hammer doVerb: 3)
				)
			)
			(10 ; Recycle
				(Narrator init: 4 0 0 64) ; "Adam might need the hacksaw. It's still strong and sturdy."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance hammer of Prop
	(properties
		x 205
		y 269
		z 202
		sightAngle 360
		view 500
		loop 3
		priority 15
		signal 18448
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 59)
					(Narrator init: 4 0 0 51) ; "The metal hammer head has fallen off. This hammer will never rap again."
				else
					(Narrator init: 4 0 0 19) ; "An old hammer covers another tool."
				)
			)
			(3 ; Do
				(if (IsFlag 59)
					(Narrator init: 4 0 0 52) ; "The hammer head is useless."
				else
					(gEgo setScript: tryToGetHammer)
				)
			)
			(10 ; Recycle
				(if (IsFlag 59)
					(self dispose:)
					(Narrator init: 4 0 0 53) ; "Adam places the remains of the hammer in the garbage bag."
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fishes of Prop
	(properties
		x 202
		y 57
		view 500
		loop 4
		priority 15
		signal 18448
	)
)

(instance lure of Prop
	(properties
		x 139
		y 49
		approachX 147
		approachY 94
		view 501
		loop 5
		priority 8
		signal 16400
		cycleSpeed 40
	)

	(method (init)
		(line init: stopUpd:)
		(self approachVerbs: 3 2) ; Do, Look
		(super init: &rest)
	)

	(method (dispose)
		(line dispose:)
		(super dispose: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 133)
					(Narrator init: 4 0 0 38) ; "A fishing lure is snarled around the piling here, but the hook is gone. The lure fools a fish into thinking an attractive meal is swimming by."
				else
					(SetFlag 133)
					(gCurRoom setScript: lureTalk)
				)
			)
			(3 ; Do
				(gEgo get: 29) ; fishLure
				(Narrator init: 4 0 0 54) ; "Adam picks up the brightly-colored fishing lure."
				(SetScore 2 307)
				(self dispose:)
			)
			(10 ; Recycle
				(Narrator init: 4 0 0 55) ; "The hook is gone and the lure might still be useful. It shouldn't be thrown away."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance ball of View
	(properties
		x 100
		y 140
		approachX 156
		approachY 129
		lookStr 17
		view 501
		loop 3
		priority 11
		signal 16400
	)

	(method (init)
		(self approachVerbs: 3) ; Do
		(super init: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(cond
					((IsFlag 57)
						(Narrator init: 4 0 0 32) ; "The broken valve is of no use to Adam."
					)
					((IsFlag 56)
						(gCurRoom setScript: getFloat)
					)
					(else
						(Narrator init: 4 0 0 10) ; "The lid of the toilet tank is jammed in place."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance lid of View
	(properties
		x 98
		y 136
		approachX 156
		approachY 129
		view 501
		loop 3
		cel 2
		priority 11
		signal 16400
	)

	(method (init)
		(self approachVerbs: 3 4) ; Do, Inventory
		(super init: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(cond
					((IsFlag 73)
						(Narrator init: 2 0 0 (Random 74 76) 0 4)
					)
					((IsFlag 319)
						(Narrator init: 4 0 0 34) ; "Adam has removed the float from the toilet tank. All that remains is a broken valve."
					)
					((IsFlag 318)
						(Narrator init: 4 0 0 17) ; "The toilet has a broken valve. However, the round, rubber float is in good condition."
					)
					(else
						(Narrator init: 4 0 0 40) ; "The toilet tank is on its side. The lid is jammed over the tank at one corner."
					)
				)
			)
			(3 ; Do
				(cond
					((IsFlag 73)
						(Narrator init: 2 0 0 (Random 77 79) 0 4)
					)
					((IsFlag 57)
						(Narrator init: 4 0 0 32) ; "The broken valve is of no use to Adam."
					)
					((IsFlag 56)
						(gCurRoom setScript: getFloat)
					)
					(else
						(Narrator init: 4 0 0 10) ; "The lid of the toilet tank is jammed in place."
					)
				)
			)
			(4 ; Inventory
				(if (== invItem 12) ; trident
					(if (IsFlag 56)
						(Narrator init: 4 0 0 63) ; "Don't pry - at least not again."
					else
						(gCurRoom setScript: pryOffLid)
					)
				else
					(Narrator
						init:
							4
							0
							0
							(switch invItem
								(30 56) ; hackSaw
								(21 57) ; healingPotion
								(17 58) ; spine
								(26 59) ; steelCable
								(27 60) ; float
								(13 61) ; sharpShell
								(else 62)
							)
					)
				)
			)
			(10 ; Recycle
				(Narrator init: 4 0 0 33) ; "The toilet is too heavy to remove."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance subPanel of Prop
	(properties
		x 293
		y 84
		onMeCheck 128
		approachX 258
		approachY 84
		lookStr 4
		view 501
		loop 4
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors: 1 setPri: 0 approachVerbs: 3 2 stopUpd:) ; Do, Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(cond
					((== priority 0)
						(Narrator init: 4 0 0 4) ; "The panel is closed."
					)
					((IsFlag 74)
						(Narrator init: 4 0 0 17) ; "The toilet has a broken valve. However, the round, rubber float is in good condition."
					)
					(else
						(Narrator init: 4 0 0 13)
						((ScriptID 2 0) init: 1 0 0 6 1) ; Delphineus, "Gross me out! It's a mess in there."
					)
				)
			)
			(3 ; Do
				(if (!= priority 0)
					(if (IsFlag 317)
						(Narrator init: 4 0 0 39) ; "Adam has taken everything of use."
					else
						(gCurRoom setScript: showPanel)
					)
				else
					(gCurRoom setScript: openSubPanel)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance deadFish1 of View
	(properties
		x 294
		y 183
		lookStr 11
		view 560
		cel 3
		signal 16384
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 10 3) ; Recycle, Do
			(Narrator init: 1 0 0 150 0 4) ; "The fish seem contaminated. Even with his diving gloves on, Adam is afraid to touch them."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance deadFish2 of View
	(properties
		x 162
		y 174
		lookStr 11
		view 560
		cel 4
		signal 16384
	)

	(method (doVerb)
		(deadFish1 doVerb: &rest)
	)
)

(instance deadFish3 of View
	(properties
		x 295
		y 164
		lookStr 11
		view 560
		loop 1
		cel 4
		signal 16384
	)

	(method (doVerb)
		(deadFish1 doVerb: &rest)
	)
)

(instance deadFish4 of View
	(properties
		x 236
		y 183
		lookStr 11
		view 560
		loop 1
		cel 1
		signal 16384
	)

	(method (doVerb)
		(deadFish1 doVerb: &rest)
	)
)

(instance deadFish5 of View
	(properties
		x 311
		y 179
		lookStr 11
		view 560
		loop 1
		signal 16384
	)

	(method (doVerb)
		(deadFish1 doVerb: &rest)
	)
)

(instance deadFish6 of View
	(properties
		x 121
		y 155
		lookStr 11
		view 560
		loop 1
		cel 3
		signal 16384
	)

	(method (doVerb)
		(deadFish1 doVerb: &rest)
	)
)

(instance deadBrainCoral of Feature
	(properties
		y 190
		onMeCheck 8
		lookStr 2
	)

	(method (doVerb theVerb invItem)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(Narrator init: 4 0 0 31) ; "The brain coral skeleton is of no use to Adam."
				)
			)
			(10 ; Recycle
				(Narrator init: 4 0 0 27) ; "There's too much debris here to clear."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance rigPiling of Feature
	(properties
		onMeCheck 2048
	)

	(method (doVerb theVerb invItem)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 1 0 0 1 1) ; Delphineus, "Some company or other was drilling for oil down here. They went out of business but really trashed the place first."
				)
			)
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(Narrator init: 4 0 0 15) ; "The pilings are buried deep in the ocean floor. Adam can't budge them."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance drillShaft of Feature
	(properties
		onMeCheck 512
	)

	(method (doVerb theVerb invItem)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 1 0 0 14 1) ; Delphineus, "That drill bit reminds me of all the noise and shaking when they were drilling. Makes me nervous just to think of it."
				)
			)
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(Narrator init: 4 0 0 1) ; "The rig is broken down and abandoned. It's not in good working order."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance subBody of Feature
	(properties
		onMeCheck 32
		lookStr 3
	)

	(method (doVerb theVerb invItem)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(Narrator init: 4 0 0 28) ; "The diving vehicle is going to stay right here, due to a general level of malfunction."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance submersibleHatch of Feature
	(properties
		onMeCheck 256
		lookStr 5
	)

	(method (doVerb theVerb invItem)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(Narrator init: 4 0 0 29) ; "The hatch is too crumpled and rusted to close."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance toilet of Feature
	(properties
		onMeCheck 16384
	)

	(method (doVerb theVerb invItem)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(gCurRoom setScript: toiletTalk)
				)
			)
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(Narrator init: 4 0 0 27) ; "There's too much debris here to clear."
				)
			)
			(10 ; Recycle
				(Narrator init: 4 0 0 33) ; "The toilet is too heavy to remove."
			)
			(4 ; Inventory
				(Narrator
					init:
						4
						0
						0
						(switch invItem
							(30 56) ; hackSaw
							(21 57) ; healingPotion
							(17 58) ; spine
							(26 59) ; steelCable
							(27 60) ; float
							(13 61) ; sharpShell
							(else 62)
						)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance toiletSeat of Feature
	(properties
		onMeCheck 4096
		lookStr 9
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(Narrator init: 4 0 0 35) ; "Sitting on the toilet seat would be pointless. It wouldn't help, either."
				)
			)
			(10 ; Recycle
				(Narrator init: 4 0 0 27) ; "There's too much debris here to clear."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance subSeat of Feature
	(properties
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 1 0 0 5 1) ; Delphineus, "I've never understood the appeal of naugahyde. Of course, I dislike leather for the obvious reasons."
				)
			)
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 1 0 0 13 1) ; Delphineus, "Yech, soggy seats. I wouldn't sit on them if I were you."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance subFin of Feature
	(properties
		onMeCheck 16
		lookStr 65
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Narrator init: 4 0 0 66) ; "Don't be finny!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance drillHole of Feature
	(properties
		onMeCheck 1024
		lookStr 36
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(Narrator init: 4 0 0 37) ; "Adam can't plug the bore hole. He'll have to tell his Dad about it later."
				)
			)
			(10 ; Recycle
				(Narrator init: 4 0 0 37) ; "Adam can't plug the bore hole. He'll have to tell his Dad about it later."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sickPlant of Feature
	(properties
		onMeCheck 4
		lookStr 2
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(Narrator init: 4 0 0 27) ; "There's too much debris here to clear."
				)
			)
			(10 ; Recycle
				(Narrator init: 4 0 0 27) ; "There's too much debris here to clear."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance subLight of Feature
	(properties
		onMeCheck 8192
		lookStr 22
	)

	(method (doVerb theVerb invItem)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Narrator init: 4 0 0 23) ; "The light is broken beyond repair."
			)
			(4 ; Inventory
				(if (== invItem 12) ; trident
					(Narrator init: 4 0 0 41) ; "Prying out a broken light would be pointless. It wouldn't even be illuminating."
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance deadStarfish of Feature
	(properties
		onMeCheck 2
		lookStr 26
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(Narrator init: 4 0 0 27) ; "There's too much debris here to clear."
				)
			)
			(10 ; Recycle
				(Narrator init: 4 0 0 27) ; "There's too much debris here to clear."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance delsPath of Path
	(properties)

	(method (at param1)
		(return [local0 param1])
	)
)

(instance FishNarrator of Narrator
	(properties
		charNum 17
	)
)

(instance line of View
	(properties
		x 139
		y 49
		view 501
		loop 4
		cel 1
		priority 8
		signal 16
	)

	(method (doVerb)
		(lure doVerb: &rest)
	)
)

