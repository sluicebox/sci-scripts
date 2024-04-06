;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 805)
(include sci.sh)
(use Main)
(use n001)
(use Interface)
(use n806)
(use File)
(use Game)
(use System)

(public
	import 0
)

(local
	statsKey = 83
	svCharType
	svHighGold
	svLowGold
	svScore
	svMiscEquip
	[codedStats 25]
	svDaggers
	[unused 4]
	bogus0 = 121
	bogus1 = 134
	checkSum1
	checkSum2
	bogus2 = 67
	bogus3 = 136
	bogus4 = 173
	bogus5 = 240
	checkSumKey = 206
	check1
	check2
	[YNSTR 5]
	validFile
	[heroFileName 40]
	[bigStr 440]
	[statMap 25] = [0 1 2 3 4 5 6 7 8 9 10 11 12 15 16 17 18 19 20 21 22 23 24 25 26]
)

(procedure (makeZero &tmp whichSkill)
	(for ((= whichSkill 0)) (< whichSkill 30) ((++ whichSkill))
		(= [gEgoStats whichSkill] 0)
	)
	(= [gInvNum 17] (= gScore 0)) ; Gold
	(= [gInvNum 4] 0) ; Sword
	(= [gInvNum 7] 0) ; Shield
	(= [gInvNum 5] 0) ; Dagger
	(= [gInvNum 6] 0) ; Leather
	(= [gInvNum 15] 0) ; ChainMail
	(= [gInvNum 10] 0) ; LockPick
	(= [gInvNum 11] (= [gInvNum 12] 0)) ; ThiefKit, ThiefLicense
	(= gScore 0)
	(= gHeroType 0) ; Fighter
	(StrCpy @gUserName {xxxxxxxxxxy})
	(for ((= whichSkill 0)) (< whichSkill 43) ((++ whichSkill))
		(= [statsKey (+ whichSkill 1)] 0)
	)
)

(procedure (restoreHero &tmp whichSkill)
	(if (not (glory1_sav open: 1))
		(Print (Format @bigStr 805 0 (glory1_sav name:))) ; "Could not find Hero file -- %s."
		(return 0)
	)
	(glory1_sav readString: @gUserName 52)
	(glory1_sav readString: @bigStr 90)
	(for ((= whichSkill 0)) (< whichSkill 43) ((++ whichSkill))
		(= [statsKey (+ whichSkill 1)] (convWord [bigStr whichSkill]))
	)
	(for ((= whichSkill 43)) (< 0 whichSkill) ((-- whichSkill))
		(^= [statsKey whichSkill] (& [statsKey (- whichSkill 1)] $007f))
	)
	(= check1 checkSumKey)
	(for ((= whichSkill 0)) (< whichSkill 35) ((+= whichSkill 2))
		(&= [statsKey (+ whichSkill 1)] $007f)
		(+= check1 [statsKey (+ whichSkill 1)])
	)
	(= check2 0)
	(for ((= whichSkill 1)) (< whichSkill 35) ((+= whichSkill 2))
		(&= [statsKey (+ whichSkill 1)] $007f)
		(+= check2 [statsKey (+ whichSkill 1)])
	)
	(&= check1 $007f)
	(&= check2 $007f)
	(if (or (!= check1 checkSum1) (!= check2 checkSum2))
		(Print 805 1) ; "I'm terribly sorry. That doesn't seem to be a proper Quest for Glory I character save file."
		(return 0)
	)
	(for ((= whichSkill 0)) (< whichSkill 25) ((++ whichSkill))
		(= [gEgoStats [statMap whichSkill]] [codedStats whichSkill])
		(if
			(and
				(not (< 12 [statMap whichSkill] 19))
				(not (<= 0 [codedStats whichSkill] 100))
			)
			(Print 805 1) ; "I'm terribly sorry. That doesn't seem to be a proper Quest for Glory I character save file."
			(return 0)
		)
	)
	(= [gEgoStats 13] (/ (+ (* [gEgoStats 1] 3) [gEgoStats 4]) 4)) ; communication, intelligence, luck
	(= [gInvNum 5] svDaggers) ; Dagger
	(= gHeroType (= gOrigHeroType svCharType))
	(= [gInvNum 17] (+ (* svHighGold 100) svLowGold)) ; Gold
	(if (& svMiscEquip $0001)
		(= [gInvNum 4] 1) ; Sword
	)
	(if (& svMiscEquip $0002)
		(= [gInvNum 15] 1) ; ChainMail
	else
		(= [gInvNum 6] 1) ; Leather
	)
	(if (& svMiscEquip $0004)
		(= [gInvNum 10] (= [gInvNum 12] 1)) ; LockPick, ThiefLicense
	)
	(if (& svMiscEquip $0008)
		(= [gInvNum 11] (= [gInvNum 12] 1)) ; ThiefKit, ThiefLicense
	)
	(if (== gHeroType 0) ; Fighter
		(= [gInvNum 7] 1) ; Shield
	)
	(return 1)
)

(procedure (convWord ascii)
	(return
		(+
			(convByte (>> ascii $0008))
			(* (convByte (& ascii $00ff)) 16)
		)
	)
)

(procedure (convByte ascii)
	(cond
		((== ascii 32)
			(return 0)
		)
		((<= 48 ascii 57)
			(return (- ascii 48))
		)
		(else
			(return (- ascii 87))
		)
	)
)

(instance import of Rm
	(properties
		picture 3
		style 7
	)

	(method (dispose)
		(SL code: gDftStatusCode)
		(SetFlag 2) ; fInMainGame
		(super dispose:)
	)

	(method (init)
		(ClearFlag 2) ; fInMainGame
		(SL code: endStatus enable:)
		(super init: &rest)
		(gCSound stop:)
		(HandsOff)
		(self setScript: importHero)
	)
)

(instance glory1_sav of File
	(properties
		name {glory1.sav}
	)
)

(instance importHero of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(Format @heroFileName 805 2) ; "a:glory1.sav"
				(Print 805 3) ; "Please insert the disk on which you saved your winning Hero from "Quest for Glory I: So You Want To Be A Hero" into the disk drive so that your Hero can make the journey to Shapeir."
				(self cue:)
			)
			(1
				(= cycles 2)
			)
			(2
				(if (GetHeroFileName @heroFileName)
					(glory1_sav name: @heroFileName)
					(= cycles 2)
				else
					(self changeState: 5)
				)
			)
			(3
				(makeZero)
				(if (= validFile (restoreHero))
					(= cycles 2)
				else
					(self changeState: 6)
				)
			)
			(4
				(Print 805 4) ; "Character successfully imported."
				(= cycles 1)
			)
			(5
				(HandsOn)
				(gCurRoom newRoom: (if validFile 810 else 765))
			)
			(6
				(if (Print 805 5 #button {Yes} 1 #button { No } 0) ; "Do you want to try importing your character again?"
					(= bogus0 121)
					(= bogus1 134)
					(= bogus2 67)
					(= bogus3 136)
					(= bogus4 173)
					(= bogus5 240)
					(self changeState: 1)
				else
					(self changeState: 5)
				)
			)
		)
	)
)

(instance endStatus of Code
	(properties)

	(method (doit strg)
		(Format strg 805 6 gScore) ; "Wow! You're Really A Hero! [score %d of 500]"
	)
)

