;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 355)
(include sci.sh)
(use Main)
(use eRS)
(use Inset)
(use Talker)
(use Scaler)
(use Osc)
(use PolyPath)
(use StopWalk)
(use Actor)
(use System)

(public
	rm355 0
	tkrLaura 2
	tkrErnie 23
)

(local
	local0
)

(instance rm355 of LBRoom
	(properties
		noun 5
		picture 350
	)

	(method (init)
		(gEgo init: normalize: 831 setScale: Scaler 95 0 190 0)
		(self setRegions: 90) ; MuseumRgn
		(Palette palSET_INTENSITY 0 255 0)
		(self setScript: (if (IsFlag 34) sPartysOver else sIllegal))
		(super init:)
	)
)

(instance sPartysOver of Script
	(properties)

	(method (doit)
		(if (< local0 100)
			(Palette palSET_INTENSITY 0 255 (+= local0 2))
			(if (== local0 100)
				(self cue:)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 245 165 loop: 8 setCel: 5)
				((ScriptID 32 0) ; aHeimlich
					moveTo: 355
					originalView: 814
					init:
					setLoop: 8
					setCel: 2
					posn: 190 175
					ignoreActors: 1
				)
				((ScriptID 90 3) ; aORiley
					moveTo: 355
					view: 353
					setLoop: 1
					posn: 204 185
					ignoreActors: 1
				)
				((ScriptID 90 5) ; aWatney
					moveTo: 355
					view: 815
					posn: 147 184
					ignoreActors: 1
					setCycle: StopWalk -1
					setMotion: PolyPath 184 184 self
				)
				((ScriptID 90 1) ; aCountess
					moveTo: 355
					view: 813
					posn: 119 184
					ignoreActors: 1
					setCycle: StopWalk -1
					setMotion: PolyPath 161 184
				)
				((ScriptID 90 6) ; aYvette
					moveTo: 355
					view: 817
					posn: 85 184
					ignoreActors: 1
					setCycle: StopWalk -1
					setMotion: PolyPath 132 184
				)
				(= cycles 1)
			)
			(1
				((ScriptID 32 0) addToPic:) ; aHeimlich
				(gGameMusic1 number: 350 setLoop: -1 flags: 1 play:)
			)
			(2 0)
			(3
				(gMessager say: 2) ; "Having already interrogated the guests, Detective O'Riley is now discussing the murder with the staff members as they leave the party. It would be best if you don't interfere."
				((ScriptID 90 3) setCycle: Osc 2 self) ; aORiley
			)
			(4
				((ScriptID 22 0) doit: $a000 self) ; triggerAndClock, 10:00 pm
			)
			(5
				((ScriptID 90 5) setMotion: PolyPath 330 182) ; aWatney
				((ScriptID 90 1) setMotion: PolyPath 184 184 self) ; aCountess
				((ScriptID 90 6) setMotion: PolyPath 146 184) ; aYvette
			)
			(6
				((ScriptID 90 3) setCycle: Osc 3 self) ; aORiley
			)
			(7
				((ScriptID 90 1) setMotion: PolyPath 330 182) ; aCountess
				((ScriptID 90 6) setMotion: PolyPath 184 184 self) ; aYvette
			)
			(8
				((ScriptID 90 3) setCycle: Osc 2 self) ; aORiley
			)
			(9
				((ScriptID 90 6) setMotion: PolyPath 330 182 self) ; aYvette
			)
			(10
				((ScriptID 90 6) dispose:) ; aYvette
				((ScriptID 90 5) dispose:) ; aWatney
				((ScriptID 90 1) dispose:) ; aCountess
				(SetFlag 42)
				(gGameMusic1 fade:)
				(= ticks 60)
			)
			(11
				(gGameMusic1 number: 642 loop: -1 flags: 1 play:)
				((ScriptID 31 0) ; aErnie
					room: gCurRoomNum
					init:
					posn: 350 182
					setCycle: StopWalk -1
					setMotion:
						PolyPath
						(+ (gEgo x:) 10)
						(+ (gEgo y:) 10)
						self
				)
			)
			(12
				(= cycles 2)
			)
			(13
				(gCurRoom setInset: inErnie_Laura)
				(= cycles 2)
			)
			(14
				(gMessager say: 4 0 1 0 self) ; "Hi, Miss Bow. I'm Ernie Leach. Dr. Carrington told me you could stay awhile and talk to the staff. I've got to lock the doors, so just come and find me when you're ready to leave. Dr. C. also has a key, but you don't want to bother him about that."
			)
			(15
				(SetFlag 91)
				(gCurRoom setInset: 0)
				((ScriptID 32 0) ; aHeimlich
					posn:
						(- ((ScriptID 90 3) x:) 25) ; aORiley
						(- ((ScriptID 90 3) y:) 10) ; aORiley
					setLoop: 8
					setCel: 4
				)
				((ScriptID 21 0) doit: 267) ; addCluesCode, Ernie Leach
				((ScriptID 31 0) setMotion: PolyPath 350 185 self) ; aErnie
				(gGameMusic1 fade:)
			)
			(16
				(gMessager say: 1 0 0 0 self) ; "Did you manage to learn anything from your interviews, Detective O'Riley?"
			)
			(17
				(WrapMusic init: 1 90 91 92 93)
				(gEgo setMotion: PolyPath 340 185 self)
			)
			(18
				(gCurRoom newRoom: 370)
			)
		)
	)
)

(instance sIllegal of Script
	(properties)

	(method (doit)
		(if (< local0 100)
			(Palette palSET_INTENSITY 0 255 (+= local0 2))
			(if (== local0 100)
				(self cue:)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(SetFlag 91)
				(= gAct 0)
				(gUser canInput: 0 canControl: 0)
				((ScriptID 32 0) ; aHeimlich
					room: gCurRoomNum
					originalView: 814
					init:
					setLoop: 8
					setCel: 2
					posn: 190 175
				)
				((ScriptID 90 3) ; aORiley
					room: gCurRoomNum
					view: 819
					setLoop: 8
					setCel: 2
					posn: 210 180
				)
				(gEgo posn: 230 182 setLoop: 8 setCel: 2)
			)
			(1
				(gMessager say: 3 0 0 0 self) ; "Sure and begorrah, you can't be playing the game without studying about the Egyptian gods! Why, I've half a mind to arrest you right now!"
			)
			(2
				(= seconds 5)
			)
			(3
				(= global145 3) ; "The first three rules of journalism: research, research, research."
				(gCurRoom newRoom: 99) ; deathRoom
			)
		)
	)
)

(instance inErnie_Laura of Inset
	(properties
		name {inErnie&Laura}
		picture 475
		hideTheCast 1
	)
)

(instance tkrErnie of Talker
	(properties
		view 1475
		loop 1
		talkWidth 250
		back 15
		textX 20
		textY 120
	)

	(method (init)
		(= font gUserFont)
		(super init: 0 ernieEyes ernieMouth &rest)
	)
)

(instance ernieMouth of Prop
	(properties
		nsTop 82
		nsLeft 119
		view 1475
	)
)

(instance ernieEyes of Prop
	(properties
		nsTop 67
		nsLeft 122
		view 1475
		loop 2
	)
)

(instance tkrLaura of Narrator
	(properties
		x 150
		y 130
		back 15
	)

	(method (init)
		(= font gUserFont)
		(super init: &rest)
	)
)

