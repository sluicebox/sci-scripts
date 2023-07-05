;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63004)
(include sci.sh)
(use Main)
(use P2ScrollBar)
(use AboutPlane)
(use Credits)
(use HelpPlane)
(use Plane)
(use Str)
(use BorderWindow)
(use PolyEdit)
(use TextField)
(use Button)
(use User)
(use System)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10 = 30
	local11 = 30
	local12
)

(instance optionsD of HotPlane
	(properties
		picture -2
	)

	(method (new &tmp temp0)
		(= temp0 (super new: &rest))
		(temp0
			priority: (+ 1 (GetHighPlanePri))
			init: 132 83 500 310
			needsDoits: 1
		)
		(optionBack init: temp0)
		(global250 subPlane: temp0)
		(return temp0)
	)

	(method (init &tmp temp0 temp1)
		(= temp0 global235)
		(= temp1 global236)
		(super init: &rest)
		(= local5 (P2ScrollBar new: foo1 127 20 4031 88 96 1 self))
		(= local6 (P2ScrollBar new: foo2 127 20 4031 88 163 1 self))
		(local5 move: temp0 1)
		(local6 move: temp1 1)
	)

	(method (handleEvent event)
		(event localize: self)
		(super handleEvent: event)
	)

	(method (dispose)
		(local5 dispose:)
		(local6 dispose:)
		(super dispose: &rest)
	)
)

(instance optionBack of View
	(properties
		view 4031
		loop 6
	)
)

(instance foo1 of Script
	(properties)

	(method (cue param1)
		(= gLastVolume param1)
		(= global235 param1)
	)
)

(instance foo2 of Script
	(properties)

	(method (cue param1)
		(= gLastVolume param1)
		(= global236 param1)
		(gSounds eachElementDo: #setVol global236)
	)
)

(instance helpD of HelpPlane
	(properties)
)

(instance helpBack of View ; UNUSED
	(properties
		view 4034
		loop 4
	)
)

(instance creditsD of Credits
	(properties
		picture -2
	)

	(method (new &tmp temp0)
		(= temp0 (Clone self))
		(temp0 init: priority: (+ 1 (GetHighPlanePri)) needsDoits: 1)
		(global250 subPlane: temp0)
		(return temp0)
	)
)

(instance aboutD of HotPlane
	(properties
		picture -2
	)

	(method (new &tmp temp0)
		(= temp0 (Clone self))
		(temp0
			priority: (+ 1 (GetHighPlanePri))
			init: 132 83 500 310
			needsDoits: 1
		)
		(aboutBack init: temp0)
		(global250 subPlane: temp0)
		(return temp0)
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(aboutSalesButn init: self)
		(aboutTechButn init: self)
		(aboutCustButn init: self)
		((= temp0 (TextField new:)) fore: 32)
		((TextView new:)
			text: temp0
			setText: (Str format: {Version: %s} gVersion)
			setSize:
			posn: 255 214
			init: self
		)
	)

	(method (handleEvent event &tmp temp0)
		(event localize: self)
		(if local3
			(if (aboutMainButn onMe: event)
				(aboutMainButn handleEvent: event)
			else
				(aboutPlane handleEvent: event)
			)
		else
			(cast handleEvent: event)
		)
	)

	(method (dispose)
		(if local3
			(aboutPlane dispose:)
			(= local3 0)
		)
		(super dispose: &rest)
	)
)

(instance aboutBack of View
	(properties
		view 4036
		loop 8
	)
)

(class AboutButton of Button
	(properties
		x 100
		view 4036
		modNum 2038
	)

	(method (action)
		(= local3 1)
		(aboutMainButn init: plane)
		(aboutPlane init: modNum)
		(= cel 0)
	)

	(method (handleEvent event)
		(cond
			((not (not (& state $0020)))
				(event localize: plane)
				(self track: event)
				(if (& evMOUSERELEASE (event type:))
					(self press: 0)
					((gUser hogs:) pop:)
					(self action:)
				)
				(FrameOut)
			)
			((& evMOUSEBUTTON (event type:))
				(self press: 1)
				((gUser hogs:) push: self 1)
			)
		)
		(event claimed: self)
		(event claimed:)
	)
)

(instance aboutPlane of AboutPlane
	(properties)
)

(instance aboutSalesButn of AboutButton
	(properties
		y 48
		loop 4
		modNum 2037
	)
)

(instance aboutTechButn of AboutButton
	(properties
		y 98
		loop 5
	)
)

(instance aboutCustButn of AboutButton
	(properties
		y 146
		loop 6
		modNum 2039
	)
)

(instance aboutMainButn of Button
	(properties
		x 62
		y 190
		view 4036
		loop 7
	)

	(method (action)
		(= local3 0)
		(aboutPlane dispose:)
		(= cel 0)
		(self dispose:)
	)

	(method (handleEvent event)
		(cond
			((not (not (& state $0020)))
				(event localize: plane)
				(self track: event)
				(if (& evMOUSERELEASE (event type:))
					(self press: 0)
					((gUser hogs:) pop:)
					(self action:)
				)
				(FrameOut)
			)
			((& evMOUSEBUTTON (event type:))
				(self press: 1)
				((gUser hogs:) push: self 1)
			)
		)
		(event claimed: self)
		(event claimed:)
	)
)

(class ControlPanel of HotPlane
	(properties
		picture -2
		subHog 0
		delayScratch 0
		doSave 0
		doRestore 0
		subPlane 0
	)

	(method (new)
		(= local3 0)
		(= local4 0)
		(= local7 0)
		(= local8 (OneOf gCurRoomNum 62999 999)) ; p2IntroRm, poorSadDeadCrazyAlienSucker
		(= local9 0)
		(= local10 30)
		(= local11 30)
		(= local12 0)
		(= doSave 0)
		(= doRestore (OneOf gCurRoomNum 62999 999)) ; p2IntroRm, poorSadDeadCrazyAlienSucker
		(= delayScratch 0)
		(= local0 global236)
		(= local1 global235)
		(= local2 global251)
		(if local4
			(return 0)
		else
			((controlHelpText new:) init:)
			(self needsDoits: 1)
			((ScriptID 0 1) normalize:) ; p2Cursor
			(= local4 1)
			(= global250 (Clone self))
			(global250
				priority: (+ 1 (GetHighPlanePri))
				init: 0 70 640 406
				add:
					optionsButton
					saveButton
					loadButton
					continueButton
					helpButton
					creditsButton
					aboutButton
					cancelButton
					quitButton
			)
			(if (OneOf gCurRoomNum 62999 999) ; p2IntroRm, poorSadDeadCrazyAlienSucker
				(extraBack init:)
			)
			(backGround init: global250)
			(loadButton init: global250)
			(optionsButton init: global250)
			(saveButton init: global250)
			(helpButton init: global250)
			(creditsButton init: global250)
			(aboutButton init: global250)
			(continueButton init: global250)
			(cancelButton init: global250)
			(quitButton init: global250)
			(= gVerb 4) ; Do
			(gTheCursor set: 999 1 0)
			(FrameOut)
			((gUser hogs:) push: global250 1)
		)
	)

	(method (dispose)
		(if local9
			(local9 dispose:)
			(= local9 0)
		)
		(if (OneOf gCurRoomNum 62999 999) ; p2IntroRm, poorSadDeadCrazyAlienSucker
			(extraBack dispose:)
		)
		((gUser hogs:) pop:)
		(= local4 0)
		(super dispose: &rest)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(super doit: &rest)
		(cond
			(subHog
				(= temp2 (Clone Event))
				(repeat
					(breakif (not subHog))
					(= temp0 gMouseX)
					(= temp1 gMouseY)
					(temp2 new:)
					(= gMouseX (temp2 x:))
					(= gMouseY (temp2 y:))
					(gUser
						mouseMoved: (or (!= temp0 gMouseX) (!= temp1 gMouseY))
					)
					(subHog handleEvent: temp2)
					(breakif (or doSave doRestore))
					(if (not (temp2 claimed:))
						(self handleEvent: temp2)
					)
				)
				(temp2 dispose:)
				(= subHog (= local7 (= local8 0)))
				(= scratch delayScratch)
			)
			(subPlane
				(subPlane doit:)
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (not subHog)
			(self doit:)
		)
		(if subPlane
			(subPlane handleEvent: event)
		)
		(event localize: self)
		(if (!= 0 (= temp0 (cast firstTrue: #onMe event)))
			(if (& (event type:) evMOUSEBUTTON)
				(if subPlane
					(subPlane dispose:)
					(= subPlane 0)
				)
				(optionsButton cel: 0)
				(saveButton cel: 0)
				(loadButton cel: 0)
				(helpButton cel: 0)
				(creditsButton cel: 0)
				(aboutButton cel: 0)
				(temp0 trip:)
				(cast eachElementDo: #update)
				(UpdatePlane global250)
				(if
					(and
						subHog
						(!= temp0 continueButton)
						(!= temp0 cancelButton)
					)
					(subHog number: -1 done:)
					(return)
				)
			else
				(local9 show: temp0)
			)
		else
			(local9 hide:)
			(if subPlane
				(subPlane handleEvent: event)
			)
		)
		(cond
			(scratch
				(if subHog
					(subHog number: -1 done:)
				else
					(= scratch 0)
					(self dispose:)
				)
			)
			(subHog
				(return)
			)
			(doSave
				(= delayScratch 1)
				(= doSave (= local8 0))
				(gGame save:)
			)
			(doRestore
				(= delayScratch 1)
				(= doRestore (= local7 0))
				(gGame restore:)
			)
		)
		(event claimed: 1 globalize:)
		(FrameOut)
	)
)

(instance controlHelpText of TextView
	(properties)

	(method (init &tmp temp0)
		(= local9 self)
		((= temp0 (chPlane new:)) init: 0 0 639 479)
		(temp0 setPri: (+ 1 (GetHighPlanePri)))
		(temp0 update:)
		(= local11 local10)
		(self setText: {[]})
		(self setSize:)
		(super init: temp0)
		(self hide:)
	)

	(method (show param1 &tmp temp0 temp1 temp2)
		(if
			(not
				(OneOf
					param1
					optionsButton
					saveButton
					loadButton
					helpButton
					creditsButton
					aboutButton
				)
			)
			(self hide:)
			(return)
		)
		(= temp2 local12)
		(cond
			((and responder (!= param1 responder))
				(self hide:)
			)
			((& signal $0008)
				(= responder param1)
				(if (and (!= temp2 (= local12 (GetTime))) (not (-- local11)))
					(text dispose:)
					(= text 0)
					(= celWidth (= celHeight -1))
					(self setText: param1)
					(self setSize:)
					(self draw:)
					(= temp0 (- gMouseX (/ celWidth 2)))
					(= temp1
						(+
							gMouseY
							(-
								(CelHigh
									(gTheCursor view:)
									(gTheCursor loop:)
									(gTheCursor cel:)
								)
								(CelInfo
									1 ; GetOrigY
									(gTheCursor view:)
									(gTheCursor loop:)
									(gTheCursor cel:)
								)
							)
							1
						)
					)
					(self
						posn:
							(Max
								0
								(Min (- 639 (/ celWidth 2)) temp0)
							)
							(Max
								0
								(Min (- 479 celHeight) temp1)
							)
					)
					(super show:)
					(self update:)
					(plane setPri: 0)
					(plane setPri: (+ 1 (GetHighPlanePri)))
					(plane update:)
				)
			)
			(else 0)
		)
	)

	(method (hide)
		(if (not (& signal $0008))
			(super hide:)
			(plane update:)
		)
		(if responder
			(= responder 0)
			(= local11 local10)
		)
	)

	(method (setText param1)
		(super
			setText:
				0
				1
				0
				(switch param1
					(optionsButton 8)
					(saveButton 9)
					(loadButton 10)
					(helpButton 11)
					(creditsButton 12)
					(aboutButton 13)
				)
				1
		)
	)

	(method (dispose &tmp temp0)
		(= responder 0)
		(= temp0 plane)
		(super dispose:)
		(temp0 dispose:)
		(= local9 0)
	)
)

(instance chPlane of Plane
	(properties
		picture -2
	)

	(method (onMe)
		(return 0)
	)
)

(class ControlButton of View
	(properties)

	(method (trip)
		(= cel 1)
	)

	(method (onMe param1)
		(return (IsOnMe (param1 x:) (param1 y:) self 1))
	)
)

(instance backGround of View
	(properties
		x 1
		y 1
		view 4030
		cel 1
	)

	(method (init)
		(super init: &rest)
		(gSaveFileSelText set: 999 0 0)
	)

	(method (onMe)
		(return 0)
	)
)

(instance optionsButton of ControlButton
	(properties
		x 69
		y 14
		view 4030
		loop 1
	)

	(method (trip)
		(global250 delayScratch: 0)
		(= cel 1)
		(optionsD new:)
	)
)

(instance saveButton of ControlButton
	(properties
		x 69
		y 76
		view 4030
		loop 2
	)

	(method (trip)
		(if local7
			(return)
		)
		(global250 delayScratch: 0)
		(= local7 1)
		(= cel 1)
		(UpdateScreenItem self)
		(FrameOut)
		(global250 doSave: 1)
	)
)

(instance loadButton of ControlButton
	(properties
		x 69
		y 138
		view 4030
		loop 3
	)

	(method (trip)
		(if local8
			(return)
		)
		(global250 delayScratch: 0)
		(= local8 1)
		(= cel 1)
		(UpdateScreenItem self)
		(FrameOut)
		(global250 doRestore: 1)
	)
)

(instance continueButton of ControlButton
	(properties
		x 69
		y 250
		view 4030
		loop 4
	)

	(method (trip)
		(= cel 1)
		(self update:)
		(FrameOut)
		(global250 scratch: 1)
	)
)

(instance helpButton of ControlButton
	(properties
		x 518
		y 14
		view 4030
		loop 5
	)

	(method (trip)
		(global250 delayScratch: 0)
		(= cel 1)
		(helpD init: global250)
	)
)

(instance creditsButton of ControlButton
	(properties
		x 518
		y 76
		view 4030
		loop 6
	)

	(method (trip)
		(global250 delayScratch: 0)
		(= cel 1)
		(creditsD new:)
	)
)

(instance aboutButton of ControlButton
	(properties
		x 518
		y 138
		view 4030
		loop 7
	)

	(method (trip)
		(global250 delayScratch: 0)
		(= cel 1)
		(aboutD new:)
	)
)

(instance cancelButton of ControlButton
	(properties
		x 518
		y 250
		view 4030
		loop 8
	)

	(method (trip)
		(= global236 local0)
		(= global235 local1)
		(= global251 local2)
		(= cel 1)
		(self update:)
		(FrameOut)
		(global250 scratch: 1)
	)
)

(instance quitButton of ControlButton
	(properties
		x 279
		y 250
		view 4030
		loop 9
	)

	(method (trip)
		(= cel 1)
		(self update:)
		(FrameOut)
		(= gQuit 1)
		(global250 scratch: 1)
	)
)

(instance extraBack of View
	(properties
		y -2
		view 4033
		loop 7
	)

	(method (init)
		(super init: (gCurRoom plane:))
		(self setPri: 1)
		(UpdateScreenItem self)
		(UpdatePlane plane)
		(FrameOut)
	)
)

