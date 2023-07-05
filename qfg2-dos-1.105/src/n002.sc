;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2)
(include sci.sh)
(use Main)
(use n001)
(use Talker)
(use Interface)
(use n940)
(use LoadMany)
(use User)
(use Menu)
(use System)

(public
	InitGlobals 0
	GameStartRoom 1
	StartARoom 2
	Eat 3
	DrinkPotion 4
	EgoSleeps 5
	EgoRests 6
	TrySkill 7
	SkillUsed 8
	CanPickLocks 9
	UseStamina 10
	UseMana 11
	TakeDamage 12
	SolvePuzzle 13
	FindTime 14
	FixTime 15
	AdvanceTime 16
	NextDay 17
	EatMeal 18
	ToLower 19
	StrFind 20
	LookFor 21
	StrToLower 22
	GotoPlaceAndTime 23
	TakePill 24
	DrinkWater 25
	CantBePaladin 26
	CheckPaladin 27
	SayThanks 28
	GiveFlowers 29
	PickLock 30
)

(procedure (InitGlobals)
	(= gDebugging 0)
	(= gNumVoices (DoSound sndGET_POLYPHONY))
	(if (< (= gNumColors (Graph grGET_COLOURS)) 8)
		(= gStatusBarView 811)
		(= gCombatColor 15)
		(= gSameColor 0)
		(= gChangeColor 4)
	else
		(= gStatusBarView 810)
		(= gCombatColor 11)
		(= gSameColor 9)
		(= gChangeColor 12)
	)
	(DoSound sndMASTER_VOLUME 15)
	(Joystick 12 0)
)

(procedure (GameStartRoom &tmp nr whichSkill)
	(= gDeathMusic 10)
	(= gShowStyle 0)
	(= gPossibleScore 500)
	(= gUserFont 300)
	(= gSmallFont 999)
	(= gBigFont 300)
	(= gStamCounter 20)
	(= gHealCounter 15)
	(= gManaCounter 5)
	(SetFlag 1)
	(= gDay 1)
	(FixTime 8)
	(= gSillyClowns 0)
	(= gArcadeLevel 2)
	(= gTimeScale 1)
	(= nr 0)
	(if (and gDebugging 1)
		(for ((= whichSkill 0)) (< whichSkill 30) ((++ whichSkill))
			(= [gEgoStats whichSkill] 80)
		)
		(= [gEgoStats 15] 1900) ; experience
		(= [gEgoStats 16] (MaxHealth)) ; health
		(= [gEgoStats 17] (MaxStamina)) ; stamina
		(= [gEgoStats 18] (MaxMana)) ; mana
		(= [gInvNum 17] 100) ; Gold
		(= [gInvNum 3] 10) ; Food
		(= [gInvNum 37] 1) ; Waterskin
		(= gDrinksLeft 10)
		(StrCpy @gUserName {Hero})
		(SetFlag 2)
		(= nr (GotoPlaceAndTime))
	else
		(ClearFlag 2)
	)
	(if (not nr)
		(if (GameIsRestarting)
			(= nr 765)
		else
			(= nr 764)
		)
	)
	(return nr)
)

(procedure (StartARoom nr &tmp [temp0 2] temp2)
	(gGame setCursor: gWaitCursor 1)
	(while ((= temp2 (Event new:)) type:)
		(temp2 dispose:)
	)
	(temp2 dispose:)
	(if (OneOf nr 764 765 750 770 785 800 810 805 98 850 820 821 822)
		(MenuBar hide: state: 0)
	else
		(MenuBar draw:)
	)
	(cls)
	(LoadMany
		0
		21
		322
		321
		491
		30
		32
		31
		670
		171
		685
		175
		273
		675
		695
		680
		655
		660
		381
		953
		951
		985
		946
		475
		61
		62
		63
		64
		65
		70
		71
		25
		60
		116
		117
		88
		241
		973
		988
		959
		95
		700
		701
		702
		80
		81
		83
		85
		89
		90
		86
		84
		87
		78
		82
		79
		75
		91
		3
		77
		96
		93
		24
		72
		956
		951
		991
		968
		969
		972
		971
		970
		945
		949
		940
	)
	(gMouseDownHandler release:)
	(gKeyDownHandler release:)
	(gDirectionHandler release:)
	(FixTime)
	(if gNight
		(|= global61 $0001)
	else
		(&= global61 $fffe)
	)
	(if (== nr 820)
		(ClearFlag 2)
		(FixTime 12 0)
		(= gNight 0)
		(= global61 0)
	)
	(= gLevHighY (= gLevScript 0))
	(if (not gMonsterNum)
		(= gHitDaggers 0)
	)
)

(procedure (Eat event &tmp haveEaten)
	(= haveEaten 0)
	(cond
		(gFreeMeals
			(event claimed: 1)
			(HighPrint 2 0) ; "There's no need. You're not hungry."
		)
		((Said '/fruit')
			(if (gEgo has: 36) ; CompassionFruit
				(gEgo use: 36) ; CompassionFruit
				(HighPrint 2 1) ; "You eat some of the magical fruit. It tastes strange."
				(= haveEaten 1)
			else
				(HighPrint 2 2) ; "You don't have any fruit."
			)
		)
		((or (Said '/provision,food') (Said 'eat,eat[/!*]'))
			(if (gEgo has: 3) ; Food
				(gEgo use: 3 1) ; Food
				(HighPrint 2 3) ; "The rations are tasteless but filling."
				(= haveEaten 1)
			else
				(HighPrint 2 4) ; "You aren't carrying any rations."
			)
		)
		(else
			(event claimed: 1)
			(HighPrint 2 5) ; "Ugh. You don't want to eat THAT!"
		)
	)
	(if haveEaten
		(if (IsFlag 4)
			(ClearFlag 4)
			(ClearFlag 5)
		else
			(= gFreeMeals 1)
		)
	)
)

(procedure (DrinkPotion event index)
	(cond
		((or (== index 37) (Said '/water'))
			(DrinkWater 1)
		)
		((Said '/potion,grease')
			(HighPrint 2 6) ; "You'd better not."
		)
		((Said '/*')
			(HighPrint 2 7) ; "You can't drink that."
		)
		(else
			(event claimed: 1)
			(DrinkWater 1)
		)
	)
)

(procedure (TakePill event index &tmp ret maxVal)
	(= ret 1)
	(cond
		((not index)
			(HighPrint 2 8) ; "I don't know what kind of pill that is. Remember, just say no to unknown pills. Your local apothecary can give you advice on safe and sane pill use."
			(= ret 0)
		)
		((not (gEgo use: index))
			(HighPrint 2 9) ; "You don't have any of those pills."
			(= ret 0)
		)
		((== index 18)
			(= maxVal (MaxHealth))
			(if (< [gEgoStats 16] maxVal) ; health
				(TakeDamage (- (/ maxVal 2)))
				(HighPrint 2 10) ; "That feels good; just what you needed to relieve some of the aches and pains of everyday adventuring."
			else
				(HighPrint 2 11) ; "You take the pill, but it doesn't seem to have any effect. Next time, follow the prescription."
			)
		)
		((== index 19)
			(= maxVal (MaxMana))
			(if (< [gEgoStats 18] maxVal) ; mana
				(UseMana (- (/ maxVal 2)))
				(HighPrint 2 12) ; "You feel a surge of power as the magical energy of the pill releases itself into your system."
			else
				(HighPrint 2 11) ; "You take the pill, but it doesn't seem to have any effect. Next time, follow the prescription."
			)
		)
		((== index 20)
			(= maxVal (MaxStamina))
			(if (< [gEgoStats 17] maxVal) ; stamina
				(UseStamina (- maxVal))
				(HighPrint 2 13) ; "You feel refreshed, invigorated, ready to take on any challenge -- at least, for a while."
			else
				(HighPrint 2 11) ; "You take the pill, but it doesn't seem to have any effect. Next time, follow the prescription."
			)
		)
		((== index 48)
			(if (IsFlag 121)
				(HighPrint 2 14) ; "Unlike heads, two poison cure pills are no better than one. But the pill does no harm either."
			else
				(SetFlag 121)
				(HighPrint 2 15) ; "The only effect is a tingling sensation. But, if the apothecary is to be trusted, you should be safe from the effects of poison for a while."
			)
		)
	)
	(if ret
		(HighPrint 2 16) ; "The pill makes you thirsty, so you pull out your waterskin."
		(DrinkWater 1)
	)
	(return ret)
)

(procedure (DrinkWater giveMessage &tmp ret)
	(= ret (> gDrinksLeft 0))
	(if (< (-- gDrinksLeft) 0)
		(if giveMessage
			(HighPrint 2 17) ; "Alas, you are out of water."
		)
	else
		(ClearFlag 3)
		(ClearFlag 137)
		(cond
			((not gDrinksLeft)
				(HighPrint 2 18) ; "You drink the last drops from your waterskin. You might want to start looking around for a place where you can refill it."
			)
			((== gDrinksLeft 2)
				(HighPrint 2 19) ; "Your water skin is getting much easier to carry. Unfortunately, that probably means you don't have much water left."
			)
			(giveMessage
				(HighPrint 2 20) ; "You take a careful sip from your waterskin. It tastes great."
			)
		)
	)
	(return ret)
)

(procedure (EgoSleeps theHour theMin &tmp sleptHours oldTime)
	(= gLostSleep 0)
	(= oldTime gClock)
	(FixTime theHour theMin)
	(= sleptHours (/ (mod (- (+ gClock 3600) oldTime) 3600) 150))
	(= [gEgoStats 17] (MaxStamina)) ; stamina
	(TakeDamage (- (* sleptHours 8)))
	(UseMana (- (* sleptHours 8)))
	(if (> oldTime gClock)
		(NextDay)
	)
)

(procedure (EgoRests mess)
	(= gLastRestDay gDay)
	(= gLastRestTime gClock)
	(= [gEgoStats 17] (MaxStamina)) ; stamina
	(UseMana -12)
	(TakeDamage -6)
	(if mess
		(HighPrint 2 21) ; "After an hour's rest, you feel refreshed."
	)
	(AdvanceTime 1 0)
)

(procedure (TrySkill skillNum difficulty bonus &tmp skVal skDiv skRef success)
	(= success 0)
	(if (= skVal [gEgoStats skillNum])
		(if (== argc 3)
			(+= skVal bonus)
		)
		(if difficulty
			(if (and (>= skillNum 5) (< skillNum 13))
				(UseStamina (/ difficulty 10))
			)
		else
			(if (and (>= skillNum 5) (< skillNum 13))
				(UseStamina (Random 1 6))
			)
			(= difficulty (Rand200))
		)
		(if (>= (statCheck 4 1) (Random 1 200))
			(+= skVal (Random 1 20))
		)
		(= success (<= difficulty skVal))
		(if (= skDiv (+ (/ (+ 19 (Abs (- difficulty skVal))) 20) 1))
			(cond
				((== skillNum 5)
					(SkillUsed 0 3) ; strength
					(SkillUsed 2 2) ; agility
				)
				((or (== skillNum 6) (== skillNum 7) (== skillNum 8))
					(SkillUsed 2 4) ; agility
					(SkillUsed 1 2) ; intelligence
				)
				((== skillNum 9)
					(SkillUsed 2 8) ; agility
					(SkillUsed 1 5) ; intelligence
				)
				((or (== skillNum 10) (== skillNum 11))
					(SkillUsed 0 5) ; strength
					(SkillUsed 2 4) ; agility
				)
				((== skillNum 13)
					(SkillUsed 1 6) ; intelligence
				)
				((>= skillNum 19)
					(SkillUsed 12 8) ; magic use
					(SkillUsed 1 4) ; intelligence
				)
			)
			(= skRef 100)
			(if (or (< skillNum 13) (== skillNum 5))
				(= skRef 25)
			)
			(SkillUsed skillNum (Abs (/ skRef skDiv)))
		)
	)
	(return success)
)

(procedure (CanPickLocks showMsg &tmp aMsg)
	(cond
		((not [gEgoStats 9]) ; pick locks
			(= aMsg {You don't have the skill to pick locks.})
		)
		((not (or (gEgo has: 10) (gEgo has: 11))) ; LockPick, ThiefKit
			(= aMsg {You don't have any lock picking equipment.})
		)
		(else
			(return 1)
		)
	)
	(if (and argc showMsg)
		(HighPrint aMsg)
	)
	(return 0)
)

(procedure (PickLock difficulty showMsg useSound)
	(if (TrySkill 9 difficulty gLockPickBonus) ; pick locks
		(if (or (< argc 3) useSound)
			(gMiscSound number: 20 priority: 10 loop: 0 play:)
		)
		(return 1)
	else
		(if (and (> argc 1) showMsg)
			(HighPrint 2 22) ; "You will have to practice some more to improve your lockpicking skill."
		)
		(return 0)
	)
)

(procedure (UseMana pointsUsed)
	(if [gEgoStats 12] ; magic use
		(if (< (-= [gEgoStats 18] pointsUsed) 0) ; mana
			(= [gEgoStats 18] 0) ; mana
		)
		(if (> [gEgoStats 18] (MaxMana)) ; mana
			(= [gEgoStats 18] (MaxMana)) ; mana
		)
	)
	(return [gEgoStats 18]) ; mana
)

(procedure (SolvePuzzle pFlag pValue charType &tmp ret)
	(= ret 0)
	(if (>= argc 3)
		(if
			(and
				(== charType 3)
				(!= gHeroType 3) ; Paladin
				(not (IsFlag 153))
				(not (IsFlag pFlag))
			)
			(+= gPaladinPoints pValue)
		)
		(if (and (== gHeroType 3) (== charType gOrigHeroType)) ; Paladin
			(= charType 3)
		)
	)
	(if (not (or (SetFlag pFlag) (and (>= argc 3) (!= gHeroType charType))))
		(SkillUsed 1 pValue) ; intelligence
		(gGame changeScore: pValue)
		(= ret 1)
	)
	(return ret)
)

(procedure (SkillUsed skillNum learnValue &tmp learnSign)
	(if (not [gEgoStats skillNum])
		(return 0)
	)
	(= learnSign (if (>= learnValue 0) 1 else -1))
	(if (> (Abs learnValue) [gEgoStats skillNum])
		(= learnValue (* [gEgoStats skillNum] learnSign))
	)
	(+= [gEgoStats 15] (/ (Abs learnValue) 4)) ; experience
	(+= [gSkillTicks skillNum] learnValue)
	(cond
		((>= [gSkillTicks skillNum] [gEgoStats skillNum])
			(-= [gSkillTicks skillNum] [gEgoStats skillNum])
			(if (> (+= [gEgoStats skillNum] (Random 1 3)) 200)
				(= [gEgoStats skillNum] 200)
			)
		)
		((< [gSkillTicks skillNum] 0)
			(+= [gSkillTicks skillNum] [gEgoStats skillNum])
			(if (< (-= [gEgoStats skillNum] (Random 1 3)) 5)
				(= [gEgoStats skillNum] 5)
			)
		)
		(else
			(return 0)
		)
	)
	(return 1)
)

(procedure (statCheck statNum statMult)
	(SkillUsed statNum statMult)
	(return (* [gEgoStats statNum] statMult))
)

(procedure (TakeDamage damage)
	(if (> damage 0)
		(SkillUsed 3 (Abs (/ (+ damage 1) 2))) ; Vitality
	)
	(if (< (-= [gEgoStats 16] damage) 0) ; health
		(= [gEgoStats 16] 0) ; health
	)
	(if (> [gEgoStats 16] (MaxHealth)) ; health
		(= [gEgoStats 16] (MaxHealth)) ; health
	)
	(return (> [gEgoStats 16] 0)) ; health
)

(procedure (UseStamina pointsUsed &tmp foo)
	(if (> pointsUsed 0)
		(SkillUsed 3 (/ (+ pointsUsed 3) 4)) ; Vitality
	)
	(cond
		((> (= foo (-= [gEgoStats 17] pointsUsed)) 4) ; stamina
			(ClearFlag 7)
			(if (> foo (MaxStamina))
				(= [gEgoStats 17] (MaxStamina)) ; stamina
			)
		)
		((>= foo 0))
		((TakeDamage (/ (- -3 [gEgoStats 17]) 4)) ; stamina
			(= [gEgoStats 17] 0) ; stamina
			(if (not (IsFlag 7))
				(SetFlag 7)
				(HighPrint 2 23) ; "You are so exhausted that everything you do hurts. Better get some rest."
			)
		)
		(else
			(EgoDead 0 2 24 #title {Sports are Healthy?} #icon 999 0 0) ; "Talk about over-exerting yourself... that last little maneuver wore you out so much it hurt. In fact, it hurt so much, it killed you. Take it easier next time."
		)
	)
)

(procedure (FindTime str &tmp whatDay)
	(= whatDay gDay)
	(if (and (== gTimeODay 6) (<= gClock 500))
		(-- whatDay)
	)
	(Format str 2 25 10 (+ 4 gTimeODay) whatDay) ; "%s on day %d."
)

(procedure (FixTime newClock newMinutes &tmp oldTime newTime)
	(= newTime gClock)
	(if (>= argc 1)
		(= newTime (* 150 newClock))
		(= gOldSysTime (GetTime 1)) ; SysTime12
		(if (>= argc 2)
			(+= newTime (/ (* 150 newMinutes) 60))
		)
	)
	(adjustTime newTime)
)

(procedure (adjustTime newTime &tmp oldTime)
	(= gClock (^ newTime $0001))
	(= oldTime gTimeODay)
	(cond
		((< gClock 300)
			(= gTimeODay 6)
		)
		((< gClock 750)
			(= gTimeODay 7)
		)
		(else
			(= gTimeODay (/ (- gClock 750) 450))
		)
	)
	(if (< 0 gTimeODay 4)
		(ClearFlag 115)
	)
	(if (> gTimeODay 4)
		(= gNight 1)
	else
		(= gNight 0)
	)
	(if (and (== gTimeODay 6) (!= oldTime 6))
		(if (== (++ gLostSleep) 1)
			(Print 2 26) ; "You are getting tired."
		else
			(Print 2 27) ; "You are exhausted from lack of sleep."
		)
	)
)

(procedure (NextDay)
	(++ gDay)
	(ClearFlag 161)
	(ClearFlag 168)
	(ClearFlag 169)
	(ClearFlag 177)
	(cond
		((and (OneOf gElementalState 1 3 5 7) (OneOf gDay 7 11 14 16))
			(gCurRoom newRoom: 340)
		)
		((> gDay 30)
			(gCurRoom newRoom: 790)
		)
		((OneOf gDay 5 8 12 14)
			(++ gElementalState)
		)
	)
)

(procedure (AdvanceTime addHours addMinutes &tmp newTime)
	(switch argc
		(1
			(= newTime (+ gClock (* 150 addHours)))
		)
		(2
			(= newTime (+ gClock (* 150 addHours) (/ (* 150 addMinutes) 60)))
		)
	)
	(^= newTime $0001)
	(if
		(or
			(and (< gClock 1100) (>= newTime 1100))
			(and (< gClock 2500) (or (>= newTime 2500) (< newTime gClock)))
		)
		(EatMeal)
	)
	(while (>= newTime 3600)
		(-= newTime 3600)
		(NextDay)
	)
	(adjustTime newTime)
)

(procedure (EatMeal)
	(cond
		(gFreeMeals
			(-- gFreeMeals)
		)
		([gInvNum 3] ; Food
			(if (not (-- [gInvNum 3])) ; Food
				(LowPrint 2 28) ; "You just ate your last ration; you'd better get some more food soon."
			)
		)
		((IsFlag 4)
			(SetFlag 5)
			(if (TakeDamage 1)
				(LowPrint 2 29) ; "You're starving. Better find some food *soon*!"
			else
				(EgoDead 0 2 30 #title {An Unbalanced Diet} #icon 999 1 1) ; "While it's true that some foods may be bad for your health, *no* food is even worse. You have, quite literally, starved to death."
			)
		)
		(else
			(SetFlag 4)
			(LowPrint 2 31) ; "You're really getting hungry."
		)
	)
)

(procedure (ToLower aChar)
	(if (or (< aChar 65) (> aChar 90))
		(return aChar)
	else
		(return (+ (- aChar 65) 97))
	)
)

(procedure (StrFind theString theWord &tmp len wordLen mainPtr wordPtr)
	(= wordLen (StrLen theWord))
	(for
		((= len (- (= len (StrLen theString)) wordLen)))
		(>= len 0)
		((-- len))
		
		(= wordPtr 0)
		(for ((= mainPtr len)) (< wordPtr wordLen) ((++ mainPtr))
			(if
				(!=
					(ToLower (StrAt theWord wordPtr))
					(ToLower (StrAt theString mainPtr))
				)
				(break)
			)
			(++ wordPtr)
		)
		(if (== wordPtr wordLen)
			(return (+ wordPtr 1))
		)
	)
	(return 0)
)

(procedure (LookFor event parseIt strings &tmp index inLine)
	(if
		(and
			(User canInput:)
			(not (event claimed:))
			(== (event type:) 4)
			(or
				(== (event message:) (User echo:))
				(<= 32 (event message:) 127)
			)
		)
		(event claimed: 1)
		(if (User getInput: event)
			(= inLine (User inputLineAddr:))
			(for ((= index 1)) (< index argc) ((++ index))
				(if (StrFind inLine [strings (- index 1)])
					(break)
				)
			)
			(if (== index argc)
				(= index 0)
				(if (and parseIt (Parse inLine event))
					(event type: 128)
					(event claimed: 0)
					(User said: event)
				)
			)
		)
	)
	(return index)
)

(procedure (StrToLower dest string1 string2 &tmp i len)
	(cond
		((>= argc 3)
			(GetFarText string1 string2 dest)
		)
		((>= argc 2)
			(StrCpy dest string1)
		)
	)
	(= len (StrLen dest))
	(for ((= i 0)) (< i len) ((++ i))
		(StrAt dest i (ToLower (StrAt dest i)))
	)
	(return dest)
)

(procedure (GotoPlaceAndTime &tmp [str 20] [theTime 20] [day 20] [arc 10] nr theDay)
	(= str 0)
	(StrCpy @theTime {8})
	(StrCpy @day {1})
	(StrCpy @arc {1})
	(= nr
		(PrintD
			{Where to?}
			41
			@str
			5
			{Day}
			4
			3
			41
			@day
			3
			{Time}
			41
			@theTime
			3
			101
			81
			{Intro}
			81
			{New Hero}
			81
			{Import}
		)
	)
	(= theDay (ReadNumber @day))
	(= gDay (= gElementalState 0))
	(while (>= (-- theDay) 0)
		(++ gDay)
		(if (OneOf gDay 5 7 8 11 12 14 16)
			(++ gElementalState)
			(if (== gDay 14)
				(++ gElementalState)
			)
		)
	)
	(FixTime (ReadNumber @theTime) 0)
	(switch nr
		(1
			(= nr (ReadNumber @str))
		)
		(2
			(= nr 750)
		)
		(3
			(= nr 800)
		)
		(4
			(= nr 805)
		)
	)
	(if nr
		(SetFlag 28)
	)
	(return nr)
)

(procedure (CantBePaladin)
	(if (SetFlag 153)
		(SkillUsed 14 -200) ; honor
	else
		(SkillUsed 14 -50) ; honor
	)
	(= gPossibleScore 500)
	(= gPaladinPoints 0)
	(= gHeroType gOrigHeroType)
)

(procedure (CheckPaladin &tmp ptValue)
	(if
		(and
			(not (IsFlag 153))
			(!= gHeroType 3) ; Paladin
			(>= gPaladinPoints 25)
			(>= [gEgoStats 14] 75) ; honor
		)
		(SkillUsed 14 200) ; honor
		(if (== gOrigHeroType 2)
			(= gPossibleScore 500)
		else
			(= gPossibleScore 550)
		)
		(SolvePuzzle 682 6 3)
		(= gHeroType 3) ; Paladin
		(gGame changeScore: gPaladinPoints)
	)
)

(procedure (SayThanks)
	(if (<= (++ gRoomThanks) 2)
		(SkillUsed 14 10) ; honor
		(SkillUsed 13 5) ; communication
	)
	(Say &rest)
)

(procedure (GiveFlowers)
	(if (gEgo use: 26 1) ; Flowers
		(SkillUsed 14 10) ; honor
		(SkillUsed 13 20) ; communication
		(Say &rest)
	else
		(HighPrint 2 32) ; "You don't have any flowers."
	)
)

