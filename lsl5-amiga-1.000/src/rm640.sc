;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 640)
(include sci.sh)
(use Main)
(use eRS)
(use Door)
(use Talker)
(use Osc)
(use Polygon)
(use Feature)
(use LoadMany)
(use Rev)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm640 0
)

(local
	seenMsg
	askedInToStudio
	moveNeedle
	music2Playing
	getRecordFirstTime = 1
	turntableCycler
	turntableSpeed = 18
	speakerCycler
)

(procedure (TalkFromBooth)
	(= askedInToStudio 1)
	(TPrint 640 48) ; "A speaker crackles in the background..."
	(Say Reverse_Biaz 640 49 108) ; "Hello, out there! You must be Passionate Patti! Everything's all ready for your cut-in session. Just come on into the studio, I'm waiting for you."
)

(instance rm640 of LLRoom
	(properties
		picture 640
		north 660
	)

	(method (init)
		(gEgo init: normalize: 570)
		(HandsOn)
		(switch gPrevRoomNum
			(north
				(gEgo posn: 189 86 setHeading: 180 edgeHit: EDGE_NONE)
				(= askedInToStudio 1)
				(if (and (not (IsFlag 22)) (not (gEgo has: 5))) ; fRecordOnTurntable, Michelle_Milken_s_Resume
					(record init: approachVerbs: 2 3) ; Look, Do
				)
				(if (IsFlag 22) ; fRecordOnTurntable
					(record2 init: approachVerbs: 2 3) ; Look, Do
				)
				(gTheMusic number: 620 setVol: 127 flags: 1 play:)
			)
			(else
				(gEgo
					posn: 59 139
					setHeading: 90
					edgeHit: EDGE_NONE
					setPri: 9
					setScript: sExitElevator
				)
				(record init: approachVerbs: 2 3) ; Look, Do
			)
		)
		(LoadMany rsPIC 650)
		(LoadMany rsVIEW 650 641 1672)
		(LoadMany rsSOUND 640 641 642 643 644 645 646 201 648 621 622)
		(super init:)
		(stereo init: approachVerbs: 2 3 4) ; Look, Do, Inventory
		(elevator init: approachVerbs: 3) ; Do
		(door init: approachVerbs: 3) ; Do
		(reverseBiaz init: setScript: sMonitorRecording)
		(statue init:)
		(speakerA init:)
		(speakerB init:)
		(plant init:)
		(shelves init:)
		(recordJacketsA init:)
		(recordJacketsB init:)
		(fGoldRecords init:)
		(plaque init: approachVerbs: 2 3 4) ; Look, Do, Inventory
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 117 99 117 105 126 62 149 77 149 125 118 145 112 186 102 229 111 232 128 206 141 154 141 130 139 85 162 51 159 62 164 54 175 28 175 16 170 0 175
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 67 165 105 171 116 160 212 160 224 134 255 129 252 115 193 100 0 100 0 93 220 93 287 107 286 139 236 148 241 175 231 181 198 185 142 185 111 183 90 184 66 183 61 174
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 103 83 208 83 201 78 201 52 178 52 178 79 0 79 0 0 319 0 319 189 245 189 245 166 290 160 301 171 317 161 289 130 315 130 315 108 279 78 227 78 228 83 256 83 262 86 253 92 226 92 215 90 100 90
					yourself:
				)
		)
	)

	(method (doit)
		(if (and (StepOn gEgo 2) (not askedInToStudio))
			(TalkFromBooth)
		)
		(if (and (StepOn gEgo 4) (not askedInToStudio))
			(TalkFromBooth)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb invItem)
		(return
			(switch theVerb
				(1 ; Walk
					(if (== curPic 650)
						(gCurRoom setScript: sReturnsFromStereo)
						1
					)
				)
				(2 ; Look
					(if (== curPic 650)
						(super doVerb: theVerb invItem &rest)
					else
						(TPrint 640 0) ; "The waiting room is filled with an impressive array of recording memorabilia."
					)
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(cond
			((not (== newRoomNumber 620))
				(gTheMusic fade: 0 15 12 1)
				(gTheMusic2 fade: 0 15 12 1)
			)
			(music2Playing
				(gTheMusic setVol: 127 play:)
				(gTheMusic2 fade: 0 15 12 1)
			)
		)
	)
)

(instance sExitElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 2)
			)
			(1
				(elevatorDing play:)
				(= cycles 15)
			)
			(2
				(elevatorDoor play:)
				(elevator setCycle: End self)
			)
			(3
				(elevatorDoor stop:)
				(elevator setPri: 9)
				(gEgo setPri: 9 setMotion: MoveTo 73 148)
				(= seconds 2)
			)
			(4
				(elevatorDoor play:)
				(elevator setCycle: Beg self)
			)
			(5
				(elevatorDoor stop:)
				(gEgo setPri: -1)
				(elevator stopUpd: 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sGetRecord of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canInput: 0)
				(gEgo setHeading: 0 self)
			)
			(1
				(gEgo
					view: 641
					setLoop: 0
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(2
				(record dispose:)
				(gEgo get: 5 setCycle: Beg self) ; Michelle_Milken_s_Resume
			)
			(3
				(if getRecordFirstTime
					(Points 12 121)
					(= getRecordFirstTime 0)
					(TPrint 640 1) ; "Wriggling the gold record on its plaque, you discover it is loose enough to be removed. So you do."
					(TPrint 640 2) ; "You've wanted to have a gold record ever since you began playing professionally at age thirteen."
					(TPrint 640 3 67 -1 185) ; "(But you never dreamed you would get it like this!)"
				)
				(gEgo normalize: 570 loop: 3)
				(User canInput: 1)
				(self dispose:)
			)
		)
	)
)

(instance sMonitorRecording of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(if (Random 0 1)
					(reverseBiaz setLoop: 0 setCel: 0 setCycle: End self)
				else
					(reverseBiaz setLoop: 1 setCel: 0 setCycle: End self)
				)
			)
			(2
				(reverseBiaz setCycle: Beg self)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance sSpeed78Reverse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (needle cel:)
					(= seconds 10)
				else
					(self dispose:)
				)
			)
			(1
				(HandsOff)
				(if (not (DoSound sndGET_AUDIO_CAPABILITY))
					(TPrint 640 4 67 -1 28 108 self) ; "Amidst the hiss and crackle of this old LP, you can just barely make out a husky female voice saying, "Porn is best at a quarter a whack!""
				else
					(gTheMusic2 setVol: 80)
					(message1 play: self)
				)
			)
			(2
				(= ticks 30)
			)
			(3
				(gTheMusic2 setVol: 127)
				(Points 3 125)
				(TPrint 640 5 67 -1 28 108 self) ; "Of all the nerve! des Rever Records imprints subliminal messages encouraging young Americans to frequent adult bookstores!"
			)
			(4
				(= ticks 30)
			)
			(5
				(TPrint 640 6 67 -1 185 108 self) ; "At last! You've found some good solid evidence for Inspector Desmond."
			)
			(6
				(HandsOn)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance sSpeed33Reverse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (needle cel:)
					(= seconds 10)
				else
					(self dispose:)
				)
			)
			(1
				(HandsOff)
				(if (not (DoSound sndGET_AUDIO_CAPABILITY))
					(TPrint 640 7 67 -1 28 108 self) ; "Although the music sounds quite garbled backwards, you feel certain you can understand the words, "Just Say Yes!""
				else
					(gTheMusic2 setVol: 80)
					(message2 play: self)
				)
			)
			(2
				(= ticks 30)
			)
			(3
				(gTheMusic2 setVol: 127)
				(Points 3 123)
				(TPrint 640 8 67 -1 28 108 self) ; ""Just Say Yes!" Why, that's just the opposite of what Nancy Reagan said! You now have the incontrovertible evidence Desmond sent you to find! And you finally understand what evil this place does!"
			)
			(4
				(= ticks 30)
			)
			(5
				(TPrint 640 9 67 -1 28 108 self) ; "How vile! How corrupt! des Rever Records records backwards music urging innocent teenagers to violate the law! You never really believed this before--but you believe it now!"
			)
			(6
				(= ticks 30)
			)
			(7
				(TPrint 640 10 67 -1 28 108 self) ; "If you could only obtain more evidence to prove your case."
			)
			(8
				(HandsOn)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance sSpeed78Forward of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (needle cel:)
					(= seconds 10)
				else
					(self dispose:)
				)
			)
			(1
				(HandsOff)
				(if (not (DoSound sndGET_AUDIO_CAPABILITY))
					(TPrint 640 11 67 -1 28 108 self) ; "Although it seems improbable, you feel sure you can understand a message among the sped-up music: "Digital Audio Tape causes impotence." How odd."
				else
					(gTheMusic2 setVol: 80)
					(message3 play: self)
				)
			)
			(2
				(= ticks 30)
			)
			(3
				(gTheMusic2 setVol: 127)
				(Points 3 124)
				(TPrint 640 12 67 -1 185 108 self) ; "(Hmm. This must be a "pre-Sony" Columbia recording!)"
			)
			(4
				(HandsOn)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance sSpeed33Forward of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (needle cel:)
					(= seconds 10)
				else
					(self dispose:)
				)
			)
			(1
				(HandsOff)
				(Points 3 122)
				(TPrint 640 13 67 -1 28 108 self) ; "Well, that's interesting. You've always wondered if there was really a record underneath all that "gold.""
			)
			(2
				(HandsOn)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance sUsesStereo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(User canInput: 1)
				(gCast eachElementDo: #hide)
				(statue dispose:)
				(speakerA dispose:)
				(speakerB dispose:)
				(plant dispose:)
				(shelves dispose:)
				(recordJacketsA dispose:)
				(recordJacketsB dispose:)
				(fGoldRecords dispose:)
				(plaque dispose:)
				(reverseButton init: stopUpd:)
				(stopButton init: stopUpd:)
				(forwardButton init: stopUpd:)
				(button33 init: stopUpd:)
				(button78 init: stopUpd:)
				(needle init:)
				(if (IsFlag 22) ; fRecordOnTurntable
					(turnTableWRecord
						init:
						setCycle:
							(cond
								((== turntableCycler 0) 0)
								((== turntableCycler 1) Fwd)
								((== turntableCycler 2) Rev)
							)
						cycleSpeed: turntableSpeed
					)
					(record2 dispose:)
				else
					(turntable init:)
				)
				(speakerOne init: setCycle: (if speakerCycler MyRandCycle else 0))
				(speakerTwo init: setCycle: (if speakerCycler MyRandCycle else 0))
				(gCurRoom drawPic: 650)
				(SetupExit 1)
				(gTheIconBar curIcon: (gTheIconBar at: 2))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(stereo dispose:)
				(gTheMusic fade: 0 15 12 0 self)
			)
			(1
				(gTheMusic pause: 1)
				(self dispose:)
			)
		)
	)
)

(instance sReturnsFromStereo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(if (gCurRoom script:)
					((gCurRoom script:) dispose:)
				)
				(if (not (needle cel:))
					(gTheMusic setVol: 127 pause: 0)
				)
				(stopButton dispose:)
				(forwardButton dispose:)
				(reverseButton dispose:)
				(button33 dispose:)
				(button78 dispose:)
				(needle dispose:)
				(if (IsFlag 22) ; fRecordOnTurntable
					(if (turnTableWRecord cycler:)
						(cond
							(((turnTableWRecord cycler:) isKindOf: Fwd)
								(= turntableCycler 1)
							)
							(((turnTableWRecord cycler:) isKindOf: Rev)
								(= turntableCycler 2)
							)
						)
						(= music2Playing 1)
					else
						(= turntableCycler 0)
						(= music2Playing 0)
					)
					(record2 init:)
					(= turntableSpeed (turnTableWRecord cycleSpeed:))
					(turnTableWRecord dispose:)
				else
					(turntable dispose:)
				)
				(if (speakerOne cycler:)
					(= speakerCycler 1)
				else
					(= speakerCycler 0)
				)
				(speakerOne dispose:)
				(speakerTwo dispose:)
				(if (not (gEgo has: 5)) ; Michelle_Milken_s_Resume
					(record show:)
				)
				(stereo init: approachVerbs: 2 3 4) ; Look, Do, Inventory
				(gCurRoom drawPic: (gCurRoom picture:))
				(elevator show:)
				(gEgo show:)
				(door show:)
				(reverseBiaz show:)
				(statue init:)
				(speakerA init:)
				(speakerB init:)
				(plant init:)
				(shelves init:)
				(recordJacketsA init:)
				(recordJacketsB init:)
				(fGoldRecords init:)
				(plaque init: approachVerbs: 2 3 4) ; Look, Do, Inventory
				(SetupExit 0)
				(User canControl: 1)
				(self dispose:)
			)
		)
	)
)

(instance sStopButtonPressed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (needle cel:)
					(HandsOff)
				)
				(stopButton startUpd:)
				(= cycles 1)
			)
			(1
				(recordSwitch play:)
				(stopButton setPri: 10 setCycle: Osc 1 self)
			)
			(2
				(cond
					((not (turnTableWRecord cycler:))
						(TPrint 640 14 67 -1 185) ; "The record player is STILL stopped!"
					)
					((not (IsFlag 22)) ; fRecordOnTurntable
						(TPrint 640 15 67 -1 185) ; "You should see how well it stops when there's a record on it!"
					)
					((needle cel:)
						(needle doVerb: 3)
					)
				)
				(= cycles 1)
			)
			(3
				(User canControl: 0)
				(= seconds 3)
			)
			(4
				(turnTableWRecord setCycle: 0)
				(stopButton setPri: -1 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance sForwardButtonPressed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(forwardButton startUpd:)
				(= cycles 1)
			)
			(1
				(recordSwitch play:)
				(forwardButton setPri: 10 setCycle: Osc 1 self)
			)
			(2
				(cond
					((turnTableWRecord cycler:)
						(if (not ((turnTableWRecord cycler:) isKindOf: Fwd))
							(turnTableWRecord setCycle: Fwd)
							(if (needle cel:)
								(= moveNeedle 0)
								(speakerOne cue:)
							)
							(if (== (turnTableWRecord cycleSpeed:) 6)
								(gCurRoom setScript: sSpeed78Forward)
							else
								(gCurRoom setScript: sSpeed33Forward)
							)
						)
					)
					((IsFlag 22) ; fRecordOnTurntable
						(turnTableWRecord setCycle: Fwd)
					)
					(else
						(TPrint 640 16) ; "This turntable is pressure-sensitive. It will not turn without a record present."
					)
				)
				(forwardButton setPri: -1 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance sReverseButtonPressed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(reverseButton startUpd:)
				(= cycles 1)
			)
			(1
				(recordSwitch play:)
				(reverseButton setPri: 10 setCycle: Osc 1 self)
			)
			(2
				(cond
					((turnTableWRecord cycler:)
						(if (not ((turnTableWRecord cycler:) isKindOf: Rev))
							(turnTableWRecord setCycle: Rev)
							(if (needle cel:)
								(= moveNeedle 0)
								(speakerOne cue:)
							)
							(cond
								((== (turnTableWRecord cycleSpeed:) 18)
									(gCurRoom setScript: sSpeed33Reverse)
								)
								((== (turnTableWRecord cycleSpeed:) 6)
									(gCurRoom setScript: sSpeed78Reverse)
								)
							)
						)
					)
					((IsFlag 22) ; fRecordOnTurntable
						(turnTableWRecord setCycle: Rev)
					)
					(else
						(TPrint 640 16) ; "This turntable is pressure-sensitive. It will not turn without a record present."
					)
				)
				(reverseButton setPri: -1 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance sButton33Pressed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(button33 startUpd:)
				(= cycles 1)
			)
			(1
				(recordSwitch play:)
				(button33 setPri: 10 setCycle: Osc 1 self)
			)
			(2
				(if (turnTableWRecord cycler:)
					(if (== (turnTableWRecord cycleSpeed:) 6)
						(turnTableWRecord cycleSpeed: 18)
						(if (needle cel:)
							(= moveNeedle 0)
							(speakerOne cue:)
						)
						(cond
							(((turnTableWRecord cycler:) isKindOf: Rev)
								(gCurRoom setScript: sSpeed33Reverse)
							)
							(((turnTableWRecord cycler:) isKindOf: Fwd)
								(gCurRoom setScript: sSpeed33Forward)
							)
						)
					)
				else
					(turnTableWRecord cycleSpeed: 18)
					(TPrint 640 17) ; "The turntable is now prepared to revolve thirty-three and one-third times per minute."
					(TPrint 640 18 67 -1 185) ; "(But only when it's ON!)"
				)
				(button33 setPri: -1 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance sButton78Pressed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(button78 startUpd:)
				(= cycles 1)
			)
			(1
				(recordSwitch play:)
				(button78 setPri: 10 setCycle: Osc 1 self)
			)
			(2
				(if (turnTableWRecord cycler:)
					(if (== (turnTableWRecord cycleSpeed:) 18)
						(turnTableWRecord cycleSpeed: 6)
						(if (needle cel:)
							(= moveNeedle 0)
							(speakerOne cue:)
						)
						(if ((turnTableWRecord cycler:) isKindOf: Rev)
							(gCurRoom setScript: sSpeed78Reverse)
						else
							(gCurRoom setScript: sSpeed78Forward)
						)
					)
				else
					(turnTableWRecord cycleSpeed: 6)
					(TPrint 640 19) ; "The turntable is now prepared to revolve seventy-eight times per minute."
					(TPrint 640 18 67 -1 185) ; "(But only when it's ON!)"
				)
				(button78 setPri: -1 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(elevatorDing play:)
				(= cycles 15)
			)
			(1
				(elevatorDoor play:)
				(elevator setCycle: End self)
			)
			(2
				(elevatorDoor stop:)
				(elevator setPri: 10)
				(gEgo setPri: 9 setMotion: MoveTo 59 139 self)
			)
			(3
				(gEgo setHeading: 90 self)
			)
			(4
				(Say Reverse_Biaz 640 20 108 139 self) ; "Patti, I promise you: you'll never work in this town again!"
			)
			(5
				(elevatorDoor play:)
				(elevator setCycle: Beg self)
			)
			(6
				(elevatorDoor stop:)
				(gCurRoom newRoom: 620)
				(self dispose:)
			)
		)
	)
)

(instance sPlayMusic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if moveNeedle
					(needleDownSpin play: self)
				else
					(= cycles 1)
				)
			)
			(1
				(HandsOn)
				(User canControl: 0)
				(cond
					(((turnTableWRecord cycler:) isKindOf: Fwd)
						(if (== (turnTableWRecord cycleSpeed:) 6)
							(gTheMusic2 number: 641 flags: 1 setLoop: -1 play:)
							(gCurRoom setScript: sSpeed78Forward)
						else
							(gTheMusic2 number: 640 flags: 1 setLoop: -1 play:)
							(gCurRoom setScript: sSpeed33Forward)
						)
					)
					(((turnTableWRecord cycler:) isKindOf: Rev)
						(cond
							((== (turnTableWRecord cycleSpeed:) 18)
								(gTheMusic2
									number: 642
									flags: 1
									setLoop: -1
									play:
								)
								(gCurRoom setScript: sSpeed33Reverse)
							)
							((== (turnTableWRecord cycleSpeed:) 6)
								(gTheMusic2
									number: 643
									flags: 1
									setLoop: -1
									play:
								)
								(gCurRoom setScript: sSpeed78Reverse)
							)
						)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance stereo of Feature
	(properties
		x 174
		y 163
		z 3
		nsTop 154
		nsLeft 151
		nsBottom 167
		nsRight 197
		description {the stereo}
		sightAngle 40
		approachX 172
		approachY 185
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(gCurRoom setScript: sUsesStereo)
			)
			(3 ; Do
				(gCurRoom setScript: sUsesStereo)
			)
			(4 ; Inventory
				(if (== invItem 5) ; Michelle_Milken_s_Resume
					(SetFlag 22) ; fRecordOnTurntable
					(gEgo put: 5) ; Michelle_Milken_s_Resume
					(gCurRoom setScript: sUsesStereo)
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

(instance plaque of Feature
	(properties
		x 167
		y 161
		z 29
		nsTop 119
		nsLeft 153
		nsBottom 145
		nsRight 181
		description {the plaque}
		sightAngle 40
		approachX 159
		approachY 183
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (gCast contains: record)
					(TPrint 640 21) ; "One of des Rever Records' gold records is mounted on a simulated solid walnut plaque."
				else
					(TPrint 640 22) ; "This plaque once contained a gold record."
				)
			)
			(4 ; Inventory
				(switch invItem
					(5 ; Michelle_Milken_s_Resume
						(record init:)
						(gEgo put: 5) ; Michelle_Milken_s_Resume
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

(instance record of View
	(properties
		x 169
		y 162
		z 33
		description {the gold record}
		sightAngle 40
		approachX 159
		approachY 183
		view 640
		loop 2
		priority 14
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(gEgo setScript: sGetRecord)
			)
			(2 ; Look
				(TPrint 640 23) ; "It says, "This gold record is awarded to Reverse Biaz, Chief Engineer, `des Rever Records.'""
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance record2 of View
	(properties
		x 154
		y 164
		z 16
		description {the stereo}
		sightAngle 40
		approachX 159
		approachY 183
		view 640
		loop 3
		priority 14
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(gCurRoom setScript: sUsesStereo)
			)
			(3 ; Do
				(gCurRoom setScript: sUsesStereo)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance elevator of Prop
	(properties
		x 50
		y 77
		description {the elevator}
		approachX 65
		approachY 152
		lookStr {This is the elevator in which you arrived.}
		view 640
		priority 10
		signal 16401
		cycleSpeed 12
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(cond
					((IsFlag 21) ; fWarned
						(gCurRoom setScript: sEnterElevator)
					)
					(askedInToStudio
						(SetFlag 21) ; fWarned
						(Say Reverse_Biaz 640 24 108) ; "Where are you going, Patti? There are a lot of people in this town who would love a chance to blow synth on a session here. I was happy to give you the gig. But, if you leave me now, I promise you I'll be on the phone to the Union before you're downstairs!"
					)
					(else
						(TalkFromBooth)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance reverseBiaz of Prop
	(properties
		x 251
		y 56
		description {Reverse Biaz}
		view 642
		cycleSpeed 12
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 640 25) ; "This is your man: Reverse Biaz, chief engineer of `des Rever Records' and the man you've been sent to investigate."
				(if (not askedInToStudio)
					(TalkFromBooth)
				)
			)
			(5 ; Talk
				(TPrint 640 26) ; "The double-paned, soundproof glass prevents him from hearing you."
				(if (not askedInToStudio)
					(TalkFromBooth)
				)
			)
			(3 ; Do
				(TPrint 640 27) ; "It's difficult to do anything through this glass."
			)
			(4 ; Inventory
				(switch invItem
					(4 ; A_Blank_Videotape_c
						(TPrint 640 28) ; "You don't pour THROUGH glass, you pour INTO glass!"
					)
					(else
						(TPrint 640 29) ; "He's probably not going to break that double-paned, soundproof glass to accept it, Patti!"
					)
				)
			)
			(10 ; Zipper
				(TPrint 640 30) ; "Gee, Patti, he IS cute--but aren't you here for business?"
			)
			(else
				(TPrint 640 31) ; "There's nothing you can do with Reverse Biaz from out here."
			)
		)
	)
)

(instance turntable of Feature
	(properties
		x 174
		y 160
		nsTop 109
		nsLeft 112
		nsBottom 132
		nsRight 191
		description {the turntable}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 640 32) ; "What an unusual turntable; it still has a 78 RPM setting."
			)
			(3 ; Do
				(TPrint 640 33) ; "The turntable doesn't require a push start."
			)
			(4 ; Inventory
				(switch invItem
					(5 ; Michelle_Milken_s_Resume
						(SetFlag 22) ; fRecordOnTurntable
						(gEgo put: 5) ; Michelle_Milken_s_Resume
						(turnTableWRecord init:)
						(gTheIconBar curIcon: (gTheIconBar at: 2))
						(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
						(self dispose:)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(1 ; Walk
				(gCurRoom setScript: sReturnsFromStereo)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance turnTableWRecord of Prop
	(properties
		x 150
		y 133
		description {the gold record}
		view 650
		loop 10
		cycleSpeed 18
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (self cycler:)
					(TPrint 640 34) ; "Round and round and round it goes."
				else
					(TPrint 640 35) ; "Why don't you take it for a spin?"
				)
			)
			(3 ; Do
				(if (self cycler:)
					(TPrint 640 36) ; "Don't remove the gold record while it's spinning!"
				else
					(ClearFlag 22) ; fRecordOnTurntable
					(gEgo get: 5) ; Michelle_Milken_s_Resume
					(turntable init:)
					(self dispose:)
				)
			)
			(1 ; Walk
				(gCurRoom setScript: sReturnsFromStereo)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance needle of Prop
	(properties
		x 191
		y 111
		description {the tone arm}
		view 650
		loop 6
		priority 11
		signal 17
		cycleSpeed 12
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (self cel:)
					(TPrint 640 37) ; "That stylus is really "getting in the groove.""
				else
					(TPrint 640 38) ; "The tone arm rests gently in its holder, awaiting your next action."
				)
			)
			(3 ; Do
				(cond
					((self cel:)
						(-= y 1000)
						(= z 0)
						(HandsOff)
						(self setCycle: Beg speakerOne)
						(cond
							((== (gCurRoom script:) sStopButtonPressed)
								((gCurRoom script:) cue:)
							)
							((gCurRoom script:)
								((gCurRoom script:) dispose:)
							)
						)
					)
					((IsFlag 22) ; fRecordOnTurntable
						(if
							(and
								(turnTableWRecord cycler:)
								(not (gCurRoom script:))
							)
							(+= y 1000)
							(= z 1000)
							(= moveNeedle 1)
							(HandsOff)
							(self setCycle: End speakerOne)
						else
							(TPrint 640 39) ; "Bring the turntable up to speed before applying the tonearm and cartridge."
						)
					)
					(else
						(TPrint 640 40) ; "Don't do that! You'll wreck the stylus."
					)
				)
			)
			(1 ; Walk
				(gCurRoom setScript: sReturnsFromStereo)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance speakerOne of Prop
	(properties
		x 243
		y 114
		description {the speakers}
		view 650
		loop 8
		cycleSpeed 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 640 41) ; "A small plaque on the rear of the speaker reads, "Digital Ready.""
			)
			(1 ; Walk
				(gCurRoom setScript: sReturnsFromStereo)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (cue)
		(needle stopUpd:)
		(if (needle cel:)
			(self setCycle: MyRandCycle)
			(speakerTwo setCycle: MyRandCycle)
			(self setScript: sPlayMusic)
		else
			(HandsOn)
			(User canControl: 0)
			(gTheMusic2 stop:)
			(self setCycle: 0)
			(speakerTwo setCycle: 0)
		)
	)
)

(instance speakerTwo of Prop
	(properties
		x 75
		y 117
		description {the speakers}
		view 650
		loop 9
		cycleSpeed 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 640 41) ; "A small plaque on the rear of the speaker reads, "Digital Ready.""
			)
			(1 ; Walk
				(gCurRoom setScript: sReturnsFromStereo)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(class MyRandCycle of Cycle
	(properties)

	(method (doit)
		(++ cycleCnt)
		(if (> cycleCnt (client cycleSpeed:))
			(client setCel: (Random 0 1))
			(= cycleCnt 0)
		)
	)
)

(instance door of Door
	(properties
		x 177
		y 21
		description {the studio door}
		approachX 195
		approachY 83
		lookStr {A small plaque on the door reads, "Studio A."}
		view 640
		loop 1
		signal 1
		entranceTo 660
		moveToX 195
		moveToY 73
		enterType 0
		exitType 0
	)
)

(instance reverseButton of Prop
	(properties
		x 105
		y 159
		description {the Reverse button}
		sightAngle 40
		view 650
		signal 1
		cycleSpeed 12
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: sReverseButtonPressed)
			)
			(2 ; Look
				(TPrint 640 42) ; "This button is marked "Reverse.""
			)
			(1 ; Walk
				(gCurRoom setScript: sReturnsFromStereo)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance stopButton of Prop
	(properties
		x 120
		y 160
		description {the Stop button}
		sightAngle 40
		view 650
		loop 1
		signal 1
		cycleSpeed 12
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: sStopButtonPressed)
			)
			(2 ; Look
				(TPrint 640 43) ; "This button is marked "Stop.""
			)
			(1 ; Walk
				(gCurRoom setScript: sReturnsFromStereo)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance forwardButton of Prop
	(properties
		x 134
		y 161
		description {the Forward button}
		sightAngle 40
		view 650
		loop 2
		signal 1
		cycleSpeed 12
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: sForwardButtonPressed)
			)
			(2 ; Look
				(TPrint 640 44) ; "This button is marked "Forward.""
			)
			(1 ; Walk
				(gCurRoom setScript: sReturnsFromStereo)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance button33 of Prop
	(properties
		x 188
		y 161
		description {the 33 button}
		sightAngle 40
		view 650
		loop 3
		signal 1
		cycleSpeed 12
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: sButton33Pressed)
			)
			(2 ; Look
				(TPrint 640 45) ; "This button is marked "33.""
			)
			(1 ; Walk
				(gCurRoom setScript: sReturnsFromStereo)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance button78 of Prop
	(properties
		x 217
		y 159
		description {the 78 button}
		sightAngle 40
		view 650
		loop 5
		signal 1
		cycleSpeed 12
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: sButton78Pressed)
			)
			(2 ; Look
				(TPrint 640 46) ; "This button is marked "78.""
			)
			(1 ; Walk
				(gCurRoom setScript: sReturnsFromStereo)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance statue of Feature
	(properties
		x 31
		y 141
		nsTop 114
		nsLeft 24
		nsBottom 169
		nsRight 43
		description {the statue}
		sightAngle 40
		lookStr {This sculpture represents the patron saint of recording companies--\nSt. Needle.}
	)
)

(instance speakerA of Feature
	(properties
		x 121
		y 200
		z 50
		nsTop 137
		nsLeft 112
		nsBottom 164
		nsRight 131
		description {the left speaker}
		sightAngle 40
		lookStr {This transducer converts electrical energy into rapidly pulsating sound waves.}
	)
)

(instance speakerB of Feature
	(properties
		x 215
		y 199
		z 50
		nsTop 137
		nsLeft 205
		nsBottom 161
		nsRight 225
		description {the right speaker}
		sightAngle 40
		lookStr {This transducer converts electrical energy into rapidly pulsating sound waves.}
	)
)

(instance plant of Feature
	(properties
		x 233
		y 71
		nsTop 45
		nsLeft 220
		nsBottom 93
		nsRight 246
		description {the plant}
		sightAngle 40
		lookStr {Upon close examination, you determine this is a plant.}
	)
)

(instance shelves of Feature
	(properties
		x 268
		y 110
		nsTop 83
		nsLeft 257
		nsBottom 137
		nsRight 279
		description {the shelves}
		sightAngle 40
		lookStr {The office's shelves are filled with records, tapes, and books.}
	)
)

(instance recordJacketsA of Feature
	(properties
		x 133
		y 15
		nsTop 10
		nsLeft 104
		nsBottom 20
		nsRight 162
		description {the record jackets}
		sightAngle 40
		lookStr {Many famous record album jackets adorn the walls of the office of des Rever Records.}
	)
)

(instance recordJacketsB of Feature
	(properties
		x 268
		y 15
		nsTop 11
		nsLeft 222
		nsBottom 20
		nsRight 315
		description {the record jackets}
		sightAngle 40
		lookStr {Many famous record album jackets adorn the walls of the office of des Rever Records.}
	)
)

(instance elevatorDing of Sound
	(properties
		number 621
	)
)

(instance elevatorDoor of Sound
	(properties
		number 622
	)
)

(instance message1 of Sound
	(properties
		number 644
	)
)

(instance message2 of Sound
	(properties
		number 645
	)
)

(instance message3 of Sound
	(properties
		number 646
	)
)

(instance recordSwitch of Sound
	(properties
		number 201
	)
)

(instance needleDownSpin of Sound
	(properties
		number 648
	)
)

(instance Reverse_Biaz of Talker
	(properties
		name {Reverse Biaz}
		nsTop 15
		nsLeft 35
		view 1672
		loop 3
		viewInPrint 1
	)

	(method (init)
		(= bust reverseBust)
		(= eyes reverseEyes)
		(= mouth reverseMouth)
		(super init: &rest)
	)
)

(instance reverseBust of Prop
	(properties
		view 1672
		loop 1
	)
)

(instance reverseEyes of Prop
	(properties
		nsTop 31
		nsLeft 22
		view 1672
		loop 2
		cycleSpeed 70
	)
)

(instance reverseMouth of Prop
	(properties
		nsTop 36
		nsLeft 15
		view 1672
		cycleSpeed 5
	)
)

(instance fGoldRecords of Feature
	(properties
		x 134
		y 77
		z 37
		nsTop 34
		nsLeft 108
		nsBottom 47
		nsRight 160
		description {the gold records}
		sightAngle 40
		lookStr {These gold records are firmly attached to the wall.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 640 47) ; "You are unable to remove this gold record from its plaque."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

