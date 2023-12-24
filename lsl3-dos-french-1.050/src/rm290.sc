;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 290)
(include sci.sh)
(use Main)
(use FileSelector)
(use Motion)
(use File)
(use Game)
(use Menu)

(public
	rm290 0
)

(local
	doneTime
)

(instance RESOURCE_LL3 of File
	(properties
		name {RESOURCE.LL3}
	)
)

(instance rm290 of Rm
	(properties
		picture 99
		style 6
	)

	(method (init &tmp [temp0 30])
		(HandsOff)
		(= gDemo 0)
		(SL disable:)
		(TheMenuBar hide:)
		(super init:)
		(if (!= (RESOURCE_LL3 open: 1) 0)
			(RESOURCE_LL3 read: @temp0 8 close:)
			(= gFilthLevel (ReadNumber @temp0))
		)
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
			(= global289
				(Format ; "%s%"
					@global230
					290
					0
					(switch gFilthLevel
						(4 {Son of a bitch!})
						(3 {Damn it to hell!})
						(2 {Damn!})
						(1 {Gol dang it!})
						(else {Golly gee!})
					)
					(switch gFilthLevel
						(4 {Bordel de merde})
						(3 {Putain})
						(2 {Merde})
						(1 {Zut})
						(else {Crotte})
					)
				)
			)
			(StrSplitInTwo @global306 @global346 global289)
			(= global304 @global306)
			(= global305 @global346)
			(Format ; "%s%"
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
				(switch gFilthLevel
					(4 {Vraiment D\82gueu})
					(3 {Crado})
					(2 {Impudique})
					(1 {Os\82})
					(else {Enfant de Choeur})
				)
			)
			(StrSplitInTwo @global470 @global530 @gFilthLevelBuffer)
			(= global468 @global470)
			(= global469 @global530)
			(= gBgMusicLoops -1)
			(= gCreditsFinished 0)
			(= global291 5)
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

