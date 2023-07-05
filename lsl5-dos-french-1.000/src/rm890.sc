;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 890)
(include sci.sh)
(use Main)
(use eRS)
(use Door)
(use Patti)
(use Osc)
(use RandCycle)
(use Polygon)
(use Feature)
(use LoadMany)
(use Rev)
(use Sound)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	rm890 0
)

(local
	seenMsg
	recording
	recorded
	jammed
	usedMixer
	egoMove
	mixerLookCounter
	mixerDoCounter
	volumeUp
	rewoundTape
	displayVar
)

(instance rm890 of LLRoom
	(properties
		picture 890
		south 880
	)

	(method (init)
		(LoadMany rsVIEW 872 880 882 883 890 891)
		(LoadMany rsSOUND 891 146 800 801 802)
		(LoadMany rsSCRIPT 969)
		(HandsOn)
		(SetFFRoom 0)
		(gEgo init: actions: ActionsKRAP normalize: 872 x: 70 y: 185)
		(super init:)
		(fElectronics1 init: approachVerbs: 3 4 2) ; Do, Inventory, Look
		(fElectronics2 init: approachVerbs: 3 4 2) ; Do, Inventory, Look
		(fElectronics3 init: approachVerbs: 3 4 2) ; Do, Inventory, Look
		(fElectronics4 init: approachVerbs: 3 4 2) ; Do, Inventory, Look
		(fElectronics5 init: approachVerbs: 3 4 2) ; Do, Inventory, Look
		(fElectronics6 init:)
		(fElectronics7 init:)
		(speaker1 init:)
		(speaker2 init:)
		(speaker3 init:)
		(tapeShelf init: approachVerbs: 3 2) ; Do, Look
		(shelf init: approachVerbs: 3 2) ; Do, Look
		(recorder init: approachVerbs: 3 4 2) ; Do, Inventory, Look
		(tape init: approachVerbs: 3 4 2) ; Do, Inventory, Look
		(if (== ((Inv at: 12) owner:) 3) ; Money
			(tapeHole init: addToPic:)
			(tape setLoop: 0 x: 35 y: 142 stopUpd:)
		else
			(tape stopUpd:)
		)
		(mixer init: approachVerbs: 3 2) ; Do, Look
		(microphone init: approachVerbs: 3 5 2) ; Do, Talk, Look
		(glass init: stopUpd:)
		(lights init: approachVerbs: 3 2 stopUpd:) ; Do, Look
		(if (IsFlag 154)
			(lights setCycle: Fwd startUpd:)
		)
		(gAddToPics doit:)
		(recSignA init: setCycle: Fwd)
		(hammer_a init: setCycle: RandCycle cycleSpeed: 12)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 98 189 103 187 235 187 289 166 284 154 265 161 189 133 112 133 17 176 29 189 0 189
					yourself:
				)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 890 0) ; "You are inside K-RAP radio's Control Room B. For such a large room, it certainly looked smaller from the outside. The walls are filled with a myriad of recording equipment, electronic gear, mixers, microphones, recording tape, etc. etc."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (doit)
		(cond
			(script
				(script doit:)
			)
			((gEgo edgeHit:)
				(gCurRoom newRoom: 880)
			)
			((& (gEgo onControl:) $2000)
				(if (and jammed (not egoMove))
					(TPrint 890 1) ; "Someone has jammed the door shut with a large, immovable object!"
					(= egoMove 1)
				)
			)
			(egoMove
				(= egoMove 0)
			)
			(else
				(super doit:)
			)
		)
	)

	(method (dispose)
		(LoadMany 0 969)
		(super dispose:)
	)
)

(instance sCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo hide:)
				(tape hide:)
				(glass hide:)
				(lights hide:)
				(recSignA dispose:)
				((gCurRoom obstacles:) dispose:)
				(gTheIconBar disable:)
				(gCurRoom drawPic: 880 picture: 880 curPic: 880)
				(gTheIconBar enable:)
				(doorA init: close:)
				(doorB init:)
				(mikestand init: stopUpd:)
				(recSign init: setCycle: Fwd)
				(gAddToPics doit:)
				(hammer_a
					setLoop: -1
					view: 882
					x: 65
					y: 86
					xStep: 8
					yStep: 4
					cycleSpeed: 12
					moveSpeed: 12
					setCycle: Walk
					setMotion: MoveTo 156 123 self
				)
			)
			(1
				(TPrint 890 2) ; "Oh, no! P. C. Hammer has noticed the "Recording" sign over the window of Control Room B, realized you are not an engineer, and is heading for your room!"
				(hammer_a
					view: 883
					xStep: 3
					yStep: 2
					cycleSpeed: 6
					moveSpeed: 6
					setLoop: 2
					setMotion: MoveTo 186 123 self
				)
				(mikestand startUpd: setMotion: MoveTo 205 123)
			)
			(2
				(= jammed 1)
				(mikestand stopUpd:)
				(hammer_a
					setLoop: -1
					view: 882
					xStep: 8
					yStep: 4
					cycleSpeed: 12
					moveSpeed: 12
					setCycle: Walk
					setMotion: MoveTo 30 124 self
				)
			)
			(3
				(TPrint 890 3) ; "Blocking the only way out of the control room with that heavy microphone stand, he heads for the elevator!"
				(TPrint 890 4) ; "You're in trouble now, Patti!"
				(hammer_a setMotion: MoveTo -30 124 self)
			)
			(4
				(doorA dispose:)
				(doorB dispose:)
				(mikestand dispose:)
				(hammer_a dispose:)
				(recSign dispose:)
				(gTheIconBar disable:)
				(gCurRoom
					drawPic: 890
					picture: 890
					curPic: 890
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 319 0 319 189 98 189 103 187 235 187 289 166 284 154 265 161 189 133 112 133 17 176 29 189 0 189
							yourself:
						)
				)
				(gTheIconBar enable:)
				(gEgo show: observeControl: 16384)
				(tape show:)
				(tapeHole init: addToPic:)
				(glass show: stopUpd:)
				(lights show:)
				(= seconds 3)
			)
			(5
				(TPrint 890 5) ; "Wait! What's that!!"
				(TPrint 890 6) ; "By carefully staring across the lobby through the control room window, you notice P. C. Hammer punching an access code into the keypad of the shower elevator. From the angle of his finger and the movement of his hand, you learn the secret access code. Knowing that code, you could escape this area and return upstairs!"
				(TPrint 890 7) ; "Now if you could only find a way out of this room!"
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fElectronics1 of Feature
	(properties
		x 150
		y 199
		nsTop 165
		nsLeft 117
		nsBottom 189
		nsRight 184
		description {the giant speaker}
		sightAngle 40
		approachX 151
		approachY 187
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 890 8) ; "You could swear these are genuine Altec "Voice of the Theatre" speakers. You haven't seen these babies in years!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fElectronics2 of Feature
	(properties
		x 283
		y 187
		nsTop 163
		nsLeft 247
		nsBottom 189
		nsRight 319
		description {the electronic equipment}
		sightAngle 40
		approachX 235
		approachY 187
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 890 9) ; "Everywhere you look, you see buttons, switches, lights, reels of tape, and tape drives."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fElectronics3 of Feature
	(properties
		x 301
		y 169
		nsTop 129
		nsLeft 283
		nsBottom 163
		nsRight 319
		description {the electronic equipment}
		sightAngle 40
		approachX 281
		approachY 169
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 890 10) ; "Everywhere you look, you see buttons, switches, lights, reels of tape, and tape drives."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fElectronics4 of Feature
	(properties
		x 277
		y 151
		nsTop 106
		nsLeft 235
		nsBottom 135
		nsRight 319
		description {the left large-hub reel-to-reel recorder}
		sightAngle 40
		approachX 237
		approachY 151
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 890 11) ; "This recorder will not operate without a reel of tape."
			)
			(2 ; Look
				(TPrint 890 12) ; "You haven't seen a 2", 24-track, 3"-hub reel-to-reel recorder in years. What antiquated equipment! Where's K-RAP's digital equipment?"
			)
			(4 ; Inventory
				(switch invItem
					(12 ; Money
						(TPrint 890 13) ; "You are unable to mount your reel's tiny hole onto this recorder's massive spindle!"
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

(instance fElectronics5 of Feature
	(properties
		x 215
		y 139
		nsTop 106
		nsLeft 196
		nsBottom 125
		nsRight 235
		description {the right large-hub reel-to-reel recorder}
		sightAngle 40
		approachX 205
		approachY 139
	)

	(method (doVerb theVerb invItem)
		(fElectronics4 doVerb: theVerb invItem &rest)
	)
)

(instance fElectronics6 of Feature
	(properties
		x 265
		y 63
		nsTop 17
		nsLeft 274
		nsBottom 109
		nsRight 319
		description {the electronic equipment}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 890 14) ; "Everywhere you look, you see buttons, switches, lights, reels of tape, and tape drives. Unfortunately, they are much too high for you to reach."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fElectronics7 of Feature
	(properties
		x 265
		y 63
		nsTop 30
		nsLeft 212
		nsBottom 109
		nsRight 274
		description {the electronic equipment}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 890 15) ; "Everywhere you look, you see buttons, switches, lights, reels of tape, and tape drives. Unfortunately, they are much too high for you to reach."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance speaker1 of Feature
	(properties
		x 100
		y 60
		nsTop 43
		nsLeft 86
		nsBottom 78
		nsRight 114
		description {the monitor speaker}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 890 16) ; "You could swear these are genuine Altec "Voice of the Theatre" speakers. You haven't seen these babies in years!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance speaker2 of Feature
	(properties
		x 199
		y 57
		nsTop 42
		nsLeft 186
		nsBottom 72
		nsRight 212
		description {the monitor speaker}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 890 16) ; "You could swear these are genuine Altec "Voice of the Theatre" speakers. You haven't seen these babies in years!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance speaker3 of Feature
	(properties
		x 10
		y 24
		nsBottom 49
		nsRight 21
		description {the monitor speaker}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 890 16) ; "You could swear these are genuine Altec "Voice of the Theatre" speakers. You haven't seen these babies in years!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance shelf of Feature
	(properties
		x 154
		y 87
		nsTop 63
		nsLeft 120
		nsBottom 131
		nsRight 189
		description {the equipment rack}
		sightAngle 40
		approachX 155
		approachY 139
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 890 17) ; "This shelf contains a lot of electronic equipment, most of it old, plus a shelf filled with blank reel-to-reel tapes."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance tapeShelf of Feature
	(properties
		x 154
		y 87
		nsTop 79
		nsLeft 138
		nsBottom 102
		nsRight 169
		description {the shelf of tapes}
		sightAngle 40
		approachX 155
		approachY 139
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 890 18) ; "Why, here's what you need! A shelf filled with blank, reel-to-reel recording tapes."
			)
			(3 ; Do
				(if (!= ((Inv at: 12) owner:) 0) ; Money
					(TPrint 890 19) ; "You have no use for another tape. Use the one you have!"
				else
					(gEgo setScript: GetTape)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance mixer of Feature
	(properties
		x 70
		y 144
		nsTop 107
		nsLeft 66
		nsBottom 126
		nsRight 104
		description {the microphone mixer}
		sightAngle 40
		approachX 90
		approachY 140
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch (++ mixerLookCounter)
					(1
						(TPrint 890 20) ; "Before you lies an elaborate microphone mixer and studio control panel console. The names of the various downstairs studios are engraved on the potentiometers."
					)
					(2
						(TPrint 890 21) ; "This volume control says, "Control Room C.""
					)
					(3
						(TPrint 890 22) ; "This potentiometer says, "Studio C.""
					)
					(4
						(TPrint 890 23) ; "This slider says, "Control Room B.""
					)
					(5
						(TPrint 890 24) ; "This pot is labeled, "Studio B.""
					)
					(6
						(TPrint 890 25) ; "This controls the volume coming from "Control Room A.""
					)
					(7
						(TPrint 890 26) ; "This fader is labeled, "Studio A.""
					)
					(else
						(TPrint 890 27) ; "The rest of these are labeled "Carts (A-F)," "Tables (A-C)," "CDs (A-R).""
					)
				)
			)
			(3 ; Do
				(cond
					(jammed
						(gEgo setScript: useMixer)
					)
					((== (++ mixerDoCounter) 1)
						(TPrint 890 28) ; "The console contains many knobs, sliders, meters and buttons. Which one will you choose?"
					)
					(else
						(gEgo setScript: useMixer)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance microphone of Feature
	(properties
		x 59
		y 145
		nsTop 102
		nsLeft 50
		nsBottom 120
		nsRight 68
		description {the microphone}
		sightAngle 40
		approachX 89
		approachY 141
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 890 29) ; "A professional-quality, high-fidelity, studio ribbon microphone hangs from a boom over the studio console."
			)
			(3 ; Do
				(TPrint 890 30) ; "You carefully aim the microphone so it's pointing just below your mouth."
			)
			(5 ; Talk
				(if jammed
					(if volumeUp
						(gEgo setScript: useMikeScript)
					else
						(TPrint 890 31) ; "You hear your voice echo through the room's monitor speakers. The speakers are amazingly loud; loud enough to break glass."
					)
				else
					(TPrint 890 32) ; "You carefully check the level of your voice on the mixer. It's okay."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance recorder of Feature
	(properties
		x 26
		y 163
		nsTop 115
		nsBottom 146
		nsRight 52
		description {the reel-to-reel tape recorder}
		approachX 42
		approachY 163
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(cond
					(recording
						(gEgo setScript: turnRecorderOff)
					)
					((== ((Inv at: 12) owner:) 3) ; Money
						(cond
							(rewoundTape
								(gEgo setScript: getRecordedTape)
							)
							(recorded
								(gEgo setScript: rewindTape)
							)
							((IsFlag 154)
								(gEgo setScript: turnRecorderOn)
							)
							(else
								(TPrint 890 33) ; "What's the use of recording silence? There no signal currently being fed to this deck."
							)
						)
					)
					(else
						(TPrint 890 34) ; "The recorder's automatic shut-off prevents it from operating without a properly mounted tape."
					)
				)
			)
			(2 ; Look
				(cond
					(recording
						(TPrint 890 35) ; "The recorder is capturing every nuance of "2 Live 2 Screw's" conversation."
					)
					((== ((Inv at: 12) owner:) 3) ; Money
						(cond
							(rewoundTape
								(TPrint 890 36) ; "The recorder contains a tape full of incriminating evidence."
							)
							(recorded
								(TPrint 890 37) ; "This tape is half on the take-up reel. It needs to be rewound before you can remove it from the recorder."
							)
							(else
								(TPrint 890 38) ; "There is a blank tape on the recorder."
							)
						)
					)
					(else
						(TPrint 890 39) ; "A large Studer console recorder is all warmed up and ready to record--except there's no tape upon which to record!"
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(12 ; Money
						(if recorded
							(TPrint 890 40) ; "Your tape is already recorded."
						else
							(gEgo setScript: mountTapeScript)
						)
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

(instance tape of Prop
	(properties
		x 42
		y 130
		description {the tape}
		approachX 42
		approachY 163
		lookStr {A large Studer console recorder is all warmed up and ready to record--except there's no tape upon which to record!}
		view 890
		loop 1
	)

	(method (doVerb theVerb invItem)
		(recorder doVerb: theVerb invItem)
	)
)

(instance tapeHole of View
	(properties
		x 158
		y 85
		view 890
		loop 7
	)

	(method (doVerb theVerb invItem)
		(tapeShelf doVerb: theVerb invItem)
	)
)

(instance hammer_a of Actor
	(properties
		name {hammer}
		x 38
		y 120
		description {P. C. Hammer}
		view 883
		loop 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 890 41) ; "P. C. Hammer is working in the next Control Room."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance glass of Prop
	(properties
		x 41
		y 116
		description {the glass window}
		view 890
		loop 2
		cel 1
		priority 9
		signal 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 890 42) ; "A heavy, soundproof, plate-glass window separates you from the outside--and your freedom!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance lights of Prop
	(properties
		x 53
		y 122
		description {the microphone mixer}
		approachX 90
		approachY 144
		view 890
		loop 3
		priority 9
		signal 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(mixer doVerb: theVerb invItem &rest)
			)
			(2 ; Look
				(mixer doVerb: theVerb invItem &rest)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance recSignA of Prop
	(properties
		x 17
		y 51
		description {the recording sign}
		view 890
		loop 6
		cel 1
		cycleSpeed 12
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 890 43) ; "This sign is illuminated whenever anyone is recording inside control room A."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance useMikeSound of Sound
	(properties
		flags 1
		number 891
	)
)

(instance breakGlassSound of Sound
	(properties
		number 146
		priority 11
	)
)

(instance useMikeScript of Script
	(properties)

	(method (changeState newState &tmp i invItem)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 89 141 self)
			)
			(1
				(gEgo
					view: 891
					setLoop: 2
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(2
				(useMikeSound play:)
				(gEgo setLoop: 3 setCel: 0 setCycle: End self)
			)
			(3
				(TPrint 890 44) ; "Taking your biggest possible diaphragmatic breath, you lean back and belt out your most powerful high C, directly into the microphone, through the powerful amplifiers and out through the control room monitor speakers!"
				(glass startUpd: setCel: 2)
				(= ticks 123)
			)
			(4
				(breakGlassSound play:)
				(glass setCycle: End self)
			)
			(5
				(= seconds 3)
			)
			(6
				(TPrint 890 45) ; "Is it Patti..."
				(TPrint 890 46) ; "...or is it Memorex?"
				(= seconds 4)
			)
			(7
				(gEgo
					setLoop: 4
					setPri: 9
					setCel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(8
				(gEgo actions: 0 setLoop: 5 setCel: 0 setCycle: End self)
			)
			(9
				(Points 15 157)
				(= ticks 123)
			)
			(10
				(gEgo
					view: 891
					posn: 18 114
					actions: 0
					setCel: 0
					setLoop: 7
					setCycle: 0
				)
				(= ticks 123)
			)
			(11
				(gEgo setMotion: MoveTo 1 114 self)
			)
			(12
				(= seconds 3)
			)
			(13
				(gTheMusic fade: 0 15 12 1)
				(gTheIconBar disable:)
				(DrawPic 1 -32762)
				(= ticks 30)
			)
			(14
				(gTheIconBar enable:)
				(TPrint 890 47) ; "Punching in the access code you learned by watching P. C. Hammer, you are able to ride the showervator back to John Krapper's bathroom. Luckily, no one noticed your clothes lying on the floor there."
				(= seconds 3)
			)
			(15
				(TPrint 890 48) ; "Putting on your dress and gathering your possessions, you sneak back to the receptionist's lobby door and wait for her to take a break before making for the safety of your patiently waiting limo."
				(= seconds 3)
			)
			(16
				(for ((= i 0)) (< i (Inv size:)) ((++ i))
					(= invItem (Inv at: i))
					(if (invItem ownedBy: 1000)
						(invItem owner: 24)
					)
				)
				(gCurRoom newRoom: 200)
			)
		)
	)
)

(instance GetTape of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 891
					setLoop: 0
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(= ticks 30)
			)
			(2
				(tapeHole init: addToPic:)
				(gEgo setCel: 255 setCycle: Beg self)
			)
			(3
				(gEgo get: 12 normalize: 872 setHeading: 0) ; Money
				(= ticks 30)
			)
			(4
				(Points 4 158)
				(TPrint 890 49) ; "You grab a blank reel of tape from the shelf."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance turnRecorderOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 891
					setLoop: 2
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(tape setCycle: Rev startUpd:)
				(gEgo normalize: 872 loop: 4 cel: 1 setHeading: 270)
				(= ticks 30)
			)
			(2
				(Points 4 155)
				(TPrint 890 50) ; "You turn on the reel-to-reel tape recorder."
				(= recording 1)
				(= seconds 7)
			)
			(3
				(TPrint 890 51) ; "As you record "2 Live 2 Screw," you giggle with delight as they thoroughly incriminate themselves."
				(= seconds 3)
			)
			(4
				(hammer_a setLoop: 1 setCycle: End self)
			)
			(5
				(TPrint 890 52) ; "What's that? What's P. C. Hammer doing? He looks like he's seen your "Recording" sign! And he doesn't look too happy about it."
				(= seconds 3)
			)
			(6
				(hammer_a cel: 0 setCycle: 0 setMotion: MoveTo 10 120 self)
			)
			(7
				(TPrint 890 53) ; "Oh, oh! Where did Hammer go?"
				(glass startUpd:)
				(= cycles 5)
			)
			(8
				(self dispose:)
				(gCurRoom setScript: sCartoon)
			)
		)
	)
)

(instance turnRecorderOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 891
					setLoop: 2
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(tape setCycle: 0 stopUpd:)
				(= ticks 30)
			)
			(2
				(= recording 0)
				(= recorded 1)
				(gEgo
					normalize: 872
					loop: 4
					cel: 1
					setHeading: 270
					observeControl: 16384
				)
				(= ticks 30)
			)
			(3
				(TPrint 890 54) ; "You turn off the recorder."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance rewindTape of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 891
					setLoop: 2
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(= ticks 30)
			)
			(2
				(gEgo
					normalize: 872
					loop: 4
					cel: 1
					setHeading: 270
					observeControl: 16384
				)
				(tape setCycle: Fwd startUpd: cycleSpeed: 0)
				(= seconds 7)
			)
			(3
				(tape setCycle: 0 stopUpd:)
				(= ticks 30)
			)
			(4
				(TPrint 890 55) ; "The tape is now fully rewound."
				(= rewoundTape 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getRecordedTape of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 891
					setLoop: 1
					setCel: 3
					cycleSpeed: 12
					setCycle: CT 2 -1 self
				)
			)
			(1
				(tape setLoop: 1 setCel: 0 x: 42 y: 130 stopUpd:)
				(gEgo cycleSpeed: 12 setCycle: Beg self)
			)
			(2
				(gEgo get: 12) ; Money
				((Inv at: 12) state: 1) ; Money
				(gEgo
					normalize: 872
					loop: 4
					cel: 1
					setHeading: 270
					observeControl: 16384
				)
				(= ticks 30)
			)
			(3
				(Points 7 156)
				(TPrint 890 56) ; "You remove the reel-to-reel tape."
				(= ticks 30)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance useMixer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 891
					setLoop: 2
					cycleSpeed: 12
					setCel: 0
					setCycle: Osc 1 self
				)
			)
			(1
				(gEgo loop: 4 cel: 1 setHeading: 270 normalize: 872)
				(if jammed
					(gEgo observeControl: 16384)
				)
				(= ticks 30)
			)
			(2
				(if jammed
					(if volumeUp
						(TPrint 890 57) ; "Since you've cranked it up to the point of feedback, you can't go any louder! Besides, it's almost loud enough to break glass."
					else
						(TPrint 890 58) ; "You crank up the volume on your control room's monitor speakers to an ear-piercing level."
						(= volumeUp 1)
					)
				else
					(switch mixerDoCounter
						(1)
						(2
							(TPrint 890 59) ; "You bring up the volume control labeled "Control Room C.""
							(Wait 60)
							(TPrint 890 60) ; "You hear nothing but hiss."
						)
						(3
							(TPrint 890 61) ; "You bring up the potentiometer labeled "Studio C.""
							(Wait 60)
							(TPrint 890 62) ; "You hear nothing but hiss and a little air conditioner bleed-through."
						)
						(4
							(TPrint 890 63) ; "You pull up the slider labeled "Control Room B" and hear what sounds like a female breathing."
							(Wait 60)
							(TPrint 890 64 67 -1 185) ; "(Oh, wait! That's you! You're in Control Room B!)"
						)
						(5
							(TPrint 890 65) ; "You raise the volume on "Studio B,""
							(Wait 60)
							(TPrint 890 66) ; "You hear nothing."
						)
						(6
							(TPrint 890 67) ; "You carefully open the slider on "Control Room A," as if P. C. Hammer could hear you doing so."
							(Wait 60)
							(TPrint 890 68) ; "He's recording his "live drive-time" show for tomorrow morning. Who cares?"
						)
						(else
							(if (not (IsFlag 154))
								(gEgo setScript: sHearingScrew)
							else
								(TPrint 890 69) ; "You are eavesdropping on the conversations from Studio A and to you it sounds just like "2 Live 2 Screw!""
							)
						)
					)
				)
				(= ticks 30)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sHearingScrew of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(TPrint 890 70) ; "You fade up the volume on "Studio A" and... listen to that!"
				(lights setCycle: Fwd startUpd:)
				(= seconds 3)
			)
			(1
				(TPrint 890 71) ; "Why, that's "2 Live 2 Screw!" Patti! You did it! Now you can overhear their conversation!"
				(= seconds 3)
			)
			(2
				(Points 8 154)
				(TPrint 890 72) ; "But how can you get some hard evidence to take back to Inspector Desmond to prove you really are hearing this!?"
				(= usedMixer 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance mountTapeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Patti put: 12 3)
				(gEgo
					view: 891
					setLoop: 1
					cycleSpeed: 12
					setCel: 0
					setCycle: CT 2 1 self
				)
			)
			(1
				(tape setLoop: 0 x: 35 y: 142)
				(gEgo setCycle: End self)
			)
			(2
				(gEgo normalize: 872 loop: 4 cel: 1 setHeading: 270)
				(= ticks 30)
			)
			(3
				(TPrint 890 73) ; "You place your tape on the recorder, carefully threading it around the tension arms, over the heads and past the capstan, finishing by threading the leader onto the takeup reel with a professional flourish."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance doorA of Door
	(properties
		x 47
		y 77
		description {the Control Room A door}
		sightAngle 40
		approachX 64
		approachY 80
		view 880
		loop 1
		signal 16384
		locked 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 890 74) ; "Be careful, Patti! Inside that door stands the man you've come here to investigate: P. C. Hammer!"
			)
			(3 ; Do
				(TPrint 890 75) ; "You don't want to try that door, Patti! The direct approach won't work with P. C. Hammer."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance doorB of Door
	(properties
		x 199
		y 111
		description {the Control Room B door}
		sightAngle 40
		approachX 218
		approachY 116
		view 880
		loop 2
		entranceTo 890
		locked 1
		moveToX 220
		moveToY 116
		enterType 0
		exitType 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 890 76) ; "A sign on the door reads "Control Room B." It is currently unoccupied."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance hammer_b of Actor ; UNUSED
	(properties
		name {hammer}
		x 82
		y 79
		description {P. C. Hammer}
		view 883
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 890 77) ; "Through the control room window, you see P. C. Hammer mixing his "live" radio broadcast for tomorrow morning's drive time show."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance mikestand of Actor
	(properties
		x 175
		y 121
		description {the microphone stand}
		view 880
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 890 78) ; "A large boom microphone stand sits just outside the door to Control Room B."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance recSign of Prop
	(properties
		x 177
		y 42
		description {the recording sign}
		view 880
		loop 3
		cel 1
		cycleSpeed 12
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 890 79) ; "This sign is illuminated whenever anyone is recording inside this control room."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance ActionsKRAP of Actions
	(properties)

	(method (doit)
		(return 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(TPrint 890 80) ; "You attempt to hike up those Hammerpants you're wearing, but it does no good!"
				(return 1)
			)
			(10 ; Zipper
				(TPrint 890 81) ; "Maintaining your cool, you surreptitiously check the zipper on your giant baggy pants. It's fine."
				(return 1)
			)
			(else
				(return 0)
			)
		)
	)
)

