;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 251)
(include sci.sh)
(use Main)
(use n001)
(use Feature)
(use Actor)

(public
	InitFeatures250 0
)

(procedure (InitFeatures250)
	(InitFeatures cupboards codySuit happyFace box rosella dragon cookie cecil)
	(InitAddToPics
		steins
		wings
		stuff
		hats
		balloons
		puppets
		chickens
		enterprise
		antwerps
		helicopter
		orats
		fan
		tv
		octopus
		pillsbury
		nunHat
		spaceShip
		eyes
		frisbee
		toaster
		whoopies
	)
)

(instance steins of PicView
	(properties
		x 30
		y 12
		noun '/bottle,bottle,can,cup'
		description {the beer steins}
		lookStr {They are genuine, hand-crafted Spielburgian beer steins with Baron Stefan's crest.}
		view 250
		loop 2
		priority 12
		signal 16400
	)
)

(instance wings of PicView
	(properties
		x 33
		y 32
		noun '/wing'
		description {the wings}
		lookStr {They are waxen Icarus wings.__The label admonishes:___Do not attempt to use these wings in hot climates.}
		view 250
		loop 2
		cel 1
		priority 12
		signal 16400
	)
)

(instance stuff of PicView
	(properties
		x 31
		y 48
		noun '/stuff,item,megusalem'
		description {the various stuff}
		lookStr {On this shelf, there are various examples of stuff, things, and megusalems.}
		view 250
		loop 2
		cel 2
		priority 12
		signal 16400
	)
)

(instance hats of PicView
	(properties
		x 32
		y 64
		noun '/hat'
		description {the hats}
		lookStr {The top hats on the bottom are tops 'cause he bought 'em.}
		view 250
		loop 2
		cel 3
		priority 12
		signal 16400
	)
)

(instance balloons of PicView
	(properties
		x 29
		y 80
		noun '/balloon'
		description {the balloons}
		lookStr {They're the buffoon's balloons, ya' Goon.}
		view 250
		loop 2
		cel 4
		priority 12
		signal 16400
	)
)

(instance puppets of PicView
	(properties
		x 33
		y 97
		view 250
		loop 2
		cel 5
		priority 12
		signal 16400
	)
)

(instance chickens of PicView
	(properties
		x 86
		y 58
		noun '/chicken'
		description {the rubber chickens}
		lookStr {A lady once asked Keapon for liniment with which "to rub her chickens," but he thought she said "two rubber chickens."__Oddly, she never paid for them or took them home.}
		view 250
		loop 1
		cel 4
		priority 10
		signal 16400
	)
)

(instance enterprise of PicView
	(properties
		x 129
		y 55
		noun '/enterprise,enterprise'
		description {the starship}
		lookStr {No, you're wrong.__It's the USS Exitprise.}
		view 250
		loop 1
		cel 3
		priority 8
		signal 16400
	)
)

(instance antwerps of PicView
	(properties
		x 134
		y 109
		noun '/antwerp'
		description {the Baby Antwerps}
		lookStr {Well, they're either eggplants or that new doll called "Baby Antwerp" which, when turned on its back, promptly explodes.}
		view 250
		loop 1
		cel 1
		priority 8
		signal 16400
	)
)

(instance helicopter of PicView
	(properties
		x 122
		y 74
		noun '/helicopter'
		description {the helicopter}
		lookStr {Keapon calls it a Self-Motivating Horizontally-Situated Windmill.__Then again, it might be a giant.}
		view 250
		loop 1
		cel 2
		priority 8
		signal 16400
	)
)

(instance orats of PicView
	(properties
		x 114
		y 112
		noun '/orat,stick'
		description {the orats}
		lookStr {You'll have to agree that these are quite clearly "Orats-On-A-Stick."__Extremely useful.__Somewhere.}
		view 250
		loop 1
		priority 8
		signal 16400
	)
)

(instance fan of PicView
	(properties
		x 289
		y 27
		noun '/fan'
		description {the fan}
		lookStr {This was Keapon's biggest fan until things took a turn for the worse.__Keapon grew tired of being blade for a fool.}
		view 250
		priority 10
		signal 16400
	)
)

(instance tv of PicView
	(properties
		x 287
		y 47
		noun '/television'
		description {the television}
		lookStr {Don't watch this so much.__You'll ruin your eyes!}
		view 250
		cel 1
		priority 10
		signal 16400
	)
)

(instance octopus of PicView
	(properties
		x 289
		y 87
		noun '/octopus'
		description {the octopus-like thing with wings}
		lookStr {You don't want to know.}
		view 250
		cel 2
		priority 10
		signal 16400
	)
)

(instance pillsbury of PicView
	(properties
		x 264
		y 33
		noun '/doll'
		description {the Pillsboory Doeboy}
		lookStr {The Michelin Man?__The StayPuft MarshMallow Man?__No, it's the Doughbury Pills Boy!}
		view 250
		cel 3
		signal 16384
	)
)

(instance nunHat of PicView
	(properties
		x 262
		y 52
		noun '/hat'
		description {the nun hat}
		lookStr {Nuns are often in the habit of wearing these with their habit.}
		view 250
		cel 4
		signal 16384
	)
)

(instance spaceShip of PicView
	(properties
		x 262
		y 67
		noun '/ship<space'
		description {the space ship}
		lookStr {?}
		view 250
		cel 5
		signal 16384
	)
)

(instance eyes of PicView
	(properties
		x 262
		y 95
		noun '/eye'
		description {the orbs}
		lookStr {These orbs look vaguely familiar...}
		view 250
		cel 6
		signal 16384
	)
)

(instance frisbee of PicView
	(properties
		x 313
		y 67
		noun '/frisbee'
		description {the frisbee}
		lookStr {It's a Flippy Flier Model XLR8 Frisbee.}
		view 250
		cel 8
		priority 15
		signal 16400
	)
)

(instance toaster of PicView
	(properties
		x 312
		y 88
		noun '/oven'
		description {the toaster}
		lookStr {You can burn two pieces of toast at once with this baby.___Now, if only someone would invent electricity.__And maybe an outlet and extension cord.}
		view 250
		cel 9
		priority 15
		signal 16400
	)
)

(instance whoopies of PicView
	(properties
		x 313
		y 110
		noun '/cushion'
		description {the whoopee cushions}
		lookStr {Ah ha!__So the windbag's been pushin' whoopee cushions!}
		view 250
		cel 10
		priority 15
		signal 16400
	)
)

(instance cupboards of Feature
	(properties
		x 31
		y 111
		noun '/armoire,door'
		nsTop 97
		nsBottom 125
		nsRight 63
		description {the cupboards}
		lookStr {These cupboards are closed, but undoubtedly contain more oddments.}
	)
)

(instance codySuit of Feature
	(properties
		x 87
		y 47
		noun '/chainmail,disguise'
		nsTop 36
		nsLeft 74
		nsBottom 59
		nsRight 101
		description {the Commando Cody suit}
		lookStr {The label on the sleeve says "Commando Cody Flying Suit".}
	)
)

(instance happyFace of Feature
	(properties
		x 87
		y 131
		z 60
		noun '/face,design,chuckle'
		nsTop 60
		nsLeft 73
		nsBottom 80
		nsRight 101
		description {the happy face}
		lookStr {You suddenly feel compelled to have a nice day.}
	)
)

(instance box of Feature
	(properties
		x 12
		y 56
		noun '/box'
		nsTop 50
		nsBottom 63
		nsRight 24
		description {the green box}
		lookStr {It is a green box for holding red pencils.}
	)
)

(instance rosella of Feature
	(properties
		x 13
		y 88
		noun '/rosella,(puppet<rosella)'
		nsTop 80
		nsLeft 6
		nsBottom 96
		nsRight 21
		description {the rosella puppet}
		lookStr {It is a hand puppet bearing the name Rosella.}
	)
)

(instance dragon of Feature
	(properties
		x 28
		y 88
		noun '/dragon,(puppet<dragon)'
		nsTop 80
		nsLeft 21
		nsBottom 96
		nsRight 35
		description {the dragon puppet}
		lookStr {It is a dragon hand puppet.}
	)
)

(instance cookie of Feature
	(properties
		x 42
		y 88
		noun '/monster<cookie,(puppet<monster<cookie)'
		nsTop 81
		nsLeft 35
		nsBottom 96
		nsRight 49
		description {the Cookie Monster puppet}
		lookStr {It is a hand puppet labeled "Cookie Monster".__How odd!}
	)
)

(instance cecil of Feature
	(properties
		x 56
		y 87
		noun '/cecil,pinhead,ollie,(puppet<cecil,pinhead,ollie)'
		nsTop 79
		nsLeft 49
		nsBottom 95
		nsRight 63
		description {the Cecil/Ollie/Zippy puppet}
		lookStr {It is a hand puppet that is either Cecil the Seasick Sea Serpent, Ollie the Dragon, or Zippy the Pinhead, depending on which way you squint.}
	)
)

