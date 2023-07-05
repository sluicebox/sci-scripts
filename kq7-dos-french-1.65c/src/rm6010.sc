;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6010)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use Osc)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm6010 0
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1)
	(if (or (== argc 0) (== param1 1))
		(for ((= temp0 100)) (> temp0 0) ((-= temp0 4))
			(Palette 2 0 71 temp0) ; PalIntensity
			(Palette 2 104 235 temp0) ; PalIntensity
			(gCast doit:)
			(FrameOut)
		)
	else
		(for ((= temp0 0)) (< temp0 100) ((+= temp0 4))
			(Palette 2 0 71 temp0) ; PalIntensity
			(Palette 2 104 235 temp0) ; PalIntensity
			(gCast doit:)
			(FrameOut)
		)
	)
	(if (and (== argc 2) param2)
		(param2 cue:)
	)
)

(instance rm6010 of KQRoom
	(properties
		picture 6000
	)

	(method (init)
		(gGame handsOff: 1)
		(SetFlag 21)
		(SetFlag 212)
		(super init: &rest)
		(Load rsMESSAGE 6000)
		(Load 140 2264 6251) ; WAVE
		(wind init:)
		(rumble init:)
		(if (== gChapter 5)
			(windHost init: hide: setScript: blowTheWind)
		)
		(= gValOrRoz -4) ; Val
		(gEgo normalize:)
		((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
		((ScriptID 7001 8) client: levanter view: 6001 loop: 21 clientCel: 10) ; levanterTalker
		(switch gPrevRoomNum
			(2155
				(self setScript: sChap6Toon)
			)
			(6002
				(gCurRoom setScript: sChap5Toon1)
			)
			(6012
				(gCurRoom setScript: sChap5Toon2)
			)
			(else
				(switch gChapter
					(5
						(gCurRoom setScript: sChap5Toon1)
					)
					(6
						(gCurRoom setScript: sChap6Toon)
					)
					(else
						(gCurRoom setScript: sChap5Toon1)
					)
				)
			)
		)
		(switch gChapter
			(5
				(Load rsVIEW 6001 6002)
				(Load 140 6006 6251 2264) ; WAVE
			)
			(6
				(Load rsVIEW 6010)
				(Load 140 6251 2264 813 6004 4104) ; WAVE
			)
		)
		(if (!= (gKqMusic1 number:) 6250)
			(gKqMusic1
				stop:
				number: 6250
				setLoop: -1
				play:
				setVol: 0
				fade: 127 5 5 0
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 35) ; chapEndRm
			(gKqMusic1 fade: 0 25 10 1)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
		(wind stop:)
		(rumble stop:)
		(super dispose: &rest)
	)
)

(instance sChap5Toon1 of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(borasco init: setCycle: Fwd)
					(gharbi init: setCycle: Fwd)
					(gEgo
						loop: 6
						x: 141
						y: 117
						setPri: 125
						setScale:
						scaleX: 52
						scaleY: 52
						init:
					)
					(levanter init: setCycle: Fwd)
					(volcano init: setCycle: Fwd)
					(= seconds 3)
				)
				(1
					(gKqSound1 number: 6006 setLoop: 1 play: setVol: 127)
					(levanter loop: 1 cel: 0 setCycle: CT 10 1 self)
				)
				(2
					(gMessager say: 0 0 1 8 self 6000) ; "(ALARMED, COMMANDING, BOOMING VOICE)WINDS! COME TO ME! COME TO ME NOW!"
				)
				(3
					(levanter setCycle: End self)
				)
				(4
					(levanter loop: 0 cel: 0 x: 169 y: 123 setCycle: Fwd)
					(= seconds 6)
				)
				(5
					(gEgo
						view: 6002
						loop: 6
						cel: 0
						x: 155
						y: 122
						setScale:
						scaleX: 128
						scaleY: 128
						setCycle: End
					)
					(scirocco init: setCycle: End self)
				)
				(6
					(scirocco loop: 7 cel: 0 x: 221 y: 97 setCycle: Fwd)
					(= ticks 45)
				)
				(7
					(gEgo cel: 0 setCycle: End)
					(zephyr init: setCycle: End self)
				)
				(8
					(zephyr loop: 6 cel: 0 x: 216 y: 40 setCycle: Fwd)
					(gKqSound1 number: 6006 setLoop: 1 play: setVol: 127)
					(levanter loop: 1 cel: 0 setCycle: CT 10 1 self)
				)
				(9
					(gMessager say: 0 0 1 9 self 6000) ; "(FIERCE, COMMANDING)Fly, my people! Fly, and find the Lord and Lady of Etheria!"
				)
				(10
					(if (!= ((windHost script:) state:) 2)
						(gKqSound1 number: 6007 setLoop: 1 play: setVol: 127)
					)
					(gEgo cel: 0 setCycle: End)
					(levanter setCycle: End)
					(scirocco
						view: 6002
						loop: 0
						cel: 0
						x: 241
						y: 86
						setCycle: End
					)
					(gharbi view: 6002 loop: 1 cel: 0 x: 86 y: 81 setCycle: End)
					(borasco
						view: 6002
						loop: 2
						cel: 0
						x: 117
						y: 48
						setCycle: End
					)
					(zephyr setScript: zephyrGetsBlown self)
				)
				(11
					(scirocco hide:)
					(zephyr hide:)
					(borasco hide: dispose:)
					(gharbi hide: dispose:)
					(gEgo
						setScale:
						scaleX: 128
						scaleY: 128
						setScript: valSearches
					)
					(levanter setScript: levSearches)
					(= seconds 10)
				)
				(12
					(localproc_0 1 self)
				)
				(13
					(= seconds 4)
				)
				(14
					(localproc_0 0 self)
				)
				(15
					(gEgo setScript: 0 setCycle: End)
					(levanter setScript: 0 setCycle: End self)
				)
				(16
					(levanter
						view: 6002
						loop: 7
						cel: 0
						x: 160
						y: 124
						setCycle: Osc 1 self
					)
				)
				(17
					(gKqMusic1 fade: 75 25 10 0)
					(gKqSound1 number: 6010 setLoop: 1 play: setVol: 127)
					(obAnTi
						view: 6003
						loop: 0
						cel: 0
						x: 98
						y: 38
						init:
						setCycle: End self
					)
				)
				(18
					(obAnTi hide:)
					(= cycles 2)
				)
				(19
					(= seconds 3)
				)
				(20
					(obAnTi
						loop: 1
						cel: 0
						x: -15
						y: 98
						show:
						setCycle: End self
					)
				)
				(21
					(gKqMusic1 fade: 127 25 10 0)
					(zephyr
						view: 6003
						loop: 6
						cel: 0
						x: 0
						y: 95
						show:
						setCycle: End self
					)
				)
				(22
					(swan init:)
					(zephyr loop: 2 cel: 0 x: 104 y: 60 setCycle: Fwd)
					(obAnTi
						loop: 3
						cel: 0
						x: 96
						y: 98
						setPri: (+ (swan priority:) 1)
						setCycle: End self
					)
					(levanter
						view: 6001
						loop: 0
						cel: 0
						x: 169
						y: 123
						setCycle: Fwd
					)
				)
				(23
					(gGame handsOn:)
					(gCurRoom newRoom: 6012)
				)
			)
		else
			(switch (= state newState)
				(0
					(= cycles 2)
				)
				(1
					(ClearFlag 539)
					(Palette 2 0 71 100) ; PalIntensity
					(Palette 2 104 235 100) ; PalIntensity
					(gKqSound1 stop:)
					(gGame handsOn:)
					(gCurRoom newRoom: 6012)
				)
			)
		)
	)
)

(instance sChap5Toon2 of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(swan init:)
					(zephyr
						view: 6003
						loop: 2
						cel: 0
						x: 104
						y: 60
						init:
						setCycle: Fwd
					)
					(volcano
						view: 6000
						loop: 0
						cel: 0
						x: 28
						y: 45
						init:
						setCycle: Fwd
					)
					(volcanoFizz init: setScript: fizzABit)
					(obAnTi init: view: 6003 loop: 3)
					(obAnTi
						cel: (- (NumCels obAnTi) 1)
						x: 96
						y: 98
						setPri: (+ (swan priority:) 1)
					)
					(levanter
						view: 6001
						loop: 0
						cel: 0
						x: 169
						y: 123
						init:
						setCycle: Fwd
					)
					(gEgo init: view: 6004 loop: 0)
					(gEgo cel: (- (NumCels gEgo) 1) x: 130 y: 108)
					(= cycles 1)
				)
				(1
					(obAnTi setCycle: Beg self)
				)
				(2
					(gEgo
						loop: 3
						cel: 0
						x: 131
						y: 107
						setScale:
						scaleX: 52
						scaleY: 52
						setCycle: End self
					)
					(levanter setMotion: MoveTo 195 130)
				)
				(3
					(gEgo
						normalize: 7
						x: 145
						y: 111
						setMotion: MoveTo 196 96 self
					)
				)
				(4
					(gEgo setHeading: 270 self)
				)
				(5
					(swan hide: dispose:)
					(obAnTi
						view: 6005
						loop: 0
						cel: 0
						x: 88
						y: 110
						setPri: (+ (gEgo priority:) 1)
						setCycle: End self
					)
				)
				(6
					(obAnTi hide: dispose:)
					(zephyr
						view: 6005
						loop: 1
						cel: 0
						x: 104
						y: 57
						setCycle: End self
					)
				)
				(7
					(zephyr hide: dispose:)
					(= cycles 2)
				)
				(8
					(gEgo
						normalize: 7 801
						setStep: 5 4
						setSpeed: 6
						setScale:
						scaleX: 52
						scaleY: 52
						setPri: 85
						setMotion: MoveTo 105 82 self
					)
				)
				(9
					(gEgo setCycle: StopWalk 800)
					(= cycles 2)
				)
				(10
					(gEgo
						view: 6004
						loop: 0
						cel: 0
						x: 96
						y: 81
						setScale:
						scaleX: 128
						scaleY: 128
						setCycle: 0
					)
					(gMessager say: 0 0 1 15 self 6000) ; "(DESPERATE, STRICKEN)Wait! My daughter! What about my daughter!?"
				)
				(11
					(gGame handsOn:)
					(gCurRoom newRoom: 35) ; chapEndRm
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= cycles 2)
				)
				(1
					(ClearFlag 539)
					(gKqSound1 stop:)
					(gGame handsOn:)
					(gCurRoom newRoom: 35) ; chapEndRm
					(self dispose:)
				)
			)
		)
	)
)

(instance sChap6Toon of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(volcano
						view: 6000
						loop: 0
						cel: 0
						x: 28
						y: 45
						init:
						setCycle: Fwd
					)
					(volcanoFizz init: setScript: fizzABit)
					(gEgo
						loop: 7
						x: 125
						y: 105
						setScale:
						scaleX: 52
						scaleY: 52
						init:
					)
					(= cycles 2)
				)
				(1
					(rumble setLoop: 1 play: self setVol: 127)
				)
				(2
					(gKqSound1 number: 6251 setLoop: 1 play: setVol: 127)
					(edgar
						init:
						setScale:
						scaleX: 72
						scaleY: 72
						setCycle: End self
					)
				)
				(3
					(gKqSound1 number: 813 setLoop: 1 play:)
					(edgar loop: 1 cel: 0 x: 71 y: 97 setCycle: Fwd)
					(gEgo
						normalize: 7 801
						setPri: (+ (edgar priority:) 1)
						setStep: 5 4
						setSpeed: 6
						setMotion: MoveTo 85 98 self
					)
				)
				(4
					(gEgo view: 800 loop: 7)
					(edgar setCycle: End self)
				)
				(5
					(gKqSound1 number: 6004 setLoop: 1 play:)
					(edgar
						view: 6011
						loop: 0
						cel: 0
						x: 70
						y: 97
						setCycle: End self
					)
					(gEgo
						view: 6011
						setLoop: 1 1
						cel: 0
						x: 80
						y: 97
						scaleX: 69
						scaleY: 69
						setCycle: End
						setMotion: MoveTo 80 93
					)
				)
				(6
					(gEgo hide:)
					(edgar
						view: 6012
						loop: 0
						cel: 0
						x: 63
						y: 97
						setCycle: End self
					)
				)
				(7
					(rumble setLoop: 1 play: setVol: 127)
					(edgar
						view: 6012
						setLoop: 1 1
						cel: 0
						x: 72
						y: 98
						setStep: -1 2
						setMotion: MoveTo 69 85 self
					)
				)
				(8
					(gKqSound1 number: 4104 setLoop: 1 play:)
					(edgar setCycle: CT 8 1 self)
				)
				(9
					(edgar setPri: 80 setCycle: End self)
				)
				(10
					(edgar hide:)
					(= cycles 2)
				)
				(11
					(= ticks 20)
				)
				(12
					(edgar
						loop: 2
						cel: 0
						x: 65
						y: 118
						setStep: -1 6
						setSpeed: 3
						show:
						setMotion: MoveTo 35 178 self
					)
				)
				(13
					(edgar hide:)
					(gGame handsOn:)
					(gCurRoom newRoom: 2155)
				)
			)
		else
			(switch (= state newState)
				(0
					(= cycles 2)
				)
				(1
					(ClearFlag 539)
					(gKqSound1 stop:)
					(gGame handsOn:)
					(gCurRoom newRoom: 2155)
					(self dispose:)
				)
			)
		)
	)
)

(instance blowTheWind of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 15 30))
			)
			(1
				(wind setLoop: 1 play: self setVol: 127)
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance zephyrGetsBlown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					view: 6001
					loop: 2
					cel: 0
					x: 222
					y: 32
					setCycle: End self
				)
			)
			(1
				(client
					view: 6002
					loop: 3
					cel: 0
					x: 101
					y: 77
					setCycle: End self
				)
			)
			(2
				(client loop: 4 cel: 0 x: 83 y: 84 setCycle: End self)
			)
			(3
				(client loop: 5 cel: 0 x: 51 y: 55 setCycle: End self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance valSearches of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					view: 6003
					loop: 4
					cel: 0
					x: 140
					y: 120
					setCycle: End self
				)
			)
			(1
				(client
					view: 6004
					loop: 0
					cel: 0
					x: 130
					y: 108
					setCycle: CT (Random 1 5) 1 self
				)
			)
			(2
				(= ticks (Random 20 50))
			)
			(3
				(client setCycle: CT (+ (gEgo cel:) (Random 1 5)) 1 self)
			)
			(4
				(= ticks (Random 20 50))
			)
			(5
				(client setCycle: End self)
			)
			(6
				(= state 0)
				(= ticks 1)
			)
		)
	)
)

(instance levSearches of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(levanter
					view: 6003
					loop: 5
					cel: 0
					x: 149
					y: 124
					setCycle: End self
				)
			)
			(1
				(levanter
					view: 6004
					loop: 1
					cel: 0
					x: 155
					y: 118
					setCycle: CT (Random 2 9) 1 self
				)
			)
			(2
				(= ticks (Random 40 70))
			)
			(3
				(client setCycle: CT (+ (gEgo cel:) (Random 1 5)) 1 self)
			)
			(4
				(= ticks (Random 40 70))
			)
			(5
				(levanter setCycle: End self)
			)
			(6
				(= state 0)
				(= ticks 1)
			)
		)
	)
)

(instance fizzABit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 setCycle: End self)
			)
			(1
				(= ticks (Random 60 180))
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance zephyr of Actor
	(properties
		x 302
		y -10
		priority 140
		fixPriority 1
		view 6001
		loop 2
	)
)

(instance scirocco of Actor
	(properties
		x 320
		y 37
		priority 140
		fixPriority 1
		view 6001
		loop 3
	)
)

(instance borasco of Actor
	(properties
		x 117
		y 75
		view 6001
		loop 5
	)
)

(instance gharbi of Actor
	(properties
		x 69
		y 95
		view 6001
		loop 4
	)
)

(instance levanter of Actor
	(properties
		x 169
		y 123
		view 6001
	)
)

(instance obAnTi of Actor
	(properties
		x 169
		y 123
		view 6003
	)
)

(instance edgar of Actor
	(properties
		x 68
		y 139
		view 6010
	)
)

(instance volcano of Prop
	(properties
		x 36
		y 40
		priority 10
		fixPriority 1
		view 6004
		loop 4
	)
)

(instance volcanoFizz of Prop
	(properties
		x 32
		y 44
		priority 12
		fixPriority 1
		view 6000
		loop 1
	)
)

(instance windHost of Prop
	(properties
		view 6004
	)
)

(instance swan of View
	(properties
		x -15
		y 98
		view 6003
		loop 7
	)
)

(instance wind of Sound
	(properties
		number 6251
	)
)

(instance rumble of Sound
	(properties
		number 2264
	)
)

