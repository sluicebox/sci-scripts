;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 85)
(include sci.sh)
(use Main)
(use Interface)
(use LoadMany)
(use DCIcon)
(use Gauge)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	closeCredits 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0)
	(= local2
		(switch ((ScriptID 0 23) number:) ; backSound
			(101 1)
			(102 2)
			(103 1)
		)
	)
)

(instance closeCredits of Rm
	(properties
		picture 900
		style 0
	)

	(method (init)
		(LoadMany rsVIEW 907 908 909 910 911 912)
		(SetFlag 40)
		(super init:)
		(SetMenu 773 112 0)
		(= local1 gSpeed)
		(= local0
			(cond
				((proc0_24) 1)
				((proc0_24 1) 3)
				((proc0_24 0) 6)
			)
		)
		(HandsOff)
		(SL disable: state: 0)
		(MenuBar hide: state: 1)
		(SetCursor gTheCursor 0)
		(localproc_0)
		(self setScript: closingCredits)
	)
)

(instance closingCredits of Script
	(properties)

	(method (handleEvent event &tmp temp0)
		(super handleEvent: event)
		(if (== (event type:) evKEYBOARD)
			(switch (event message:)
				(KEY_F2
					(if (GetMenu 1282 113)
						(DoSound sndSET_SOUND 0)
						(SetMenu 1282 113 0 110 {Turn on})
					else
						(DoSound sndSET_SOUND 1)
						(SetMenu 1282 113 1 110 {Turn off})
					)
				)
				($0016
					(= temp0
						((Gauge new:)
							description:
								{Use the mouse or right and left arrow keys to set the sound volume.}
							text: {Sound Volume}
							minimum: 0
							normal: 12
							maximum: 15
							higher: {Louder}
							lower: {Softer}
							doit: (DoSound sndMASTER_VOLUME)
						)
					)
					(DoSound sndMASTER_VOLUME temp0)
					(DisposeScript 987)
				)
				(KEY_F7
					(SetCursor gTheCursor 1)
					(gGame restore:)
				)
				(KEY_F9
					(if
						(Print ; "Shall we really begin the adventure from the very beginning?"
							85
							0
							#title
							{Restart}
							#font
							0
							#icon
							movingIcon
							#button
							{Restart}
							1
							#button
							{Oops}
							0
						)
						(gGame restart:)
					)
				)
				(KEY_CONTROL
					(= gQuit
						(Print ; "Dost thou truly wish to cease our adventuring?"
							85
							1
							#title
							{Quit}
							#font
							0
							#icon
							movingIcon
							#button
							{Quit}
							1
							#button
							{Oops}
							0
						)
					)
				)
				(else
					(event claimed: 1)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= gSpeed 0)
				(if (not script)
					(self setScript: endSongScript)
				)
				(animators
					posn: 156 48
					yStep: local0
					setMotion: MoveTo 156 65
					init:
				)
				(JEFFCROWE
					posn: 158 170
					yStep: local0
					setMotion: MoveTo 158 64
					init:
				)
				(CHERILOYD
					posn: 157 182
					yStep: local0
					setMotion: MoveTo 157 64 self
					init:
				)
			)
			(1
				(JEFFCROWE dispose:)
				(CHERILOYD dispose:)
				(animators setMotion: MoveTo 156 48 self)
			)
			(2
				(animators dispose:)
				(backgroundArtists
					posn: 158 48
					yStep: local0
					setMotion: MoveTo 158 65
					init:
				)
				(CINDYWALKER
					posn: 158 170
					yStep: local0
					setMotion: MoveTo 158 64
					init:
				)
				(JEFFCROWE2
					posn: 157 182
					yStep: local0
					setMotion: MoveTo 157 64
					init:
				)
				(JENNIFER
					posn: 156 194
					yStep: local0
					setMotion: MoveTo 156 64 self
					init:
				)
			)
			(3
				(JENNIFER dispose:)
				(JEFFCROWE2 dispose:)
				(CINDYWALKER dispose:)
				(backgroundArtists setMotion: MoveTo 158 48 self)
			)
			(4
				(backgroundArtists dispose:)
				(programmers
					posn: 159 48
					yStep: local0
					setMotion: MoveTo 159 65
					init:
				)
				(GARYK
					posn: 160 170
					yStep: local0
					setMotion: MoveTo 160 64
					init:
				)
				(RANDY
					posn: 159 182
					yStep: local0
					setMotion: MoveTo 159 64
					init:
				)
				(MARKWILDEN
					posn: 159 194
					yStep: local0
					setMotion: MoveTo 159 64 self
					init:
				)
			)
			(5
				(MARKWILDEN dispose:)
				(RANDY dispose:)
				(GARYK dispose:)
				(programmers setMotion: MoveTo 159 48 self)
			)
			(6
				(programmers dispose:)
				(development
					posn: 158 48
					yStep: local0
					setMotion: MoveTo 158 65
					init:
				)
				(SET1
					posn: 156 194
					yStep: local0
					setMotion: MoveTo 156 64
					init:
				)
				(SET2
					posn: 155 227
					yStep: local0
					setMotion: MoveTo 155 64
					init:
				)
				(SET3
					posn: 156 260
					yStep: local0
					setMotion: MoveTo 156 64
					init:
				)
				(MARKHOOD
					posn: 154 272
					yStep: local0
					setMotion: MoveTo 154 64
					init:
				)
				(ERICHART
					posn: 156 284
					yStep: local0
					setMotion: MoveTo 156 64 self
					init:
				)
			)
			(7
				(ERICHART dispose:)
				(MARKHOOD dispose:)
				(SET3 dispose:)
				(SET2 dispose:)
				(SET1 dispose:)
				(development setMotion: MoveTo 158 48 self)
			)
			(8
				(development dispose:)
				(soundEffects
					posn: 161 48
					yStep: local0
					setMotion: MoveTo 161 65
					init:
				)
				(KENALLEN2
					posn: 160 170
					yStep: local0
					setMotion: MoveTo 160 64 self
					init:
				)
			)
			(9
				(KENALLEN2 dispose:)
				(soundEffects setMotion: MoveTo 161 48 self)
			)
			(10
				(soundEffects dispose:)
				(amigaConversion
					posn: 161 48
					yStep: local0
					setMotion: MoveTo 161 65
					init:
				)
				(STEVEC
					posn: 160 170
					yStep: local0
					setMotion: MoveTo 160 64
					init:
				)
				(RANDY
					posn: 159 182
					yStep: local0
					setMotion: MoveTo 159 64
					init:
				)
				(JOHNRETTIG
					posn: 159 194
					yStep: local0
					setMotion: MoveTo 159 64 self
					init:
				)
			)
			(11
				(STEVEC dispose:)
				(RANDY dispose:)
				(JOHNRETTIG dispose:)
				(amigaConversion setMotion: MoveTo 161 48 self)
			)
			(12
				(amigaConversion dispose:)
				(ELLEN
					posn: 160 180
					yStep: local0
					setMotion: MoveTo 160 48 self
					init:
				)
			)
			(13
				(ELLEN dispose:)
				(self changeState: 0)
			)
		)
	)
)

(instance endSongScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local2
					(self changeState: local2)
				else
					(= cycles 1)
				)
			)
			(1
				(if (== local2 1)
					(if (== ((ScriptID 0 23) prevSignal:) -1) ; backSound
						(= local2 2)
						((ScriptID 0 23) number: 102 loop: 1 playBed: self) ; backSound
					else
						(= cycles 1)
					)
				else
					(= cycles 1)
				)
			)
			(2
				(if (== local2 2)
					(if (== ((ScriptID 0 23) prevSignal:) -1) ; backSound
						(= local2 1)
						((ScriptID 0 23) number: 103 loop: 1 playBed: self) ; backSound
					else
						(= cycles 1)
					)
				else
					(= cycles 1)
				)
			)
			(3
				(self changeState: local2)
			)
		)
	)
)

(instance animators of Actor
	(properties
		view 907
		signal 30720
	)
)

(instance JEFFCROWE of Actor
	(properties
		view 907
		loop 1
		priority 1
		signal 30736
	)
)

(instance CHERILOYD of Actor
	(properties
		view 907
		loop 2
		priority 1
		signal 30736
	)
)

(instance backgroundArtists of Actor
	(properties
		view 908
		signal 30720
	)
)

(instance CINDYWALKER of Actor
	(properties
		view 908
		loop 1
		priority 1
		signal 30736
	)
)

(instance JEFFCROWE2 of Actor
	(properties
		view 908
		loop 2
		priority 1
		signal 30736
	)
)

(instance JENNIFER of Actor
	(properties
		view 908
		loop 3
		priority 1
		signal 30736
	)
)

(instance programmers of Actor
	(properties
		view 909
		signal 30720
	)
)

(instance GARYK of Actor
	(properties
		view 909
		loop 1
		priority 1
		signal 30736
	)
)

(instance RANDY of Actor
	(properties
		view 909
		loop 2
		priority 1
		signal 30736
	)
)

(instance MARKWILDEN of Actor
	(properties
		view 909
		loop 3
		priority 1
		signal 30736
	)
)

(instance development of Actor
	(properties
		view 910
		signal 30720
	)
)

(instance SET1 of Actor
	(properties
		view 910
		loop 1
		priority 1
		signal 30736
	)
)

(instance SET2 of Actor
	(properties
		view 910
		loop 2
		priority 1
		signal 30736
	)
)

(instance SET3 of Actor
	(properties
		view 910
		loop 3
		priority 1
		signal 30736
	)
)

(instance MARKHOOD of Actor
	(properties
		view 910
		loop 4
		priority 1
		signal 30736
	)
)

(instance ERICHART of Actor
	(properties
		view 910
		loop 5
		priority 1
		signal 30736
	)
)

(instance soundEffects of Actor
	(properties
		view 911
		signal 30720
	)
)

(instance KENALLEN2 of Actor
	(properties
		view 911
		loop 1
		priority 1
		signal 30736
	)
)

(instance ELLEN of Actor
	(properties
		view 912
		signal 30720
	)
)

(instance amigaConversion of Actor
	(properties
		view 914
		signal 30720
	)
)

(instance STEVEC of Actor
	(properties
		view 914
		loop 1
		priority 1
		signal 30736
	)
)

(instance JOHNRETTIG of Actor
	(properties
		view 914
		loop 2
		priority 1
		signal 30736
	)
)

(instance movingIcon of DCIcon
	(properties
		view 699
		loop 2
	)

	(method (init)
		(super init:)
		(self cycleSpeed: (if (> global101 2) 10 else 6))
	)
)

