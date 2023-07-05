;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6000)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm6000 0
)

(local
	local0
	local1
	[local2 3]
	local5
	local6
)

(instance rm6000 of KQRoom
	(properties
		picture 6601
	)

	(method (init)
		(SetFlag 21)
		(super init: &rest)
		(Load rsMESSAGE 6000)
		(Load rsVIEW 6603 6601)
		(Load rsSOUND 6001 6002)
		((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
		((ScriptID 7001 8) client: levanter hide_mouth: 1) ; levanterTalker
		(gEgo normalize: 0 6603 cel: 3 posn: 86 241 init:)
		(windSound init: hide: setScript: blowTheWind)
		(gCurRoom setScript: scrollIt)
		(AddPicAt gThePlane 6602 0 136)
		(musicHandler init: hide: setScript: handleMusicFades musicHandler)
	)

	(method (dispose)
		((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
		((ScriptID 7001 8) hide_mouth: 0) ; levanterTalker
		(gThePlane setRect: 0 0 320 136)
		(super dispose: &rest)
	)
)

(instance sChap5Toon of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(gEgo
						setCycle: End self
						setMotion: MoveTo (gEgo x:) 103
					)
					(borasco init: setCycle: End self)
					(gKqSound1 number: 6001 setLoop: 1 play: setVol: 127)
				)
				(1)
				(2
					(gEgo hide:)
					(borasco loop: 2 cel: 0 x: 182 y: 59 setCycle: CT 1 1 self)
					(UpdateScreenItem borasco)
				)
				(3
					(gKqSound1 stop: number: 6002 setLoop: 1 play: setVol: 127)
					(borasco setCycle: End)
					(gEgo
						view: 6601
						loop: 3
						cel: 0
						x: 128
						y: 138
						show:
						setCycle: End self
					)
				)
				(4
					(gKqSound1 number: 817 setLoop: 1 play: setVol: 127)
					(scirocco
						view: 6601
						loop: 4
						cel: 0
						x: 250
						y: 67
						init:
						setCycle: End self
					)
					(borasco loop: 5 cel: 0 x: 204 y: 52 setCycle: CT 5 1)
				)
				(5
					(scirocco hide:)
					(= cycles 2)
				)
				(6
					(gKqSound1 number: 6003 setLoop: 1 play: setVol: 127)
					(borasco setCycle: End)
					(gEgo loop: 6 cel: 0 y: 136 setCycle: End)
					(gharbi init: setCycle: End self)
				)
				(7
					(borasco hide:)
					(gMessager say: 0 0 1 1 self) ; "(YELLING)Borasco! You big bully! What have I told you about eating people? WHAT HAVE I TOLD YOU?"
					(gharbi loop: 8 cel: 0 x: 174 y: 89 setCycle: End self)
				)
				(8)
				(9
					(gMessager sayRange: 0 0 1 2 3 self) ; "(WHINING)Aw, mother, I was just playin'!"
					(gEgo
						view: 6602
						loop: 4
						cel: 0
						x: 150
						y: 144
						setCycle: End
					)
				)
				(10
					(gKqSound1 number: 6005 setLoop: 1 play: setVol: 127)
					(levanter init: setCycle: End self)
				)
				(11
					(levanter loop: 1 cel: 0 setCycle: End self)
				)
				(12
					(gMessager say: 0 0 1 4 self) ; "(STERN, FIERCE)What's going on here? SPEAK!"
				)
				(13
					(borasco hide:)
					(gharbi
						view: 6602
						loop: 2
						cel: 0
						x: 178
						y: 130
						setCycle: End self
					)
				)
				(14
					(gMessager say: 0 0 1 5 self) ; "(FIERCE)Who are YOU?"
				)
				(15
					(gKqSound1 number: 6005 setLoop: 1 play: setVol: 127)
					(levanter loop: 3 cel: 0 x: 180 y: 144 setCycle: End self)
				)
				(16
					(gGame handsOn:)
					(gCurRoom newRoom: 6002)
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
					(gCurRoom newRoom: 6002)
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
				(= seconds (Random 15 45))
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

(instance scrollIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gThePlane setRect: 0 -136 319 270 priority: 1)
				(UpdatePlane gThePlane)
				(= local5 (gEgo y:))
				(= seconds 3)
			)
			(1
				(= local0 -136)
				(= local1 136)
				(while (< local1 270)
					(gThePlane setRect: 0 local0 319 local1 priority: 1)
					(+= local0 3)
					(+= local1 3)
					(-= local5 3)
					(gEgo posn: (gEgo x:) local5)
					(UpdateScreenItem gEgo)
					(UpdatePlane gThePlane)
					(FrameOut)
				)
				(= local6 1)
				(= ticks 1)
			)
			(2
				(gCurRoom setScript: sChap5Toon)
				(self dispose:)
			)
		)
	)
)

(instance handleMusicFades of Script
	(properties)

	(method (doit)
		(if local6
			(= local6 0)
			(self cue:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKqMusic1
					stop:
					number: 6600
					loop: -1
					play:
					setVol: 0
					fade: 127 5 5 0 self
				)
			)
			(1)
			(2
				(gKqMusic1 fade: 0 5 5 1 self)
			)
			(3
				(gKqMusic1
					stop:
					number: 6250
					setLoop: -1
					play:
					setVol: 0
					fade: 127 5 5 0
				)
				(self dispose:)
			)
		)
	)
)

(instance scirocco of Actor
	(properties
		x 86
		y 106
		view 6603
		cel 3
	)
)

(instance borasco of Actor
	(properties
		x 237
		y 60
		view 6601
		loop 1
	)
)

(instance gharbi of Actor
	(properties
		x 150
		y 81
		view 6601
		loop 7
	)
)

(instance levanter of Actor
	(properties
		x 180
		y 146
		view 6602
	)
)

(instance windSound of Prop
	(properties
		view 6603
	)
)

(instance musicHandler of Prop
	(properties
		view 6603
	)

	(method (cue)
		(super cue: &rest)
		(self dispose:)
	)
)

(instance wind of Sound
	(properties
		number 6251
	)
)

