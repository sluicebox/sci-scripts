;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 91)
(include sci.sh)
(use Main)
(use n010)
(use Tactor)
(use goGet)
(use CDActor)
(use DCIcon)
(use Inventory)
(use Actor)
(use System)

(public
	proc91_0 0
	DisplayStart 1
	DisplayEnd 2
)

(local
	[local0 12] = [159 43 151 44 152 40 155 42 154 40 153 41]
)

(procedure (proc91_0)
	(= gTalkerIcon talkerIcon)
	((= gStorySet storySet)
		add: cindStory jackStory bremenStory snowStory beautyStory
		eachElementDo: #init
	)
	((= gEgoTravCodeSet egoTravCodeSet)
		add: bTravRC eTravCatC eTravDogC eTravDonC eTravSC eTravPC
	)
	((= gFriendTravCodeSet friendTravCodeSet)
		add: rTravC catTravC dogTravC donTravC sTravC pTravC
	)
	(= gCindStory cindStory)
	(= gJackStory jackStory)
	(= gBremenStory bremenStory)
	(= gSnowStory snowStory)
	(= gBeautyStory beautyStory)
	(Pumpkin setRegView: pumpkinV)
	(Slipper setRegView: slipperV)
	(Bag_of_beans setRegView: beansV)
	(Axe setRegView: axeV)
	(Rose setRegView: roseV)
	(Rooster setRegActor: roosterA)
	(Cat setRegActor: catA)
	(Dog setRegActor: dogA)
	(Donkey setRegActor: donkeyA)
	(Beauty setRegActor: beautyA)
	(Snow_White setRegActor: snowWhiteA)
	(Prince_Silver setRegActor: princeA)
	(Inv
		init:
		add:
			Pumpkin
			Slipper
			Bag_of_beans
			Axe
			Rooster
			Cat
			Dog
			Donkey
			Beauty
			Rose
			Snow_White
			Prince_Silver
	)
)

(class Class_91_0 of Obj
	(properties
		selectCode 0
		state 0
		selected 0
		selection 0
		done 0
		heardEp 0
		heardPro 0
	)

	(method (incSel)
		(= global142 self)
		(++ selection)
	)

	(method (incState)
		(++ state)
	)

	(method (inProgress)
		(return (if (and selected (not done)) 1 else 0))
	)
)

(instance Pumpkin of InvPossesion
	(properties
		view 800
		loop 2
		cursor 900
		signal 2
		description {You have the pumpkin.}
	)
)

(instance Slipper of InvPossesion
	(properties
		view 800
		loop 2
		cel 1
		cursor 900
		signal 2
		description {You have the slipper.}
	)
)

(instance Bag_of_beans of InvPossesion
	(properties
		name {Bag of beans}
		view 800
		loop 2
		cel 3
		cursor 900
		signal 2
		description {You have the bag of beans.}
	)
)

(instance Axe of InvPossesion
	(properties
		view 800
		loop 2
		cel 4
		cursor 900
		signal 2
		description {You have the axe.}
	)
)

(instance Rose of InvPossesion
	(properties
		view 800
		loop 2
		cel 2
		cursor 900
		signal 2
		description {You have the rose.}
	)
)

(instance Cat of InvFriend
	(properties
		view 801
		cursor 900
		signal 2
		description {The cat is with you.}
		owner 270
	)
)

(instance Dog of InvFriend
	(properties
		view 801
		cel 1
		cursor 900
		signal 2
		description {The dog is with you.}
		owner 250
	)
)

(instance Donkey of InvFriend
	(properties
		view 801
		cel 2
		cursor 900
		signal 2
		description {The donkey is with you.}
		owner 260
	)
)

(instance Rooster of InvFriend
	(properties
		view 801
		cel 3
		cursor 900
		signal 2
		description {The rooster is with you.}
		owner 220
	)
)

(instance Beauty of InvFriend
	(properties
		view 801
		loop -1
		cel 2
		cursor 900
		signal 2
		description {Beauty is with you.}
		owner 220
	)
)

(instance Snow_White of InvFriend
	(properties
		name {Snow White}
		view 801
		loop -1
		cursor 900
		signal 2
		description {Snow White is with you.}
	)
)

(instance Prince_Silver of InvFriend
	(properties
		name {Prince Silver}
		view 801
		loop -1
		cel 1
		cursor 900
		signal 2
		description {Prince Silver is with you.}
	)
)

(instance princeA of CDActor
	(properties
		description {Prince}
		lookStr {This man looks like a prince.}
		view 682
		talkerID 16
	)

	(method (setUp)
		((= talkerObj pSTO) setUp: princeSilBust princeSilEyes princeSilMouth)
	)
)

(instance pSTO of TalkerObj
	(properties
		x -1
		y 97
		nsTop 10
		nsLeft 108
		view 681
	)
)

(instance princeSilBust of View
	(properties
		nsTop 24
		nsLeft 44
		view 681
		loop 6
	)
)

(instance princeSilEyes of Prop
	(properties
		nsTop 31
		nsLeft 46
		view 681
		loop 4
		cycleSpeed 36
	)
)

(instance princeSilMouth of Prop
	(properties
		nsTop 41
		nsLeft 40
		view 681
		loop 2
		cycleSpeed 12
	)
)

(instance snowWhiteA of CDActor
	(properties
		description {Woman}
		lookStr {This is a very pretty woman.}
		view 672
		talkerID 15
	)

	(method (setUp)
		((= talkerObj sTO) setUp: snowBust snowEyes snowMouth)
	)
)

(instance sTO of TalkerObj
	(properties
		x -1
		y 97
		nsTop 10
		nsLeft 108
		view 671
	)
)

(instance snowBust of View
	(properties
		nsTop 22
		nsLeft 53
		view 671
		loop 6
	)
)

(instance snowEyes of Prop
	(properties
		nsTop 26
		nsLeft 54
		view 671
		loop 4
		cycleSpeed 36
	)
)

(instance snowMouth of Prop
	(properties
		nsTop 35
		nsLeft 47
		view 671
		loop 2
		cycleSpeed 12
	)
)

(instance roosterA of InvActor
	(properties
		view 634
		talkerID 6
	)

	(method (setUp)
		((= talkerObj rTO) setUp: roosterBust roosterEyes roosterMouth)
	)
)

(instance rTO of TalkerObj
	(properties
		x -1
		y 97
		nsTop 10
		nsLeft 116
		view 636
	)
)

(instance roosterBust of View
	(properties
		nsTop 15
		nsLeft 46
		view 636
		loop 6
	)
)

(instance roosterEyes of Prop
	(properties
		nsTop 19
		nsLeft 50
		view 636
		loop 4
		cycleSpeed 36
	)
)

(instance roosterMouth of Prop
	(properties
		nsTop 23
		nsLeft 48
		view 636
		loop 2
		cycleSpeed 12
	)
)

(instance donkeyA of CDAnimal
	(properties
		description {Donkey}
		lookStr {This is an old grey donkey.}
		view 632
		talkerID 9
		animRightX -20
		animRightY -27
		animLeftX 20
		animLeftY -27
		animFrontY -17
		animBackY -27
	)

	(method (setUp)
		((= talkerObj donTO) setUp: donkeyBust donkeyEyes donkeyMouth)
	)
)

(instance donTO of TalkerObj
	(properties
		x -1
		y 97
		nsTop 10
		nsLeft 108
		view 631
	)
)

(instance donkeyBust of View
	(properties
		nsTop 20
		nsLeft 45
		view 631
		loop 6
	)
)

(instance donkeyEyes of Prop
	(properties
		nsTop 25
		nsLeft 49
		view 631
		loop 4
		cycleSpeed 36
	)
)

(instance donkeyMouth of Prop
	(properties
		nsTop 34
		nsLeft 39
		view 631
		loop 2
		cycleSpeed 12
	)
)

(instance catA of CDAnimal
	(properties
		description {Cat}
		lookStr {The cat has white fur with orange spots.}
		view 642
		loop 2
		talkerID 7
		animRightX -8
		animRightY -10
		animLeftX 8
		animLeftY -10
		animFrontY -4
		animBackY -8
	)

	(method (setUp)
		((= talkerObj catTalkObj) setUp: catBust catEyes catMouth)
	)
)

(instance catTalkObj of TalkerObj
	(properties
		x -1
		y 97
		nsTop 10
		nsLeft 108
		view 641
	)
)

(instance catBust of View
	(properties
		nsTop 20
		nsLeft 39
		view 641
		loop 6
	)
)

(instance catEyes of Prop
	(properties
		nsTop 29
		nsLeft 43
		view 641
		loop 4
		cycleSpeed 36
	)
)

(instance catMouth of Prop
	(properties
		nsTop 41
		nsLeft 36
		view 641
		loop 2
		cycleSpeed 12
	)
)

(instance beautyA of CDActor
	(properties
		description {Woman}
		lookStr {This is a beautiful woman.}
		view 692
		talkerID 12
	)

	(method (setUp)
		((= talkerObj beautyTalkObj) setUp: beautyBust beautyEyes beautyMouth)
	)
)

(instance beautyTalkObj of TalkerObj
	(properties
		x -1
		y 97
		nsTop 10
		nsLeft 108
		view 691
	)
)

(instance beautyBust of View
	(properties
		nsTop 22
		nsLeft 48
		view 691
		loop 6
	)
)

(instance beautyEyes of Prop
	(properties
		nsTop 26
		nsLeft 50
		view 691
		loop 4
		cycleSpeed 36
	)
)

(instance beautyMouth of Prop
	(properties
		nsTop 35
		nsLeft 45
		view 691
		loop 2
		cycleSpeed 12
	)
)

(instance dogA of CDAnimal
	(properties
		description {Dog}
		lookStr {The dog is a brown and grey Scottie dog.}
		view 647
		loop 4
		talkerID 8
		animRightX -10
		animRightY -11
		animLeftX 10
		animLeftY -11
		animFrontY -10
		animBackY -9
	)

	(method (setUp)
		((= talkerObj dogTalkObj) setUp: dogBust dogEyes dogMouth)
	)
)

(instance dogTalkObj of TalkerObj
	(properties
		x -1
		y 97
		nsTop 10
		nsLeft 108
		view 646
	)
)

(instance dogBust of View
	(properties
		nsTop 22
		nsLeft 40
		view 646
		loop 6
	)
)

(instance dogEyes of Prop
	(properties
		nsTop 33
		nsLeft 48
		view 646
		loop 4
		cycleSpeed 36
	)
)

(instance dogMouth of Prop
	(properties
		nsTop 39
		nsLeft 41
		view 646
		loop 2
		cycleSpeed 12
	)
)

(instance axeV of InvView
	(properties
		description {Axe}
		lookStr {This is an axe for chopping wood.}
		view 800
		loop 1
		cel 4
	)
)

(instance pumpkinV of InvView
	(properties
		description {Pumpkin}
		lookStr {This is a large pumpkin.}
		view 800
		loop 1
	)
)

(instance slipperV of InvView
	(properties
		description {Slipper}
		lookStr {This is a slipper made of glass.}
		view 800
		loop 1
		cel 1
	)
)

(instance beansV of InvView
	(properties
		description {Bag of beans}
		lookStr {This is a bag of brightly colored beans.}
		view 800
		loop 1
		cel 3
	)
)

(instance roseV of InvView
	(properties
		description {Rose}
		lookStr {This is a beautiful rose.}
		view 800
		loop 1
		cel 2
		priority 10
	)
)

(instance bTravRC of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(gEgo setScript: bTravRScr 0 (gEgo selection:))
			)
		)
	)
)

(instance bTravRScr of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch register
					(0
						(proc10_13 0 gEgo roosterA self 1 91 0)
					)
					(1
						(proc10_13 0 gEgo roosterA self 1 91 1)
					)
					(2
						(proc10_13 0 gEgo roosterA self 1 91 2)
					)
					(else
						(proc10_13 0 gEgo roosterA self 1 91 3)
					)
				)
			)
			(1
				(switch register
					(0
						(proc10_13 3 roosterA gEgo self 1 91 4)
					)
					(1
						(proc10_13 0 roosterA gEgo self 1 91 5)
					)
					(2
						(proc10_13 0 roosterA gEgo self 1 91 6)
					)
					(else
						(proc10_13 0 roosterA gEgo self 1 91 7)
					)
				)
			)
			(2
				(if (== register 2)
					(proc10_13 0 gEgo roosterA self 1 91 8)
				else
					(gEgo incSel:)
					(self dispose:)
				)
			)
			(3
				(proc10_13 1 roosterA gEgo self 1 91 9)
			)
			(4
				(gEgo incSel:)
				(self dispose:)
			)
		)
	)
)

(instance eTravDogC of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (gEgo selection:)
					(0
						(proc10_13 0 gEgo dogA -1 1 91 10)
						(proc10_13 0 dogA gEgo -1 0 91 11)
						(proc10_13 0 dogA gEgo -1 1 91 12)
					)
					(1
						(proc10_13 0 gEgo dogA -1 1 91 13)
					)
					(2
						(proc10_13 0 gEgo dogA -1 1 91 14)
						(proc10_13 0 dogA gEgo -1 1 91 15)
						(proc10_13 0 gEgo dogA -1 1 91 16)
					)
					(else
						(proc10_13 0 gEgo dogA -1 1 91 17)
						(proc10_13 0 dogA dogA -1 1 91 18)
					)
				)
				(gEgo incSel:)
			)
		)
	)
)

(instance eTravCatC of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (gEgo selection:)
					(0
						(proc10_13 2 gEgo catA -1 1 91 19)
						(proc10_13 3 catA gEgo -1 0 91 20)
						(proc10_13 3 catA gEgo -1 0 91 21)
						(proc10_13 0 catA gEgo -1 0 91 22)
						(proc10_13 0 catA gEgo -1 0 91 23)
						(proc10_13 0 catA gEgo -1 1 91 24)
					)
					(1
						(proc10_13 0 gEgo catA -1 1 91 25)
						(proc10_13 3 catA gEgo -1 0 91 26)
						(proc10_13 3 catA gEgo -1 0 91 27)
						(proc10_13 3 catA gEgo -1 0 91 28)
						(proc10_13 3 catA gEgo -1 1 91 29)
					)
					(2
						(proc10_13 0 gEgo catA -1 1 91 30)
						(proc10_13 0 catA gEgo -1 0 91 31)
						(proc10_13 0 catA gEgo -1 1 91 32)
					)
					(else
						(proc10_13 0 gEgo catA -1 1 91 33)
						(proc10_13 0 catA gEgo -1 1 91 34)
					)
				)
				(gEgo incSel:)
			)
		)
	)
)

(instance eTravDonC of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (gEgo selection:)
					(0
						(proc10_13 2 gEgo donkeyA -1 1 91 10)
						(proc10_13 1 donkeyA gEgo -1 0 91 35)
						(proc10_13 0 donkeyA gEgo -1 1 91 36)
					)
					(1
						(proc10_13 0 gEgo donkeyA -1 1 91 37)
					)
					(2
						(proc10_13 0 gEgo donkeyA -1 1 91 38)
						(proc10_13 0 donkeyA gEgo -1 1 91 39)
					)
					(else
						(proc10_13 0 gEgo donkeyA -1 1 91 40)
						(proc10_13 0 donkeyA gEgo -1 1 91 41)
					)
				)
				(gEgo incSel:)
			)
		)
	)
)

(instance eTravSC of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (gEgo selection:)
					(0
						(proc10_13 3 gEgo snowWhiteA -1 1 91 42)
						(proc10_13 2 snowWhiteA gEgo -1 1 91 43)
						(proc10_13 3 gEgo snowWhiteA -1 1 91 44)
					)
					(1
						(proc10_13 2 gEgo snowWhiteA -1 1 91 45)
						(proc10_13 0 snowWhiteA gEgo -1 1 91 46)
					)
					(2
						(proc10_13 2 gEgo snowWhiteA -1 1 91 47)
						(proc10_13 0 snowWhiteA gEgo -1 1 91 48)
					)
					(else
						(proc10_13 2 gEgo snowWhiteA -1 1 91 49)
						(proc10_13 3 snowWhiteA gEgo -1 1 91 50)
					)
				)
				(gEgo incSel:)
			)
		)
	)
)

(instance eTravPC of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (gEgo selection:)
					(0
						(proc10_13 0 gEgo princeA -1 1 91 51)
						(proc10_13 2 princeA gEgo -1 1 91 52)
						(proc10_13 0 gEgo princeA -1 1 91 53)
						(proc10_13 3 princeA gEgo -1 1 91 54)
						(proc10_13 2 gEgo princeA -1 1 91 55)
						(proc10_13 0 princeA gEgo -1 1 91 56)
					)
					(1
						(proc10_13 2 gEgo princeA -1 1 91 57)
						(proc10_13 0 princeA gEgo -1 0 91 58)
						(proc10_13 0 princeA gEgo -1 0 91 59)
						(proc10_13 3 princeA gEgo -1 1 91 60)
					)
					(2
						(proc10_13 0 gEgo princeA -1 1 91 61)
						(proc10_13 3 princeA gEgo -1 1 91 62)
						(proc10_13 0 gEgo princeA -1 1 91 63)
						(proc10_13 3 princeA gEgo -1 1 91 64)
						(proc10_13 0 gEgo princeA -1 1 91 65)
						(proc10_13 1 princeA gEgo -1 1 91 66)
					)
					(else
						(proc10_13 2 gEgo princeA -1 1 91 67)
						(proc10_13 3 princeA gEgo -1 0 91 68)
						(proc10_13 0 princeA gEgo -1 0 91 69)
						(proc10_13 0 princeA gEgo -1 0 91 70)
						(proc10_13 0 princeA gEgo -1 0 91 71)
						(proc10_13 0 princeA gEgo -1 0 91 72)
						(proc10_13 0 princeA gEgo -1 1 91 73)
					)
				)
				(gEgo incSel:)
			)
		)
	)
)

(instance catTravC of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (catA selection:)
					(0
						(proc10_13 0 catA gEgo -1 1 91 74)
					)
					(1
						(proc10_13 3 catA gEgo -1 1 91 75)
					)
					(2
						(proc10_13 3 catA gEgo -1 1 91 76)
					)
					(else
						(proc10_13 0 catA gEgo -1 1 91 77)
					)
				)
				(catA incSel:)
			)
		)
	)
)

(instance rTravC of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (roosterA selection:)
					(0
						(proc10_13 0 roosterA gEgo -1 1 91 78)
					)
					(1
						(proc10_13 0 roosterA gEgo -1 1 91 79)
					)
					(2
						(proc10_13 0 roosterA gEgo -1 1 91 80)
					)
					(else
						(proc10_13 0 roosterA gEgo -1 1 91 81)
					)
				)
				(roosterA incSel:)
			)
		)
	)
)

(instance dogTravC of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (dogA selection:)
					(0
						(proc10_13 0 dogA gEgo -1 1 91 82)
					)
					(1
						(proc10_13 0 dogA gEgo -1 1 91 83)
					)
					(2
						(proc10_13 0 dogA gEgo -1 1 91 84)
					)
					(else
						(proc10_13 0 dogA gEgo -1 1 91 85)
					)
				)
				(dogA incSel:)
			)
		)
	)
)

(instance donTravC of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (donkeyA selection:)
					(0
						(proc10_13 0 donkeyA gEgo -1 1 91 86)
					)
					(1
						(proc10_13 0 donkeyA gEgo -1 1 91 87)
					)
					(2
						(proc10_13 0 donkeyA gEgo -1 1 91 88)
					)
					(else
						(proc10_13 0 donkeyA gEgo -1 1 91 89)
					)
				)
				(donkeyA incSel:)
			)
		)
	)
)

(instance sTravC of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (snowWhiteA selection:)
					(0
						(proc10_13 2 snowWhiteA gEgo -1 1 91 90)
					)
					(1
						(proc10_13 0 snowWhiteA gEgo -1 1 91 91)
					)
					(2
						(proc10_13 0 snowWhiteA gEgo -1 1 91 92)
					)
					(else
						(proc10_13 0 snowWhiteA gEgo -1 1 91 93)
					)
				)
				(snowWhiteA incSel:)
			)
		)
	)
)

(instance pTravC of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (princeA selection:)
					(0
						(proc10_13 0 princeA gEgo -1 0 91 94)
						(proc10_13 3 princeA gEgo -1 1 91 95)
					)
					(1
						(proc10_13 3 princeA gEgo -1 0 91 96)
						(proc10_13 0 princeA gEgo -1 1 91 97)
					)
					(2
						(proc10_13 2 princeA gEgo -1 1 91 98)
					)
					(else
						(proc10_13 3 princeA gEgo -1 0 91 99)
						(proc10_13 0 princeA gEgo -1 1 91 100)
					)
				)
				(princeA incSel:)
			)
		)
	)
)

(instance talkerIcon of DCIcon
	(properties)
)

(instance storySet of Set
	(properties)
)

(instance egoTravCodeSet of Set
	(properties)
)

(instance friendTravCodeSet of Set
	(properties)
)

(instance cindStory of Class_91_0
	(properties)
)

(instance jackStory of Class_91_0
	(properties)
)

(instance bremenStory of Class_91_0
	(properties)
)

(instance snowStory of Class_91_0
	(properties)
)

(instance beautyStory of Class_91_0
	(properties)
)

(instance onceUpon of View
	(properties
		x 50
		y 10
		view 830
	)
)

(instance livedHappy of View
	(properties
		x 42
		y 107
		view 830
		loop 1
	)
)

(instance DisplayStart of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(onceUpon setPri: 15 init:)
				(= seconds 5)
			)
			(1
				(onceUpon dispose:)
				(self dispose:)
			)
		)
	)
)

(instance DisplayEnd of HandsOffScript
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(livedHappy setPri: 15 init:)
				(= seconds 5)
			)
			(1
				(livedHappy dispose:)
				(self dispose:)
			)
		)
	)
)

