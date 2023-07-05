;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 480)
(include sci.sh)
(use Main)
(use n013)
(use GKTeller)
(use Osc)
(use RandCycle)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	bayouRitual 0
)

(local
	local0 = 31
	local1
	local2
	local3
	local4 = 1
	local5
	local6
	local7
)

(instance bayouRitual of Room
	(properties
		picture 480
		style 14
		exitStyle 13
	)

	(method (init)
		(gGkMusic1
			setLoop: -1
			number: 480
			play:
			setVol: 0
			fade: (gGkMusic1 musicVolume:) 25 10 0
		)
		(Load rsPIC 480)
		(Load rsSCRIPT 64941)
		(ScriptID 51) ; GKTeller
		(ScriptID 920) ; Teller
		(gEgo
			normalize:
			init:
			setCycle: 0
			view: 4812
			loop: 0
			cel: (+ (not (IsFlag 216)) (if (IsFlag 299) 2 else 0))
			x: 68
			y: 127
		)
		(if (not (IsFlag 216))
			(gEgo view: 4813 cel: 0 ignoreActors:)
		)
		(UpdateScreenItem gEgo)
		(super init:)
		(User canControl: 1 canInput: 1)
		(drJohn init:)
		(cage init:)
		(drum2 init: setCycle: Fwd)
		(asson init: setCycle: Fwd)
		(bonfire init: setCycle: Fwd)
		(head init: setCycle: RandCycle)
		(torch1 init: setCycle: Fwd)
		(torch2 init: setCycle: Fwd)
		(torch3 init: setCycle: Fwd)
		(torch4 init: setCycle: Fwd)
		(torch5 init: setCycle: Fwd)
		(kneelingNude init:)
		(standingNude init:)
		(foregroundFemale init:)
		(rightMale init:)
		(leftMale init:)
		(drummer init: setCycle: Fwd)
		(goat init:)
		(PalCycle 0 192 207 1 6) ; Start
		(PalCycle 0 208 215 1 6) ; Start
		(self setScript: roomScript)
	)

	(method (doit)
		(super doit: &rest)
	)

	(method (dispose)
		(DoAudio 13 63) ; AudChannels
		(UnLoad 129 480)
		(UnLoad 140 482)
		(DisposeScript 64941)
		(gGkMusic1 fade:)
		(if local3
			(local3 dispose:)
			(= local3 0)
		)
		(if local2
			(gGame setCursor: local2)
		)
		(if (GK keepBar:)
			(gTheIconBar draw:)
		)
		(super dispose:)
	)
)

(instance roomScript of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event &rest)
		(if (and local5 (== (event type:) evKEYBOARD) (== (event message:) KEY_SPACE))
			(Palette 2 0 256 100) ; PalIntensity
			(if local2
				(gGame setCursor: local2)
			)
			(gKeyDownHandler delete: self)
			(if (SkipSceneDialog)
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(gCurRoom setScript: abortCartoon)
			else
				(if local2
					(gGame setCursor: ((ScriptID 0 1) view: 996 yourself:)) ; globeCursor
				)
				(gKeyDownHandler add: self)
				(if (not (gNarrator dialog:))
					(Platform 0 2 0)
				)
			)
			(return 1)
		)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 5)
			)
			(1
				(gMessager say: 5 0 3 1 self) ; "!!!blank msg"
			)
			(2
				(head dispose:)
				(drJohn loop: 2 cel: 0 setCycle: End self)
				(if (IsFlag 216)
					(= cycles 1)
				else
					(gMessager sayRange: 5 0 1 2 4 self) ; "(RRCC. ENRAGED)You! What are you doing here?"
				)
			)
			(3 1)
			(4
				(drJohn
					view: 4811
					setLoop: 0 1
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo 98 127 self
				)
			)
			(5
				(drJohn setCycle: 0 cel: 6)
				(if (IsFlag 216)
					(if (IsFlag 299)
						(+= state 4)
					)
					(= cycles 1)
				else
					(gEgo setScript: killGabe)
				)
			)
			(6
				(gMessager sayRange: 5 0 2 2 4 self) ; "Welcome, Brother Crocodile. Please join...."
			)
			(7
				(drJohn dispose:)
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(8
				(gMessager sayRange: 5 0 2 5 7 self) ; "You! I knew it!"
			)
			(9
				(gEgo setScript: killGabe)
			)
			(10
				(gMessager sayRange: 5 0 3 2 8 self) ; "Welcome, Brother Crocodile. Please join the other celebrants."
			)
			(11
				(questions init: doVerb: 11)
			)
			(12
				(questions dispose:)
				(if register
					(gMessager say: 5 0 register 0 self)
					(-= state 6)
				else
					(= cycles 1)
				)
			)
			(13
				(= local7 (GK keepBar:))
				(GK keepBar: 0)
				(gTheIconBar disable: erase:)
				(= local6 1)
				(DisposeScript 51)
				(DisposeScript 920)
				(drJohn view: 481 loop: 2 cel: 0)
				(= cycles 1)
			)
			(14
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(Load 140 482) ; WAVE
				)
				(DoAudio 13 local0) ; AudChannels
				(if (== (gGame detailLevel:) 3)
					(gGkSound1 setLoop: -1 number: 482 flags: 5 play:)
				)
				(gKeyDownHandler add: self)
				(= local5 1)
				(kneelingNude loop: 1 setCycle: Fwd)
				(standingNude loop: 1 setCycle: Osc)
				(foregroundFemale loop: 1 setCycle: RandCycle)
				(rightMale loop: 1 setCycle: Fwd)
				(leftMale loop: 1 setCycle: RandCycle)
				(malia
					init:
					setLoop: 0 1
					setCycle: Walk
					setMotion: MoveTo 228 122 self
				)
			)
			(15
				(malia cel: 0 loop: 1 posn: 186 125 setCycle: End self)
			)
			(16
				(malia cel: 0 loop: 2 setCycle: End self)
			)
			(17
				(malia cel: 0 loop: 0 view: 4831 posn: 128 124)
				(= seconds 1)
			)
			(18
				(malia loop: 1 setCycle: Fwd)
				(= seconds 8)
			)
			(19
				(Load rsVIEW 610)
				(Load rsPIC 610)
				(= cycles 1)
			)
			(20
				(= local3
					((List new:)
						add:
							gEgo
							drJohn
							bonfire
							torch1
							torch2
							torch3
							torch4
							torch5
						add:
							kneelingNude
							standingNude
							foregroundFemale
							rightMale
							leftMale
							drummer
							goat
							malia
							cage
							drum2
							asson
						yourself:
					)
				)
				(for ((= temp1 100)) (>= temp1 0) ((-= temp1 4))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(= local4 0)
				(PalCycle 4 192) ; Off
				(PalCycle 4 208) ; Off
				(= local2 (gGame setCursor:))
				(gGame setCursor: ((ScriptID 0 1) view: 996 yourself:)) ; globeCursor
				(local3 eachElementDo: #dispose release:)
				(gCurRoom drawPic: 610 0)
				(for ((= temp1 0)) (<= temp1 100) ((+= temp1 4))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(= seconds 1)
			)
			(21
				(local3 add: (closeChicken init: yourself:))
				(gMessager say: 5 0 16 1 self) ; "Damballah Oueddo, Ou couleuvre moins!"
			)
			(22
				(local3 add: (bowl init: yourself:))
				(= cycles 10)
			)
			(23
				(local3
					add:
						(bloodSpill
							init:
							setPri: 73
							cycleSpeed: 12
							setCycle: End self
							yourself:
						)
				)
				(gMessager say: 5 0 16 2 self) ; "!!!Blank msg"
			)
			(24 1)
			(25
				(local3 add: (deadChickens init: yourself:))
				(gMessager say: 5 0 16 3 self) ; "!!!Blank msg"
			)
			(26
				(for ((= temp1 100)) (>= temp1 0) ((-= temp1 4))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(local3 eachElementDo: #dispose release:)
				(UnLoad 128 610)
				(UnLoad 128 6101)
				(gCurRoom drawPic: 480 0)
				(drJohn view: 486 loop: 2 cel: 0 init: posn: 88 130)
				(bonfire init: setCycle: Fwd)
				(torch1 init: setCycle: Fwd)
				(torch2 init: setCycle: Fwd)
				(torch3 init: setCycle: Fwd)
				(torch4 init: setCycle: Fwd)
				(torch5 init: setCycle: Fwd)
				(drum2 init: setCycle: Fwd)
				(asson init: setCycle: Fwd)
				(kneelingNude init: setCycle: Fwd)
				(standingNude init: setCycle: Osc)
				(foregroundFemale init: setCycle: RandCycle)
				(rightMale init: setCycle: Fwd)
				(leftMale init: setCycle: RandCycle)
				(drummer init: setCycle: Fwd)
				(goat init:)
				(cage init:)
				(chicksInVeve init:)
				(malia view: 486 loop: 0 cel: 0 init: posn: 131 124)
				(gEgo view: 4812 loop: 0 cel: 2 init: posn: 56 127)
				(UpdateScreenItem gEgo)
				(PalCycle 0 192 207 1 6) ; Start
				(PalCycle 0 208 215 1 6) ; Start
				(local3
					add:
						gEgo
						drJohn
						bonfire
						torch1
						torch2
						torch3
						torch4
						torch5
					add:
						kneelingNude
						standingNude
						foregroundFemale
						rightMale
						leftMale
						drummer
						goat
						malia
						chicksInVeve
						cage
						drum2
						asson
					yourself:
				)
				(for ((= temp1 0)) (<= temp1 100) ((+= temp1 4))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(= cycles 1)
			)
			(27
				(drJohn view: 485 loop: 0 cel: 0 setCycle: End self)
			)
			(28
				(drJohn cel: 0 loop: 1 setCycle: End self)
			)
			(29
				(drJohn cel: 0 loop: 2 setCycle: End self)
			)
			(30
				(malia setPri: 131 setCycle: CT 1 1 self)
			)
			(31
				(malia setCycle: CT 3 1 self)
				(drJohn cel: 0 loop: 2 view: 486 posn: 85 127 hide:)
			)
			(32
				(malia setCycle: End self)
				(drJohn show:)
			)
			(33
				(malia loop: 1 cel: 0 setCycle: Fwd)
				(= seconds 2)
			)
			(34
				(drJohn view: 4871 loop: 1 cel: 0 setCycle: End self)
			)
			(35
				(Load rsVIEW 611)
				(for ((= temp1 100)) (>= temp1 0) ((-= temp1 4))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(PalCycle 4 192) ; Off
				(PalCycle 4 208) ; Off
				(local3 eachElementDo: #dispose release:)
				(gCurRoom drawPic: 611 0)
				(for ((= temp1 0)) (<= temp1 100) ((+= temp1 4))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(= cycles 1)
			)
			(36
				(= seconds 1)
			)
			(37
				(UnLoad 129 610)
				(local3 add: (ohMyHead init: setCycle: End self yourself:))
				(gMessager say: 5 0 16 4 self) ; "(A DRUG IS BEING SPRAYED INTO HIS FACE)Uggh <gasp>!"
			)
			(38 1)
			(39
				(local3 add: (drums init: yourself:))
				(gMessager say: 5 0 16 5 self) ; "Tetelo! Ou couleuvre moins!"
			)
			(40
				(local3 add: (theEyes init: yourself:))
				(local3 add: (eyeBlink init: setCycle: End self yourself:))
			)
			(41
				(local3 add: (voodooShit init: yourself:))
				(= seconds 2)
			)
			(42
				(local3 add: (maliaWithSnake init: yourself:))
				(gMessager say: 5 0 16 6 self) ; "!!!Blank msg"
			)
			(43
				(UnLoad 128 612)
				(for ((= temp1 100)) (>= temp1 0) ((-= temp1 4))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(local3 eachElementDo: #dispose release:)
				(UnLoad 128 611)
				(UnLoad 128 6111)
				(UnLoad 128 6112)
				(gCurRoom drawPic: 99 0)
				(if (and (== (Platform) 1) (not (IsFlag 470)))
					(SetVideoMode 1)
				)
				(for ((= temp1 0)) (<= temp1 100) ((+= temp1 4))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(= cycles 1)
			)
			(44
				(if (IsFlag 470)
					(self setScript: flopMovie1 self)
				else
					(if (== (Platform) 1)
						(ShowMovie
							{VEVE.SEQ}
							7
							(if (IsHiRes) 150 else 0)
							(if (IsHiRes) 135 else 0)
						)
					else
						(ShowMovie 0 {VEVE.AVI}) ; Open
						(ShowMovie 1 0 0 320 200) ; Put
						(ShowMovie 2 2) ; Play
						(ShowMovie 6) ; Close
					)
					(= cycles 1)
				)
			)
			(45
				(for ((= temp1 100)) (>= temp1 0) ((-= temp1 4))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(if (and (== (Platform) 1) (not (IsFlag 470)))
					(SetVideoMode 0)
				)
				(gCurRoom drawPic: 480 0)
				(bonfire init: setCycle: Fwd)
				(torch1 init: setCycle: Fwd)
				(torch2 init: setCycle: Fwd)
				(torch3 init: setCycle: Fwd)
				(torch4 init: setCycle: Fwd)
				(torch5 init: setCycle: Fwd)
				(drum2 init: setCycle: Fwd)
				(asson init: setCycle: Fwd)
				(kneelingNude init: setCycle: Fwd)
				(standingNude init: setCycle: Osc)
				(foregroundFemale init: setCycle: RandCycle)
				(rightMale init: setCycle: Fwd)
				(leftMale init: setCycle: RandCycle)
				(drummer init: setCycle: Fwd)
				(goat init:)
				(cage init:)
				(chicksInVeve init:)
				(malia view: 486 loop: 1 cel: 0 init: posn: 131 124)
				(gEgo view: 4812 loop: 0 cel: 2 init: posn: 32 127)
				(drJohn view: 488 loop: 2 cel: 0 init: posn: 81 128)
				(UpdateScreenItem gEgo)
				(PalCycle 0 192 207 1 6) ; Start
				(PalCycle 0 208 215 1 6) ; Start
				(local3
					add:
						gEgo
						drJohn
						bonfire
						torch1
						torch2
						torch3
						torch4
						torch5
					add:
						kneelingNude
						standingNude
						foregroundFemale
						rightMale
						leftMale
						drummer
						goat
						malia
						chicksInVeve
						cage
						drum2
						asson
					yourself:
				)
				(for ((= temp1 0)) (<= temp1 100) ((+= temp1 4))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(= cycles 1)
			)
			(46
				(malia setCycle: Fwd)
				(gMessager say: 5 0 16 7 self) ; "!!!Blank msg"
			)
			(47
				(malia setCycle: 0 cel: 0 setCycle: CT 5 1 self)
			)
			(48
				(drJohn hide:)
				(malia
					view: 488
					loop: 0
					cel: 0
					posn: 129 126
					setCycle: End self
				)
			)
			(49
				(drJohn show:)
				(malia loop: 1 cel: 0 setCycle: Fwd)
				(= seconds 2)
			)
			(50
				(gEgo
					view: 487
					loop: 0
					cel: 0
					posn: 56 127
					setCycle: End self
				)
			)
			(51
				(for ((= temp1 100)) (>= temp1 0) ((-= temp1 4))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(local3 eachElementDo: #dispose release:)
				(gCurRoom drawPic: 613 0)
				(PalCycle 4 192) ; Off
				(PalCycle 4 208) ; Off
				(local3 add: (knife init: yourself:))
				(for ((= temp1 0)) (<= temp1 100) ((+= temp1 4))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(= cycles 1)
			)
			(52
				(knife setCycle: End self)
			)
			(53
				(local3 add: (gabeNoMask init: yourself:))
				(= seconds 2)
			)
			(54
				(local3 add: (gabeFace init: yourself:))
				(local3 add: (eyebrow init: setCycle: End self yourself:))
			)
			(55
				(for ((= temp1 100)) (>= temp1 0) ((-= temp1 4))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(local3 eachElementDo: #dispose release:)
				(gCurRoom drawPic: 99 0)
				(UnLoad 129 611)
				(UnLoad 128 613)
				(UnLoad 128 6131)
				(UnLoad 128 6132)
				(if (and (== (Platform) 1) (not (IsFlag 470)))
					(SetVideoMode 1)
				)
				(for ((= temp1 0)) (<= temp1 100) ((+= temp1 4))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(if (IsFlag 470)
					(self setScript: flopMovie2 self)
				else
					(if (== (Platform) 1)
						(ShowMovie
							{MORPH.SEQ}
							7
							(if (IsHiRes) 150 else 0)
							(if (IsHiRes) 135 else 0)
						)
					else
						(ShowMovie 0 {MORPH.AVI}) ; Open
						(ShowMovie 1 0 0 320 200) ; Put
						(ShowMovie 2 2) ; Play
						(ShowMovie 6) ; Close
					)
					(= cycles 1)
				)
			)
			(56
				(for ((= temp1 100)) (>= temp1 0) ((-= temp1 4))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(if (and (== (Platform) 1) (not (IsFlag 470)))
					(SetVideoMode 0)
				)
				(UnLoad 129 613)
				(gCurRoom drawPic: 6131 0)
				(for ((= temp1 0)) (<= temp1 100) ((+= temp1 4))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(= seconds 1)
			)
			(57
				(= seconds 1)
			)
			(58
				(for ((= temp1 100)) (>= temp1 0) ((-= temp1 4))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(gCurRoom drawPic: 99 0)
				(if (and (== (Platform) 1) (not (IsFlag 470)))
					(SetVideoMode 1)
				)
				(for ((= temp1 0)) (<= temp1 100) ((+= temp1 4))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(if (IsFlag 470)
					(self setScript: flopMovie3 self)
				else
					(if (== (Platform) 1)
						(ShowMovie
							{KNIFE.SEQ}
							7
							(if (IsHiRes) 150 else 0)
							(if (IsHiRes) 135 else 0)
						)
					else
						(ShowMovie 0 {KNIFE.AVI}) ; Open
						(ShowMovie 1 0 0 320 200) ; Put
						(ShowMovie 2 2) ; Play
						(ShowMovie 6) ; Close
					)
					(= cycles 1)
				)
				(Load rsPIC 614)
				(Load rsVIEW 614)
			)
			(59
				(for ((= temp1 100)) (>= temp1 0) ((-= temp1 4))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(if (and (== (Platform) 1) (not (IsFlag 470)))
					(SetVideoMode 0)
				)
				(UnLoad 129 6131)
				(gCurRoom drawPic: 614 0)
				(for ((= temp1 0)) (<= temp1 100) ((+= temp1 4))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(= cycles 1)
			)
			(60
				(local3 add: (grabMask init: yourself:))
				(gMessager say: 5 0 16 9 self) ; "!!!Blank msg"
			)
			(61
				(local3 add: (uncovered init: yourself:))
				(= seconds 1)
			)
			(62
				(local3 add: (maliaFace init: yourself:))
				(local3 add: (maliaGasp init: setCycle: End self yourself:))
				(gMessager say: 5 0 16 10 self) ; "(SHOCKED, FEARFUL)Gabriel?"
			)
			(63 1)
			(64
				(local3
					add: (gabeFace x: 234 view: 6141 loop: 3 init: yourself:)
				)
				(= seconds 1)
			)
			(65
				(gabeFace view: 614 loop: 3 cel: 0)
				(UpdateScreenItem gabeFace)
				(= seconds 1)
			)
			(66
				(for ((= temp1 100)) (>= temp1 0) ((-= temp1 4))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(local3 eachElementDo: #dispose release:)
				(UnLoad 128 613)
				(UnLoad 128 614)
				(UnLoad 128 6141)
				(UnLoad 128 6142)
				(gCurRoom drawPic: 480 0)
				(bonfire init: setCycle: Fwd)
				(torch1 init: setCycle: Fwd)
				(torch2 init: setCycle: Fwd)
				(torch3 init: setCycle: Fwd)
				(torch4 init: setCycle: Fwd)
				(torch5 init: setCycle: Fwd)
				(drum2 init: setCycle: Fwd)
				(asson init: setCycle: Fwd)
				(kneelingNude init: setCycle: Fwd)
				(standingNude init: setCycle: Osc)
				(foregroundFemale init: setCycle: RandCycle)
				(rightMale init: setCycle: Fwd)
				(leftMale init: setCycle: RandCycle)
				(drummer init: setCycle: Fwd)
				(goat init:)
				(cage init:)
				(chicksInVeve init:)
				(malia init: setCycle: Fwd)
				(gEgo init:)
				(drJohn init:)
				(UpdateScreenItem gEgo)
				(PalCycle 0 192 207 1 6) ; Start
				(PalCycle 0 208 215 1 6) ; Start
				(local3
					add:
						gEgo
						drJohn
						bonfire
						torch1
						torch2
						torch3
						torch4
						torch5
					add:
						kneelingNude
						standingNude
						foregroundFemale
						rightMale
						leftMale
						drummer
						goat
						malia
						chicksInVeve
						cage
						drum2
						asson
					yourself:
				)
				(for ((= temp1 0)) (<= temp1 100) ((+= temp1 4))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(= cycles 1)
			)
			(67
				(gMessager say: 5 0 16 11 self) ; "(VERY LOUD, FRENZIED)TETELO, TETELO, come take our bride!"
			)
			(68
				(for ((= temp1 100)) (>= temp1 0) ((-= temp1 4))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(local3 eachElementDo: #dispose release:)
				(gCurRoom drawPic: 615 0)
				(PalCycle 4 192) ; Off
				(PalCycle 4 208) ; Off
				(UnLoad 129 480)
				(for ((= temp1 0)) (<= temp1 100) ((+= temp1 4))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(= seconds 1)
			)
			(69
				(UnLoad 129 614)
				(local3 add: (possessionFace init: yourself:))
				(= seconds 2)
			)
			(70
				(local3 add: (gabeStaggers init: yourself:))
				(gMessager say: 5 0 16 12 self) ; "(FEARFUL--QUESTIONING--IS THAT YOU?)Malia?"
			)
			(71
				(local3 add: (madMalia init: yourself:))
				(gMessager sayRange: 5 0 16 13 18 self) ; "(TETELO'S VOICE. EVIL. DARK. GHOSTLY, TOO)I know you now. I can smell his blood in your veins."
			)
			(72
				(for ((= temp1 100)) (>= temp1 0) ((-= temp1 4))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(local3 eachElementDo: #dispose release:)
				(gCurRoom drawPic: 616 0)
				(UnLoad 128 615)
				(for ((= temp1 0)) (<= temp1 100) ((+= temp1 4))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(= cycles 1)
			)
			(73
				(= seconds 1)
			)
			(74
				(local3 add: (crazedMalia init: yourself:))
				(local3 add: (aaagh init: yourself:))
				(= cycles 3)
			)
			(75
				(aaagh setCycle: End self)
				(gMessager say: 5 0 16 19 self) ; "(MOCKING, LAUGHING EVILY WHILE SAYING THIS)Where is your necklace now, Witch-hunter? Where are your pretty, pretty gems?"
			)
			(76 1)
			(77
				(local3 add: (graceRescues init: yourself:))
				(= seconds 2)
			)
			(78
				(gGkSound2 setLoop: 1 number: 481 play:)
				(local3 add: (graceHand init: setCycle: End self yourself:))
			)
			(79
				(= seconds 2)
			)
			(80
				(gGkSound1 flags: 1)
				(gGkSound1 stop:)
				(for ((= temp1 100)) (>= temp1 0) ((-= temp1 4))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(gKeyDownHandler delete: self)
				(local3 eachElementDo: #dispose release:)
				(gCurRoom drawPic: 99 0)
				(UnLoad 129 615)
				(UnLoad 128 616)
				(= cycles 1)
			)
			(81
				(Palette 2 0 256 100) ; PalIntensity
				(PalCycle 4 192) ; Off
				(PalCycle 4 208) ; Off
				(gTheIconBar enable:)
				(GK keepBar: local7)
				(++ gDay)
				(gCurRoom newRoom: 370)
			)
		)
	)
)

(instance abortCartoon of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if local3
					(local3 dispose:)
					(= local3 0)
				)
				(PalCycle 4 192) ; Off
				(PalCycle 4 208) ; Off
				(gTheIconBar enable:)
				(GK keepBar: local7)
				(gGkSound1 flags: 1)
				(gGkSound1 stop:)
				(++ gDay)
				(if (and gCuees (= temp1 (gCuees size:)))
					(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
						(if (== gMessager ((gCuees at: temp0) cuee:))
							(gMessager caller: 0 cue: 1)
						)
						(break)
					)
					(gCuees dispose:)
					(= gCuees (Set new:))
				)
				(Platform 0 2 0)
				(gCurRoom newRoom: 370)
			)
		)
	)
)

(instance killGabe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 216)
					(voodooMask init:)
				else
					(drJohn dispose:)
				)
				(gEgo loop: 2 cel: 0 cycleSpeed: 24 setCycle: End self)
			)
			(1
				(= seconds 6)
			)
			(2
				(PalCycle 4 192) ; Off
				(PalCycle 4 208) ; Off
				(SetQuitStr
					{\nThank you for playing Gabriel Knight.\n\nNow go to bed.\n\n\n}
				)
				(gCurRoom newRoom: 770) ; deathRm
			)
		)
	)
)

(instance flopMovie1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 126 14)
				(= cycles 2)
			)
			(1
				(gCurRoom drawPic: 99 14)
				(= ticks 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance flopMovie2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 116 14)
				(= cycles 2)
			)
			(1
				(gCurRoom drawPic: 117 14)
				(= cycles 2)
			)
			(2
				(gCurRoom drawPic: 118 14)
				(= cycles 2)
			)
			(3
				(gCurRoom drawPic: 119 14)
				(= cycles 2)
			)
			(4
				(gCurRoom drawPic: 99 14)
				(= ticks 1)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance flopMovie3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 132 14)
				(= cycles 2)
			)
			(1
				(gCurRoom drawPic: 133 14)
				(= cycles 2)
			)
			(2
				(gCurRoom drawPic: 134 14)
				(= cycles 2)
			)
			(3
				(gCurRoom drawPic: 135 14)
				(= cycles 2)
			)
			(4
				(gCurRoom drawPic: 136 14)
				(= cycles 2)
			)
			(5
				(gCurRoom drawPic: 99 14)
				(= ticks 1)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance drJohn of Actor
	(properties
		x 124
		y 124
		view 481
		loop 1
		signal 16417
	)
)

(instance malia of Actor
	(properties
		x 320
		y 123
		view 483
		signal 16417
	)
)

(instance asson of Prop
	(properties
		x 255
		y 134
		view 4821
		loop 2
		cel 1
	)
)

(instance drum2 of Prop
	(properties
		x 259
		y 150
		view 4821
		loop 1
		cel 2
		signal 16417
	)
)

(instance kneelingNude of Prop
	(properties
		x 103
		y 106
		view 4823
		signal 16417
	)
)

(instance standingNude of Prop
	(properties
		x 205
		y 114
		view 4822
		signal 16417
		cycleSpeed 4
	)
)

(instance foregroundFemale of Prop
	(properties
		x 184
		y 146
		view 4826
		signal 16417
	)
)

(instance rightMale of Prop
	(properties
		x 216
		y 150
		view 4825
		signal 16417
		cycleSpeed 4
	)
)

(instance leftMale of Prop
	(properties
		x 155
		y 148
		view 4824
		signal 16417
	)
)

(instance drummer of Prop
	(properties
		x 279
		y 142
		view 4821
		signal 16417
		cycleSpeed 4
	)
)

(instance goat of View
	(properties
		x 213
		y 94
		view 484
		cel 1
	)
)

(instance head of Prop
	(properties
		x 122
		y 81
		view 481
		cel 1
		cycleSpeed 120
	)
)

(instance bonfire of Prop
	(properties
		x 168
		y 116
		view 482
		cel 2
	)
)

(instance torch1 of Prop
	(properties
		x 45
		y 53
		view 482
		loop 1
		cel 5
	)
)

(instance torch2 of Prop
	(properties
		x 119
		y 58
		view 482
		loop 2
		cel 2
	)
)

(instance torch3 of Prop
	(properties
		x 183
		y 59
		view 482
		loop 3
	)
)

(instance torch4 of Prop
	(properties
		x 245
		y 60
		view 482
		loop 4
		cel 6
	)
)

(instance torch5 of Prop
	(properties
		x 271
		y 57
		view 482
		loop 5
		cel 4
	)
)

(instance bloodSpill of Prop
	(properties
		x 76
		y 72
		view 6101
		loop 1
	)
)

(instance eyeBlink of Prop
	(properties
		x 265
		y 47
		priority 150
		fixPriority 1
		view 6112
		loop 2
		cycleSpeed 30
	)
)

(instance knife of Prop
	(properties
		x 8
		y 22
		view 6131
		cycleSpeed 20
	)
)

(instance eyebrow of Prop
	(properties
		x 231
		y 38
		view 6132
		loop 1
		cycleSpeed 20
	)
)

(instance maliaGasp of Prop
	(properties
		x 106
		y 22
		priority 25
		fixPriority 1
		view 6141
		loop 2
		cycleSpeed 18
	)
)

(instance graceHand of Prop
	(properties
		y 105
		view 6161
		cycleSpeed 18
	)
)

(instance aaagh of Prop
	(properties
		x 192
		y 22
		priority 25
		fixPriority 1
		view 6162
		loop 1
		cycleSpeed 18
	)
)

(instance cage of View
	(properties
		x 87
		y 140
		view 4832
		loop 1
	)
)

(instance chicksInVeve of View
	(properties
		x 109
		y 116
		view 4832
	)
)

(instance voodooMask of View
	(properties
		x 90
		y 121
		view 4812
		cel 4
	)
)

(instance closeChicken of View
	(properties
		x 112
		y 22
		view 610
	)
)

(instance bowl of View
	(properties
		x 76
		y 72
		view 610
		loop 1
	)
)

(instance deadChickens of View
	(properties
		x 206
		y 72
		view 610
		loop 2
	)
)

(instance ohMyHead of Prop
	(properties
		x 106
		y 22
		view 6111
		cycleSpeed 24
	)
)

(instance drums of View
	(properties
		x 106
		y 67
		view 611
		loop 1
	)
)

(instance theEyes of View
	(properties
		x 205
		y 22
		view 611
		loop 2
	)
)

(instance voodooShit of View
	(properties
		x 205
		y 73
		view 611
		loop 3
	)
)

(instance maliaWithSnake of View
	(properties
		x -1
		y 22
		view 612
	)
)

(instance gabeNoMask of View
	(properties
		x 72
		y 22
		view 613
	)
)

(instance gabeFace of View
	(properties
		x 231
		y 22
		view 613
		loop 1
	)
)

(instance grabMask of View
	(properties
		y 58
		view 614
	)
)

(instance uncovered of View
	(properties
		y 95
		view 614
		loop 1
	)
)

(instance maliaFace of View
	(properties
		x 106
		y 22
		view 614
		loop 2
	)
)

(instance possessionFace of View
	(properties
		x 120
		y 22
		view 615
	)
)

(instance gabeStaggers of View
	(properties
		x 206
		y 22
		view 615
		loop 1
	)
)

(instance madMalia of View
	(properties
		x 265
		y 22
		view 615
		loop 2
	)
)

(instance graceRescues of View
	(properties
		y 79
		view 616
	)
)

(instance crazedMalia of View
	(properties
		x 192
		y 22
		view 616
		loop 1
	)
)

(instance questions of GKTeller
	(properties
		curNoun 7
		sayNoun 8
		verb 69
	)

	(method (showCases)
		(super showCases: 5 (not local1) 7 (not local1) 6 local1 8 local1) ; Maitresse Erzulie., Papa Gede?, Buddha, perhaps?, Ogoun Badagris.
	)

	(method (cue)
		(switch iconValue
			(6 ; Buddha, perhaps?
				(roomScript register: 12 cue:)
			)
			(5 ; Maitresse Erzulie.
				(roomScript register: 12 cue:)
			)
			(7 ; Papa Gede?
				(roomScript register: 12 cue:)
			)
			(10 ; I'm not quite sure.
				(roomScript register: 14 cue:)
			)
			(9 ; Damballah.
				(if local1
					(roomScript register: 12 cue:)
				else
					(= iconValue 13) ; "You are correct, Brother Crocodile."
					(= local1 1)
					(gEgo getPoints: -999 1)
					(self sayMessage:)
				)
			)
			(8 ; Ogoun Badagris.
				(if local1
					(= iconValue 11) ; "You are correct, Brother Crocodile. Enjoy yourself WELL tonight (heh heh)."
					(gEgo getPoints: -999 1)
					(self sayMessage:)
				else
					(roomScript register: 12 cue:)
				)
			)
			(11 ; "You are correct, Brother Crocodile. Enjoy yourself WELL tonight (heh heh)."
				(roomScript register: 0 cue:)
			)
			(13 ; "You are correct, Brother Crocodile."
				(self doVerb: 11)
			)
		)
	)
)

