;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20230)
(include sci.sh)
(use Main)
(use n1111)
(use Scaler)
(use Actor)
(use System)

(public
	rm20230 0
)

(instance rm20230 of ScaryRoom
	(properties
		picture 20230
		stepSound 4
	)

	(method (init)
		(= global115 0)
		(if (and (< 2 gChapter 7) (not (IsFlag 25)))
			(gGDacSound setVol: 40)
		)
		(Load rsSOUND 20000)
		(global114 play: 20000)
		(gEgo
			view: 2
			loop: 0
			cel: 0
			posn: 88 142
			init:
			normalize:
			hide:
			setScaler: Scaler 200 76 147 64
			z: 1000
		)
		(if (not (IsFlag 27))
			(gGame setIntensity: 60)
		else
			(gGame setIntensity: 100)
		)
		(Load rsVIEW 20230)
		(Lock rsVIEW 20230 1)
		(lantern view: 20230 init: setScaler: Scaler 1 163 74 73 x: 163 y: 72)
		(gCurRoom setScript: sCellar1stX)
		(super init:)
	)
)

(instance lantern of Prop
	(properties)
)

(instance sCellar1stX of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load 140 20010) ; WAVE
					(if (gEgo has: 8) ; invMatch
						(gEgo put: 8) ; invMatch
					)
					(if (not (IsFlag 27))
						(proc1111_7 543 50 28)
					else
						(++ state)
						(self cue:)
					)
				)
				(1
					(gGame setIntensity: (Random 40 50))
				)
				(2
					(gGame setIntensity: (Random 30 40))
				)
				(3
					(gGame setIntensity: (Random 20 30))
				)
				(4
					(gGame setIntensity: (Random 10 20))
					(global114 stop:)
					(gGDacSound number: 20010 setLoop: 1 play:)
				)
				(5
					(if (not (IsFlag 27))
						(gCurRoom drawPic: 20240 picture: 20240)
						(lantern dispose:)
						(proc1111_7 542 16 -13 gEgo -1 1)
					else
						(self dispose:)
					)
				)
				(6
					(gGame setIntensity: (Random 40 70))
				)
				(7
					(gGame setIntensity: (Random 40 70))
				)
				(8
					(gGame setIntensity: (Random 40 70))
				)
				(9
					(gGame setIntensity: (Random 40 70))
				)
				(10
					(global114 play: 20000)
					(gGame setIntensity: 60)
				)
				(11
					(gGame setIntensity: 90)
				)
				(12
					(gGame setIntensity: 70)
				)
				(13
					(gGame setIntensity: 80)
				)
				(14
					(gGame setIntensity: 85)
				)
				(15
					(gGame setIntensity: 90)
				)
				(16
					(gGame setIntensity: 80)
				)
				(17
					(gGame setIntensity: 100)
				)
				(18
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(if global115
			(proc1111_6)
			(= global115 0)
		)
		(gGame setIntensity: 100)
		(Lock rsVIEW 20230 0)
		(global114 stop:)
		(gGDacSound stop:)
		(if (gEgo has: 8) ; invMatch
			(gEgo put: 8) ; invMatch
		)
		(gCurRoom newRoom: 20100)
		(super dispose: &rest)
	)
)

