;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 290)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Menu)

(public
	rm290 0
)

(local
	doneTime
)

(instance rm290 of Rm
	(properties
		picture 99
		style 6
	)

	(method (init &tmp filthFile [str 9])
		(HandsOff)
		(= gDemo 0)
		(SL disable:)
		(TheMenuBar hide:)
		(super init:)
		(if (!= (= filthFile (FOpen {RESOURCE.LL3} 1)) -1)
			(= gFilthLevel (ReadNumber (FGets @str 8 filthFile)))
		)
		(FClose filthFile)
		(gEgo
			view: 290
			posn: 20 100
			setStep: 1 1
			setMotion: MoveTo 3000 100
			setCycle: Walk
			init:
		)
		(gGame setSpeed: 0)
	)

	(method (doit)
		(super doit:)
		(if (== (++ gMachineSpeed) 1)
			(= doneTime (+ 60 (GetTime)))
		)
		(if (< doneTime (GetTime))
			(if gDebugging
				(gGame setSpeed: 2)
			else
				(gGame setSpeed: 6)
			)
			(= gExpletive
				(Format ; "%s"
					@gExpletiveBuffer
					290
					0
					(switch gFilthLevel
						(4 {Son of a bitch!})
						(3 {Damn it to hell!})
						(2 {Damn!})
						(1 {Gol dang it!})
						(else {Golly gee!})
					)
				)
			)
			(Format ; "%s"
				@gFilthLevelBuffer
				290
				0
				(switch gFilthLevel
					(4 {Totally Raunchiest})
					(3 {Really Filthy})
					(2 {Pretty Dirty})
					(1 {Rather Risque})
					(else {Mother Goose})
				)
			)
			(if (> (DoSound sndCHECK_DRIVER) 3)
				(= gBgMusicLoops -1)
			else
				(= gBgMusicLoops 1)
			)
			(= gCreditsFinished 0)
			(= gAutoSaveMinutes 5)
			(= gGameSeconds 0)
			(= gGameMinutes 0)
			(= gGameHours 0)
			(= gStringDelay 20)
			(= gNormalEgoView 718)
			(= gEgoState 19)
			(= gEgoName (Format @gEgoNameBuffer 290 1)) ; "Larry"
			(ClearFlag 4) ; preventAutoSave
			(ClearFlag 3) ; cantSave
			(TheMenuBar draw:)
			(SL enable:)
			(gCurRoom newRoom: 200)
		)
	)
)

