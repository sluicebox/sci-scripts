;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 61000)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPSound)
(use n64896)
(use Str)
(use Actor)
(use System)

(public
	roSierraLogo 0
)

(local
	killScrollIntro
	IsVirgin
)

(instance voTorinLogo of View
	(properties
		x 139
		y 60
		view 60015
	)

	(method (init)
		(super init: &rest)
		(Palette 1 view) ; PalLoad
	)
)

(instance oSierraTheme of TPSound
	(properties)
)

(instance soSierraLogo of Script
	(properties)

	(method (changeState newState &tmp cfgBuf)
		(switch (= state newState)
			(0
				(FrameOut)
				(voTorinLogo init: hide:)
				(gOEventHandler registerGlobalHandler: self)
				(= ticks 1)
			)
			(1
				(oSierraTheme playSound: 60021 self)
				(= ticks 165)
			)
			(2
				(voTorinLogo show:)
			)
			(3
				(= ticks 54)
			)
			(4
				(FadeToBlack 1 15 self 1)
			)
			(5
				(self dispose:)
			)
		)
	)

	(method (handleEvent event)
		(if (event type:)
			(self dispose:)
		)
	)

	(method (dispose)
		(super dispose:)
		(gOEventHandler unregisterGlobalHandler: self)
		(gGame setScript: 0)
		(oSierraTheme stop:)
		(voTorinLogo dispose:)
		(gCurRoom drawPic: -2)
		(gCurRoom newRoom: 61100) ; roPickAChapter
		(gGame autosave: 0 1)
		(if IsVirgin
			(gCurRoom newRoom: 8000) ; roPrologue1
		)
	)
)

(instance roSierraLogo of TPRoom
	(properties
		picture 61001
	)

	(method (init &tmp pathName fp)
		(super init: &rest)
		(AddPicAt plane 61000 0 350)
		(goSound1 preload: 60021)
		(= killScrollIntro 0)
		(= IsVirgin 1)
		(= pathName (Str new:))
		(pathName format: {%s%s} gCurSaveDir {autosave.cat})
		(= fp (FileIO fiOPEN (KString 9 pathName))) ; StrGetData
		(pathName dispose:)
		(if (!= fp -1)
			(= IsVirgin 0)
			(FileIO fiCLOSE fp)
		)
		(gCurRoom setScript: soSierraLogo)
	)
)

