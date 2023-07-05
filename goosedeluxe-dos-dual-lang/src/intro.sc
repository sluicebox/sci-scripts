;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 90)
(include sci.sh)
(use Main)
(use Plane)
(use Str)
(use Array)
(use Print)
(use Game)
(use System)

(public
	intro 0
)

(local
	local0
	[local1 2]
)

(instance intro of Room
	(properties
		picture 501
	)

	(method (init &tmp temp0 temp1)
		(super init:)
		(= global511 introButtonBar)
		(global511 init:)
		(creditsButton init:)
		(newGameButton init:)
		(oldGameButton init:)
		(gKeyDownHandler addToFront: self)
		(= temp0 (IntArray new: 13))
		(= temp1 (Str new: 12))
		(= local0 (Save 5 (gGame name:) (temp1 data:) (temp0 data:))) ; GetSaveFiles
		(temp0 dispose:)
		(temp1 dispose:)
		(languageButton init:)
		(quitButton init:)
		(gGame masterVolume: 15)
		(if (or (== gPrevRoomNum 108) (== gPrevRoomNum 94)) ; morning
			(gLongSong number: 600 loop: -1 play:)
		)
		(if (not local0)
			(oldGameButton signal: (| (oldGameButton signal:) $0004) show:)
			(global511
				add: creditsButton newGameButton languageButton quitButton
			)
		else
			(global511
				add:
					creditsButton
					newGameButton
					oldGameButton
					languageButton
					quitButton
			)
		)
		(self setScript: sIntro)
	)

	(method (dispose)
		((global511 plane:) dispose:)
		(global511 dispose:)
		(gKeyDownHandler delete: self)
		(= global511 0)
		(super dispose:)
	)

	(method (handleEvent event)
		(event claimed: 1)
	)
)

(instance sIntro of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame setCursor: 6 1)
				(gGame handsOn:)
				(self cue:)
			)
			(1)
			(2
				(= seconds 2)
			)
			(3
				(gCurRoom newRoom: 115) ; pickEgo
			)
		)
	)
)

(instance introButtonBar of MgButtonBar
	(properties)

	(method (checkCursor param1 &tmp temp0)
		(if (!= (param1 plane:) plane)
			(param1 localize: plane)
		)
		(cond
			((= temp0 (self firstTrue: #onMe param1))
				(if (!= gTheCursor 10)
					(gGame setCursor: 10)
				)
			)
			((!= gTheCursor 6)
				(gGame setCursor: 6)
				(= saveCursor 0)
			)
		)
	)

	(method (init)
		(if (not plane)
			(= plane (Plane new:))
		)
		(plane back: 0 priority: 1 init: 0 0 640 480 addCast: self)
		(plane setSize:)
	)
)

(instance creditsButton of MGIconItem
	(properties
		x 2
		y 161
		mainView 181
	)

	(method (init)
		(super init: &rest)
		(self show: x y)
	)

	(method (select)
		(if (super select: 1)
			(gGame handsOff:)
			(gCurRoom newRoom: 118) ; creditRoom
		)
	)

	(method (changeCursor)
		(if (!= gTheCursor 10)
			(gGame setCursor: 10)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (self onMe: event)
			(event claimed: 1)
			(if (== (event type:) evMOUSEBUTTON)
				(gSfx number: 800 play:)
				(self select:)
			)
		)
	)
)

(instance newGameButton of MGIconItem
	(properties
		x 66
		y 161
		mainView 181
		mainLoop 1
	)

	(method (init)
		(super init: &rest)
		(self show: x y)
	)

	(method (select)
		(if (super select: 1)
			(if (>= local0 12)
				(Prints
					{To start a new game, you must complete one of the previously created charaters. Press the "Old Game" button.}
				)
			else
				(gGame handsOff:)
				((gCurRoom script:) state: 1 cue:)
			)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (self onMe: event)
			(event claimed: 1)
			(if (== (event type:) evMOUSEBUTTON)
				(gSfx number: 800 play:)
				(self select:)
			)
		)
	)

	(method (changeCursor)
		(if (!= gTheCursor 10)
			(gGame setCursor: 10)
		)
	)
)

(instance oldGameButton of MGIconItem
	(properties
		x 131
		y 161
		mainView 181
		mainLoop 2
		maskView 181
		maskLoop 2
		maskCel 2
	)

	(method (init)
		(super init: &rest)
		(self show: x y)
	)

	(method (select)
		(if (super select: 1)
			(gGame handsOff:)
			(gCurRoom newRoom: 117) ; restoreRoom
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (self onMe: event)
			(event claimed: 1)
			(if (== (event type:) evMOUSEBUTTON)
				(gSfx number: 800 play:)
				(self select:)
			)
		)
	)

	(method (changeCursor)
		(if (!= gTheCursor 10)
			(gGame setCursor: 10)
		)
	)
)

(instance languageButton of MGIconItem
	(properties
		x 195
		y 161
		mainView 181
		mainLoop 3
	)

	(method (init)
		(super init: &rest)
		(self show: x y)
		(if (== gLanguage 0)
			(SetLanguage {})
		else
			(SetLanguage {spanish})
			(++ loop)
		)
	)

	(method (select)
		(if (super select: 1)
			(if (< loop 4)
				(++ loop)
				(= gLanguage 1)
				(SetLanguage {spanish})
			else
				(= loop 3)
				(= gLanguage 0)
				(SetLanguage {})
			)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (self onMe: event)
			(event claimed: 1)
			(if (== (event type:) evMOUSEBUTTON)
				(gSfx number: 800 play:)
				(self select:)
			)
		)
	)

	(method (changeCursor)
		(if (!= gTheCursor 10)
			(gGame setCursor: 10)
		)
	)
)

(instance quitButton of MGIconItem
	(properties
		x 258
		y 161
		mainView 181
		mainLoop 5
	)

	(method (init)
		(super init: &rest)
		(self show: x y)
	)

	(method (select)
		(if (super select: 1)
			(gCurRoom setScript: outScript)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (self onMe: event)
			(event claimed: 1)
			(if (== (event type:) evMOUSEBUTTON)
				(gSfx number: 801 play:)
				(self select:)
			)
		)
	)

	(method (changeCursor)
		(if (!= gTheCursor 10)
			(gGame setCursor: 10)
		)
	)
)

(instance outScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(= gQuit 1)
			)
		)
	)
)

