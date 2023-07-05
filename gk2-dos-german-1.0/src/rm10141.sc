;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10141)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm10141 0
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 100)) (> temp0 0) ((-= temp0 1))
		(Palette 2 16 256 temp0) ; PalIntensity
		(FrameOut)
	)
)

(procedure (localproc_1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 100) ((+= temp0 1))
		(Palette 2 16 256 temp0) ; PalIntensity
		(FrameOut)
	)
)

(instance rm10141 of ExitRoom
	(properties
		modNum 1010
		picture 10141
		east 10102 ; rm10102
		south 10102 ; rm10102
		west 10102 ; rm10102
	)

	(method (cue)
		(gSoundManager stop:)
	)

	(method (init)
		(self setRegions: 1030) ; dressRegion
		(super init: &rest)
		(urn init:)
	)

	(method (notify)
		(ClearFlag 724)
		(ClearFlag 721)
		(SetFlag 730)
		(gCurRoom newRoom: 10102)
	)
)

(instance vText of Prop
	(properties
		x 102
		y 253
		view 818
	)
)

(instance sTheaterTransition of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSoundManager fade: 0 10 10 1 gCurRoom)
				(gCurRoom picture: -1)
				(PlayScene 807 0 -1)
				(gGk2Sound fade: 0 5 5 1)
				(Lock 140 10103 0) ; WAVE
				(PlayScene 808 self)
			)
			(1
				(gGame handsOff:)
				(localproc_0)
				(= cycles 1)
			)
			(2
				(gGame handsOff:)
				(gCurRoom drawPic: 818)
				(= cycles 10)
			)
			(3
				(localproc_1)
				(= cycles 1)
			)
			(4
				(= ticks 60)
			)
			(5
				(vText init: setCycle: End self)
			)
			(6
				(= seconds 4)
			)
			(7
				(vText dispose:)
				(= ticks 60)
			)
			(8
				(localproc_0)
				(= cycles 1)
			)
			(9
				(gCurRoom drawPic: -1)
				(= cycles 10)
			)
			(10
				(SetFlag 735)
				(gCurRoom newRoom: 1100) ; foyerRm
				(self dispose:)
			)
		)
	)
)

(instance urn of GKFeature
	(properties
		x 172
		y 226
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 223 140 223 313 121 313 121 140
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				((ScriptID 1030 1) dispose: delete:) ; engelTimer
				(gCurRoom setScript: sTheaterTransition)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

