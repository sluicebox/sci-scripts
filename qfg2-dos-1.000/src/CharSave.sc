;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 840)
(include sci.sh)
(use Main)
(use n001)
(use Interface)
(use Save)
(use File)
(use Game)
(use User)
(use Actor)
(use System)

(public
	CharSave 0
)

(local
	statsKey = 83
	svCharType
	svHighDinar
	svLowDinar
	svScore
	svMiscEquip
	[codedStats 30]
	svDaggers
	svHealingPill
	svManaPill
	svStaminaPill
	svPoisonCurePill
	bogus0 = 160
	bogus1 = 62
	checkSum1
	checkSum2
	bogus2 = 47
	bogus3 = 144
	bogus4 = 25
	bogus5 = 163
	checkSumKey = 218
	check1
	check2
	[unused 10]
	[heroFileName 44]
	[bigStr 400]
	hasSaved
	[str 40]
	answer
)

(instance CharSave of Rm
	(properties
		picture 900
		style 7
	)

	(method (dispose)
		(SL code: gDftStatusCode)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (init)
		(SL code: endStatus enable:)
		(gKeyDownHandler add: self)
		(super init: &rest)
		(gCustomWindow back: 0 color: 15)
		(songObj init: hide:)
		(gAddToPics
			add: frame1 frame2 frame3 frame4 frame5 frame6 frame7 frame8
			eachElementDo: #init
			doit:
		)
		(gCSound number: 830 loop: -1 priority: 5 play:)
		(User canControl: 0 canInput: 0)
		(self setScript: saveHero)
		(songObj setScript: songScript)
	)
)

(instance glory2_sav of File
	(properties
		name {glory2.sav}
	)
)

(instance saveHero of Script
	(properties)

	(method (handleEvent event)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN) register)
			(= register 0)
			(= cycles 1)
			(event claimed: 1)
		)
	)

	(method (changeState newState &tmp whichSkill oldDinar lineEndString oldExper retry)
		(switch (= state newState)
			(0
				(Format @heroFileName 840 0) ; "a:glory2.sav"
				(if (>= gScore gPossibleScore)
					(Format @bigStr 840 1 gPossibleScore gPossibleScore) ; "CONGRATULATIONS!! You have successfully completed "Quest for Glory II: Trial by Fire" with the maximum possible score, %d of %d!! We welcome you to the ranks of the few, the proud, the True Heroes!"
					(Print @bigStr #window gCustomWindow #mode 1 #width 220 #dispose)
				else
					(Print
						(Format @bigStr 840 2 gScore gPossibleScore) ; "Congratulations! You have successfully completed "Quest for Glory II: Trial by Fire." Your final score was %d of %d possible Puzzle Points."
						#window
						gCustomWindow
						#mode
						1
						#width
						220
						#dispose
					)
				)
				(= register 1)
			)
			(1
				(Print 840 3 #window gCustomWindow #mode 1 #width 220 #dispose) ; "If you have not already done so, we encourage you to play "Quest for Glory II" again with the other two character types; many of the puzzles are different, or have alternate solutions."
				(= register 1)
			)
			(2
				(Print 840 4 #window gCustomWindow #mode 1 #width 220 #dispose) ; "In the meantime, you are already a winner! Please insert a writable disk in your floppy drive to save your winning Hero for use in "Quest for Glory III: Shadows of Darkness.""
				(= register 1)
			)
			(3
				(cls)
				(if (Print 840 5 #window gCustomWindow #mode 1 #edit @heroFileName 30) ; "Disk file in which to save your Hero."
					(glory2_sav name: @heroFileName)
					(= cycles 2)
				else
					(self changeState: 9)
				)
			)
			(4
				(= answer 0)
				(if (!= (glory2_sav open: 1) 0)
					(repeat
						(if
							(= answer
								(Print ; "File already exists. Do you wish to overwrite?"
									840
									6
									#title
									{ WARNING! }
									#mode
									1
									#window
									Warning
									#button
									{ NO }
									1
									#button
									{ YES }
									2
								)
							)
							(break)
						)
					)
					(switch answer
						(1
							(self changeState: 3)
						)
						(2
							(= cycles 1)
						)
					)
				else
					(= cycles 1)
				)
			)
			(5
				(if (glory2_sav open: 2)
					(glory2_sav close:)
					(= seconds 2)
				else
					(Print
						(Format @bigStr 840 7 (glory2_sav name:)) ; "Could not create file -- %s."
						#window
						Warning
						#mode
						1
						#width
						220
					)
					(self changeState: 9)
				)
			)
			(6
				(if (not (glory2_sav open: 0))
					(self changeState: 9)
					(return)
				)
				(Print 840 8 #window gCustomWindow #mode 1 #dispose) ; "Saving Character"
				(for ((= whichSkill 0)) (< whichSkill 30) ((++ whichSkill))
					(= [codedStats whichSkill] [gEgoStats whichSkill])
				)
				(= oldDinar [gInvNum 2]) ; Dinar
				(= svCharType gHeroType)
				(= svHighDinar (/ oldDinar 100))
				(= svLowDinar (mod oldDinar 100))
				(= svScore gScore)
				(= svMiscEquip 0)
				(if (gEgo has: 24) ; FineSword
					(|= svMiscEquip $0001)
				)
				(if (gEgo has: 31) ; Soulforge
					(|= svMiscEquip $0002)
				)
				(if (gEgo has: 23) ; Compass
					(|= svMiscEquip $0003)
				)
				(if (gEgo has: 27) ; SapphPin
					(|= svMiscEquip $0004)
				)
				(if (gEgo has: 33) ; BrassLamp
					(|= svMiscEquip $0008)
				)
				(if (gEgo has: 40) ; EOFToken
					(|= svMiscEquip $0010)
				)
				(if (gEgo has: 54) ; Glasses
					(|= svMiscEquip $0020)
				)
				(if (IsFlag 156) ; fBabaFrog
					(|= svMiscEquip $0030)
				)
				(if (gEgo has: 4) ; Sword
					(|= svMiscEquip $0040)
				)
				(if (gEgo has: 15) ; ChainMail
					(|= svMiscEquip $0080)
				)
				(if (gEgo has: 10) ; LockPick
					(|= svMiscEquip $0100)
				)
				(if (gEgo has: 11) ; ThiefKit
					(|= svMiscEquip $0200)
				)
				(= svDaggers [gInvNum 5]) ; Dagger
				(= svHealingPill [gInvNum 18]) ; HealingPill
				(= svManaPill [gInvNum 19]) ; ManaPill
				(= svStaminaPill [gInvNum 20]) ; StaminaPill
				(= svPoisonCurePill [gInvNum 48]) ; PoisonCure
				(= check1 checkSumKey)
				(for ((= whichSkill 0)) (< whichSkill 40) ((+= whichSkill 2))
					(&= [statsKey (+ whichSkill 1)] $00ff)
					(+= check1 [statsKey (+ whichSkill 1)])
				)
				(= check2 0)
				(for ((= whichSkill 1)) (< whichSkill 40) ((+= whichSkill 2))
					(&= [statsKey (+ whichSkill 1)] $00ff)
					(+= check2 [statsKey (+ whichSkill 1)])
				)
				(&= check1 $00ff)
				(&= check2 $00ff)
				(= checkSum1 check1)
				(= checkSum2 check2)
				(for ((= whichSkill 0)) (< whichSkill 48) ((++ whichSkill))
					(&= [statsKey (+ whichSkill 1)] $00ff)
					(^= [statsKey (+ whichSkill 1)] [statsKey whichSkill])
				)
				(= lineEndString {*})
				(StrAt lineEndString 0 10)
				(glory2_sav writeString: @gUserName lineEndString)
				(for ((= whichSkill 1)) (< whichSkill 49) ((++ whichSkill))
					(Format @bigStr 840 9 [statsKey whichSkill]) ; "%2x"
					(glory2_sav writeString: @bigStr)
				)
				(glory2_sav writeString: lineEndString)
				(glory2_sav close:)
				(= seconds 2)
			)
			(7
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 840 10 #window gCustomWindow #width 220 #mode 1 #dispose) ; "The save character file has been created. Save this disk for use with "Quest for Glory III: Shadows of Darkness" from Sierra On-Line."
				(= register 1)
			)
			(8
				(= hasSaved 1)
				(self changeState: 10)
			)
			(9
				(repeat
					(if
						(= retry
							(Print ; "Do you wish to try saving your character again?"
								840
								11
								#button
								{ No }
								1
								#button
								{ Yes }
								2
								#window
								gCustomWindow
								#mode
								1
							)
						)
						(switch retry
							(1
								(= retry 10)
								(break)
							)
							(2
								(= retry 3)
								(= bogus0 121)
								(= bogus1 134)
								(= bogus2 67)
								(= bogus3 136)
								(= bogus4 173)
								(= bogus5 240)
								(break)
							)
						)
					)
				)
				(self changeState: retry)
			)
			(10
				(Print 840 12 #window gCustomWindow #width 220 #mode 1) ; "Thank you for playing "Quest for Glory II: Trial by Fire," and congratulations again on winning. We'll see you again soon in "Quest for Glory III: Shadows of Darkness.""
				(= seconds 4)
			)
			(11
				(if (== (gMiscSound number:) 831)
					(= cycles 1)
				else
					(self setScript: waitForSong self)
				)
			)
			(12
				(gCurRoom drawPic: 900 7)
				(= cycles 1)
			)
			(13
				(gCurRoom newRoom: 850) ; closingCredits
			)
		)
	)
)

(instance endStatus of Code
	(properties)

	(method (doit strg)
		(if (== gHeroType 3) ; Paladin
			(Format strg 840 13 gScore gPossibleScore) ; "Congratulations, Paladin! [score %d of %d]"
		else
			(Format strg 840 14 gScore gPossibleScore) ; "Hero of Two Lands! [score %d of %d]"
		)
	)
)

(instance frame1 of PicView
	(properties
		x 81
		y 33
		view 242
	)
)

(instance frame2 of PicView
	(properties
		x 239
		y 33
		view 242
		loop 1
	)
)

(instance frame3 of PicView
	(properties
		x 19
		y 94
		view 242
		cel 1
	)
)

(instance frame4 of PicView
	(properties
		x 20
		y 156
		view 242
		cel 2
	)
)

(instance frame5 of PicView
	(properties
		x 81
		y 189
		view 242
		cel 3
	)
)

(instance frame6 of PicView
	(properties
		x 238
		y 189
		view 242
		loop 1
		cel 3
	)
)

(instance frame7 of PicView
	(properties
		x 300
		y 156
		view 242
		loop 1
		cel 2
	)
)

(instance frame8 of PicView
	(properties
		x 301
		y 94
		view 242
		loop 1
		cel 1
	)
)

(instance Warning of SysWindow
	(properties
		color 14
		back 4
	)
)

(instance songObj of Prop
	(properties)
)

(instance songScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 8)
			)
			(1
				(gSpareSound number: 833 priority: 10 loop: -1 play:)
				(= seconds 8)
			)
			(2
				(if (== (saveHero script:) waitForSong)
					(waitForSong cue:)
				else
					(waitForSong start: 1)
				)
				(gMiscSound number: 831 loop: -1 priority: 11 play:)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance waitForSong of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(self dispose:)
			)
		)
	)
)

