;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64019)
(include sci.sh)
(use Main)
(use TPSound)
(use DialogPlane)
(use n64896)
(use System)

(public
	DeathDialog 0
)

(class DeathDialog of Obj
	(properties)

	(method (show nNoun nVerb nCase nModuleNum &tmp nModule strTitle strText strTryAgain strBreak nMusic oDeathSound curSFXVolume curVolume)
		(if (< argc 3)
			(PrintDebug
				{Death dialogs now retrieve death message from a msg file.\nPlease see death.sc for details.}
			)
			(return 1)
		)
		(= nMusic 0)
		(if (< argc 4)
			(= nModule gCurRoomNum)
		else
			(= nModule nModuleNum)
		)
		(= strTitle (MakeMessageText nNoun nVerb nCase 1 nModule))
		(= strText (MakeMessageText nNoun nVerb nCase 2 nModule))
		(= strTryAgain (MakeMessageText 0 0 7 1 0))
		(if (goMusic1 isPlaying:)
			(= nMusic (goMusic1 number:))
		)
		(goMusic1 playSound: 60020)
		(= oDeathSound (TPSound new:))
		(= curSFXVolume gSFXVol)
		(SetSFXVol (MulDiv 35 gSFXVol 100))
		(= curVolume gMusicVol)
		(SetMusicVol (MulDiv 35 gMusicVol 100))
		(Load rsVIEW 60013 60014 60019 60020)
		(Load rsFONT 2510)
		(oDeathSound playMessage: nNoun nVerb nCase 2 0 nModule)
		(TextDialog strText strTryAgain strTitle)
		(oDeathSound stop: dispose:)
		(goMusic1 setMusic: nMusic)
		(SetSFXVol curSFXVolume)
		(SetMusicVol curVolume)
		(return 1)
	)
)

