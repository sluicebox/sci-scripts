;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 62999)
(include sci.sh)
(use Main)
(use n63002)
(use ControlPanel)
(use Plane)
(use Room)
(use PolyEdit)
(use System)

(public
	p2IntroRm 0
)

(instance p2IntroRm of Room
	(properties
		picture 8000
		style 0
	)

	(method (init &tmp [temp0 2])
		(gP2SongPlyr stop:)
		(gRoboGary stop:)
		(gP2SoundFX stop:)
		((ScriptID 0 2) hide:) ; topInterfacePlane
		(FrameOut)
		(Palette 2 0 31 100) ; PalIntensity
		(gTheCursor hide:)
		((= plane (Plane new: 1 0 640 479)) init: setPri: 4000)
		(gPlanes plane: plane)
		(if (not gPrevRoomNum)
			(PlayDuck 2 1) ; DoFrameOut
			(PlayDuck 1 4 1 0 71 (Max global400 512)) ; Play
		)
		(gP2SongPlyr fadeIn: 10120 100)
		(super init: &rest)
		((ScriptID 0 2) show:) ; topInterfacePlane
		(gTheCursor show:)
		(introButn new: startNew 0 122 161)
		(introButn new: loadOld 1 122 207)
		(introButn new: watchIntro 2 122 257)
		(introButn new: quitCode 3 122 307)
		(gGame handsOn:)
	)

	(method (dispose)
		((plane cast:) delete: self)
		(plane dispose:)
		(gPlanes plane: (= plane 0))
		(super dispose: &rest)
	)
)

(instance introButn of View
	(properties
		view 8000
	)

	(method (new &tmp temp0)
		(= temp0 (super new:))
		(temp0 init: &rest)
	)

	(method (init param1 param2)
		(|= signal $1000)
		(= loop param2)
		(super init: (gCurRoom plane:))
		(self posn: &rest)
		(= responder param1)
		(self update:)
		(self setRect:)
		(self hide:)
	)

	(method (handleEvent event)
		(if (& signal $0008)
			(if (& (event type:) evMOUSEBUTTON)
				(self show:)
				((gUser hogs:) push: self 1)
				(event claimed: self)
			)
		else
			(event localize: plane)
			(if (& (event type:) evMOUSERELEASE)
				((gUser hogs:) pop:)
				(if (self onMe: event)
					(gP2SoundFX play: 62999)
					(SendMany new: responder 9)
				)
				(self hide:)
			)
		)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 2)
			(= temp0 param1)
			(= temp1 param2)
		else
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		)
		(return (and (<= left temp0 right) (<= top temp1 bottom)))
	)

	(method (setRect)
		(super setRect: &rest)
		(super setRect: left top (+ left (- bottom top)) bottom)
	)
)

(instance startNew of Code
	(properties)

	(method (doit)
		(= global207 0)
		(if (== ((ScriptID 0 5) new: 1) 1) ; IntensityPassWordWindow
			(gP2SongPlyr fadeOut: 0)
			(gGame getDisc: 1)
			(= gChapter 1)
			((ScriptID 63020) doit:) ; networkInitCode
			(gCurRoom drawPic: -1)
			(proc63002_7 1)
			(gCurRoom newRoom: 2011) ; bedRoomCH1SR1
		)
	)
)

(instance loadOld of Code
	(properties)

	(method (doit)
		(Palette 2 0 31 100) ; PalIntensity
		(gGame panelSend: ControlPanel 5)
	)
)

(instance watchIntro of Code
	(properties)

	(method (doit)
		(gGame getDisc: 1)
		(gCurRoom drawPic: -1)
		(= global211 1)
		(proc63002_7 1)
		(gTheCursor set: 999 1 0)
		(gCurRoom drawPic: 8000)
	)
)

(instance quitCode of Code
	(properties)

	(method (doit)
		(= gQuit 3)
	)
)

