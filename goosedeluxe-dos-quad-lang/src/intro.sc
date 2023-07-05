;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 90)
(include sci.sh)
(use Main)
(use Plane)
(use Str)
(use Array)
(use Game)
(use System)

(public
	intro 0
)

(local
	local0
	[local1 2]
	local3
	local4
)

(instance intro of Room
	(properties
		picture 501
	)

	(method (init &tmp [temp0 2])
		(= local4 (Str new: 100))
		(GetConfig {defLang} local4)
		(cond
			((>= (local4 indexOf: 70) 0)
				(= gLanguage 2)
			)
			((>= (local4 indexOf: 77) 0)
				(= gLanguage 3)
			)
			((>= (local4 indexOf: 80) 0)
				(= gLanguage 1)
			)
			(else
				(= gLanguage 0)
			)
		)
		(super init:)
		(gCurRoom drawPic: (+ (* 1000 gLanguage) 501))
		(= local3 0)
		(= global511 introButtonBar)
		(global511 init:)
		(creditsButton init:)
		(newGameButton init:)
		(oldGameButton init:)
		(gKeyDownHandler addToFront: self)
		(setupLanguages doit:)
		(languageButton init:)
		(quitButton init:)
		(gGame masterVolume: 15)
		(if (and global523 (== gPrevRoomNum 108))
			(self setScript: sPlayDemo)
		else
			(if (or (== gPrevRoomNum 0) (== gPrevRoomNum 108) (== gPrevRoomNum 94)) ; morning
				(gLongSong number: 600 loop: -1 play:)
			)
			(if (and global523 (== gPrevRoomNum 119)) ; demoEnd
				(self setScript: sEndDemo)
			else
				(self setScript: sIntro)
			)
		)
	)

	(method (dispose)
		((global511 plane:) dispose:)
		(global511 dispose:)
		(gKeyDownHandler delete: self)
		(= global511 0)
		(= global512 0)
		(= global514 0)
		(local4 dispose:)
		(= local3 0)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (and (gUser canControl:) (== local3 1))
			(proc0_16 (= local4 (Str format: {})))
			(= local3 0)
		)
		(event claimed: 1)
	)

	(method (newRoom)
		(switch gLanguage
			(0
				(SetLanguage {})
			)
			(1
				(SetLanguage {spanish})
			)
			(2
				(SetLanguage {french})
			)
			(3
				(SetLanguage {german})
			)
		)
		(super newRoom: &rest)
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

(instance sPlayDemo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSfx number: 816 play: self)
				(gGame handsOff:)
			)
			(1
				(gSfx number: 822 play:)
				(gGame setCursor: 6 1)
				(gGame handsOn:)
			)
			(2
				(gLongSong number: 600 loop: -1 play:)
				(= seconds 2)
			)
			(3
				(gCurRoom newRoom: 115) ; pickEgo
			)
		)
	)
)

(instance sEndDemo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSfx number: 819 play: self)
				(gGame handsOff:)
			)
			(1
				(gSfx number: 820 play: self)
			)
			(2
				(gSfx number: 821 play: self)
			)
			(3
				(gLongSong number: 600 loop: -1 play:)
				(gCurRoom setScript: sIntro)
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
		x 6
		y 55
		mainView 181
	)

	(method (init)
		(self mainView: (+ (* 1000 gLanguage) 181))
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
		x 6
		y 77
		mainView 181
		mainLoop 1
	)

	(method (init)
		(self mainView: (+ (* 1000 gLanguage) 181))
		(super init: &rest)
		(self show: x y)
	)

	(method (select)
		(if (super select: 1)
			(if (>= local0 12)
				(switch gLanguage
					(0
						(proc0_16
							(= local4
								(Str
									format:
										{To start a new game, you must complete one of the previously created characters. Press the "Old Game" button.}
								)
							)
						)
					)
					(1
						(proc0_16
							(= local4
								(Str
									format:
										{Para comenzat unjuego, usted deber# completar uno de lis personajes creados previamente. Oprima el bot&n del "Juego Viejo"}
								)
							)
						)
					)
					(2
						(proc0_16
							(= local4
								(Str
									format:
										{Pour commecer une nouvelle partie, tu dois d'abord compl$ter un des personnages cr$$s auparavant. Presse le bouton "partie pr$c$dente"}
								)
							)
						)
					)
					(else
						(proc0_16
							(= local4
								(Str
									format:
										{Um ein neves Spiel zu beginnen, mu~t du zverst deine vorherige spielfigur zu Ende spielen. Dr9cke auf die Taste "Altes Spiel"}
								)
							)
						)
					)
				)
				(= local3 1)
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
		x 6
		y 99
		mainView 181
		mainLoop 2
		maskView 181
		maskLoop 2
		maskCel 2
	)

	(method (init)
		(self mainView: (+ (* 1000 gLanguage) 181))
		(self maskView: (+ (* 1000 gLanguage) 181))
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
		x 6
		y 121
		mainLoop 3
	)

	(method (init)
		(self mainView: (+ (* 1000 gLanguage) 181))
		(super init: &rest)
		(self show: x y)
	)

	(method (select)
		(if (and (super select: 1) (not global523))
			(if global524
				(switch gLanguage
					(0
						(= gLanguage 1)
					)
					(1
						(= gLanguage 2)
					)
					(2
						(= gLanguage 3)
					)
					(3
						(= gLanguage 0)
					)
				)
			else
				(switch gLanguage
					(0
						(= gLanguage 1)
					)
					(1
						(= gLanguage 0)
					)
				)
			)
			(creditsButton init:)
			(oldGameButton init:)
			(newGameButton init:)
			(quitButton init:)
			(languageButton init:)
			(gCurRoom drawPic: (+ 501 (* 1000 gLanguage)))
			(setupLanguages doit:)
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
		x 6
		y 142
		mainView 181
	)

	(method (init)
		(self mainLoop: 4)
		(self mainView: (+ (* 1000 gLanguage) 181))
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

(instance setupLanguages of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(= temp0 (IntArray new: 13))
		(= temp1 (Str new: 12))
		(switch gLanguage
			(1
				(= local0 (Save 5 {MGS} (temp1 data:) (temp0 data:))) ; GetSaveFiles
			)
			(2
				(= local0 (Save 5 {MGF} (temp1 data:) (temp0 data:))) ; GetSaveFiles
			)
			(3
				(= local0 (Save 5 {MGG} (temp1 data:) (temp0 data:))) ; GetSaveFiles
			)
			(0
				(= local0 (Save 5 {MGE} (temp1 data:) (temp0 data:))) ; GetSaveFiles
			)
		)
		(temp0 dispose:)
		(temp1 dispose:)
		(if (not local0)
			(oldGameButton signal: (| (oldGameButton signal:) $0004) show:)
			(global511
				delete:
				add: creditsButton newGameButton languageButton quitButton
			)
		else
			(oldGameButton signal: (& (oldGameButton signal:) $fffb) show:)
			(global511
				delete:
				add:
					creditsButton
					newGameButton
					oldGameButton
					languageButton
					quitButton
			)
		)
	)
)

