;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 84)
(include sci.sh)
(use Main)
(use LoadMany)
(use Gauge)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	openCredits 0
)

(local
	local0
	local1
	local2
)

(instance openCredits of Rm
	(properties
		picture 900
		style 7
	)

	(method (init)
		(HandsOff)
		(LoadMany rsVIEW 901 902 903 904 905 906)
		(Load rsSOUND 1)
		(super init:)
		(= local2 gSpeed)
		(= local1
			(cond
				((proc0_24) 1)
				((proc0_24 1) 3)
				((proc0_24 0) 6)
			)
		)
		((ScriptID 0 23) prevSignal: 0) ; backSound
		(SL disable: state: 0)
		(SetCursor gTheCursor 0)
		(MenuBar hide: state: 0)
		(self setScript: openingCredits)
	)
)

(instance openingCredits of Script
	(properties)

	(method (handleEvent event &tmp temp0)
		(super handleEvent: event)
		(if (== (event message:) KEY_RETURN)
			((ScriptID 0 23) fade:) ; backSound
			(gGame setSpeed: local2)
			(gCurRoom newRoom: 86) ; titleScreen
			(event claimed: 1)
		)
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
				((ScriptID 0 23) number: 1 loop: 1 playBed:) ; backSound
				(= cycles 1)
			)
			(1
				(titleCredit
					view: 901
					loop: 0
					cel: 0
					posn: 157 195
					ignoreHorizon:
					ignoreActors:
					yStep: local1
					illegalBits: 0
					init:
					setMotion: MoveTo 157 50
				)
				(nameCredit
					view: 901
					loop: 1
					cel: 0
					posn: 158 240
					ignoreHorizon:
					ignoreActors:
					yStep: local1
					illegalBits: 0
					init:
					setMotion: MoveTo 158 50 self
				)
			)
			(2
				(titleCredit view: 902 posn: 157 195 setMotion: MoveTo 157 50)
				(nameCredit
					view: 902
					posn: 158 240
					setMotion: MoveTo 158 50 self
				)
			)
			(3
				(titleCredit view: 903 posn: 159 195 setMotion: MoveTo 159 50)
				(nameCredit
					view: 903
					posn: 158 240
					setMotion: MoveTo 158 50 self
				)
			)
			(4
				(titleCredit view: 904 posn: 161 195 setMotion: MoveTo 161 50)
				(nameCredit
					view: 904
					posn: 160 240
					setMotion: MoveTo 160 50 self
				)
			)
			(5
				(titleCredit view: 905 posn: 159 195 setMotion: MoveTo 159 50)
				(nameCredit
					view: 905
					posn: 159 220
					setMotion: MoveTo 159 50 self
				)
			)
			(6
				(titleCredit view: 906 posn: 158 195 setMotion: MoveTo 158 50)
				(nameCredit
					view: 906
					posn: 159 220
					setMotion: MoveTo 159 50 self
				)
			)
			(7
				(if (== ((ScriptID 0 23) prevSignal:) 10) ; backSound
					(= cycles 1)
				else
					(titleCredit dispose:)
					(nameCredit dispose:)
					((ScriptID 0 23) loop: 1 fade:) ; backSound
					(= cycles 5)
				)
			)
			(8
				(gGame setSpeed: local2)
				(gCurRoom newRoom: 86) ; titleScreen
				(self dispose:)
			)
		)
	)
)

(instance titleCredit of Actor
	(properties)
)

(instance nameCredit of Actor
	(properties)
)

